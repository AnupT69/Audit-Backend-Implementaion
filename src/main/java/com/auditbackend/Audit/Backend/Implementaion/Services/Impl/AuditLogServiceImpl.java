package com.auditbackend.Audit.Backend.Implementaion.Services.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auditbackend.Audit.Backend.Implementaion.Models.AuditAction;
import com.auditbackend.Audit.Backend.Implementaion.Models.AuditLog;
import com.auditbackend.Audit.Backend.Implementaion.Services.AuditLogService;
import com.auditbackend.Audit.Backend.Implementaion.repositories.AuditRepository;

@Service
public class AuditLogServiceImpl implements AuditLogService{

	@Autowired
	AuditRepository auditRepository;
	@Override
	public void logLoginUser(String username,String ipAddress) {
	AuditLog log = new AuditLog();
	log.setAuditAction(AuditAction.LOGIN);
	log.setUsername(username);
	log.setTimeStamp(LocalDateTime.now());
	log.setIpAddress(ipAddress);
	auditRepository.save(log);
	}

	@Override
	public List<AuditLog> getAllAuditLogs() {
		
		return auditRepository.findAll();
	}

	@Override
	public void logUpdateRole(String username,String ipAddress) {
		AuditLog log = new AuditLog();
		log.setAuditAction(AuditAction.UPDATE_ROLE);
		log.setUsername(username);
		log.setIpAddress(ipAddress);
		log.setTimeStamp(LocalDateTime.now());
		auditRepository.save(log);
	}

	@Override
	public void logRegisterUser(String username, String ipAddress) {
		AuditLog log = new AuditLog();
		log.setAuditAction(AuditAction.REGISTER_USER);
		log.setUsername(username);
		log.setIpAddress(ipAddress);
		log.setTimeStamp(LocalDateTime.now());
		auditRepository.save(log);
		
	}

	@Override
	public void logLogoutUser(String username) {
		// TODO Auto-generated method stub
		AuditLog log = new AuditLog();
		log.setAuditAction(AuditAction.LOGOUT);
		log.setUsername(username);
		log.setIpAddress("");
		log.setTimeStamp(LocalDateTime.now());
		auditRepository.save(log);
		
	}
	

}
