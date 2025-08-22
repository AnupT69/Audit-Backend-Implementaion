package com.auditbackend.Audit.Backend.Implementaion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auditbackend.Audit.Backend.Implementaion.Models.AuditLog;
import com.auditbackend.Audit.Backend.Implementaion.repositories.AuditRepository;

@RestController
@RequestMapping("/api/audit")
public class AuditController {
	
	@Autowired
	private AuditRepository auditRepository;
	
	@GetMapping
	public List<AuditLog> getAllAudits(){
		return auditRepository.findAll();
	}

}
