package com.auditbackend.Audit.Backend.Implementaion.Models;

import java.time.Instant;


import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "audit_log", indexes = {
	    @Index(name = "idx_audit_log_user_id", columnList = "user_id"),
	    @Index(name = "idx_audit_log_timestamp", columnList = "timestamp"),
	    @Index(name = "idx_audit_log_module_action", columnList = "module, action"),
	    @Index(name = "idx_audit_log_entity_type", columnList = "entity_type")
	})
public class AuditLog {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "timestamp",nullable = false)
	private Instant timestamp;
	
	@Column(name = "user_id",nullable = false)
	private String userId;
	
	@Column(name = "user_role",nullable = false)
	private String userRole;
	
	@Column(name = "ip_address",length = 45)
	private String ipAddress;
	
	@Column(name = "module",nullable = false,length = 50)
	private String module;
	
	@Column(name = "action",nullable = false,length = 20)
	private String action;
	
	@Column(name = "entity_type",length = 50)
	private String entityType;
	
	
	
	@Column(name = "status", nullable = false, length = 20)
    private String status;
    
    @Column(name = "remarks", length = 1000)
    private String remarks;
    public AuditLog() {
        this.timestamp = Instant.now();
    }
	
	
    public AuditLog(String userId, String userRole, String module, String action, String status) {
        this();
        this.userId = userId;
        this.userRole = userRole;
        this.module = module;
        this.action = action;
        this.status = status;
    }
	
	


}
