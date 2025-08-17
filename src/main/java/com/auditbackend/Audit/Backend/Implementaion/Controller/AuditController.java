package com.auditbackend.Audit.Backend.Implementaion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auditbackend.Audit.Backend.Implementaion.Models.AuditLog;
import com.auditbackend.Audit.Backend.Implementaion.Services.AuditLogService;

@RestController
@RequestMapping("/api/audit")
public class AuditController {
	
	@Autowired
	AuditLogService auditLogService;
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<AuditLog> getAuditLogs(){
		return auditLogService.getAllAuditLogs();
	}

}
