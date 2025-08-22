package com.auditbackend.Audit.Backend.Implementaion.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.auditbackend.Audit.Backend.Implementaion.CustomAnnotation.Auditable;
import com.auditbackend.Audit.Backend.Implementaion.Services.AuditLogService;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuditLogAspect {
	
	@Autowired
	private AuditLogService auditService;
	
	private String getClientIpAddress() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return "UNKNOWN"; // e.g. async/background job
        }
        HttpServletRequest request = attributes.getRequest();
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
	
	@AfterReturning(value = "@annotation(auditable)",returning = "result")
	public void auditAfterSuccess(JoinPoint joinPoint , Auditable auditable,Object result) {
		String ip = getClientIpAddress();
		auditService.logEvent(auditable.module(), auditable.action(), auditable.entityType(), "SUCCESS",null,ip);
		
	}
	
	@AfterThrowing(value = "@annotation(auditable)",throwing = "ex")
	public void auditAfterFailure(JoinPoint joinPoint,Auditable auditable,Exception ex) {
		String ip = getClientIpAddress();
		auditService.logEvent(auditable.module(), auditable.action(), auditable.entityType(), "FAILED", ex.getMessage(),ip);
	}
	
	

}
