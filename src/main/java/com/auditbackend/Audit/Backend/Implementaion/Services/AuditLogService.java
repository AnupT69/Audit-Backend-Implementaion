package com.auditbackend.Audit.Backend.Implementaion.Services;

import java.util.List;

import com.auditbackend.Audit.Backend.Implementaion.Models.AuditLog;

public interface AuditLogService {
	void logLoginUser(String username,String ipAddress);
	
	List<AuditLog> getAllAuditLogs();
	
	void logUpdateRole(String username,String ipAddress);
	
	void logRegisterUser(String username,String ipAddress);
	

}
