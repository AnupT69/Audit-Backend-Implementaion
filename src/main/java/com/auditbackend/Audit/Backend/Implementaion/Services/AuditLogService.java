package com.auditbackend.Audit.Backend.Implementaion.Services;



import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.auditbackend.Audit.Backend.Implementaion.Models.AuditLog;
import com.auditbackend.Audit.Backend.Implementaion.repositories.AuditRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AuditLogService {
	
	private final AuditRepository auditRepository;
	private final ObjectMapper objectMapper;
	
	public AuditLogService(AuditRepository auditRepository,ObjectMapper objectMapper) {
		this.auditRepository=auditRepository;
		this.objectMapper = objectMapper;
	}
	
	@Async("auditLogTaskExecutor")
	public void logEvent(String module,String action,String entityType,String status,String remarks,String ipAddress)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId="system";
		String userRole="SYSTEM";
		if(authentication !=null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
			userId = authentication.getName();
			userRole=authentication.getAuthorities().stream().findFirst().map(grantedAuthority->grantedAuthority.getAuthority()).orElse("UNKNOWN");
		}
		
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		AuditLog auditLog = new AuditLog();
		auditLog.setUserId(userId);
		auditLog.setUserRole(userRole);
		auditLog.setModule(module);
		auditLog.setAction(action);
		auditLog.setStatus(status);
		
		auditLog.setEntityType(entityType);
		auditLog.setIpAddress(ipAddress);
		auditLog.setRemarks(remarks);
		
		auditRepository.save(auditLog);
		
	}
	


}
