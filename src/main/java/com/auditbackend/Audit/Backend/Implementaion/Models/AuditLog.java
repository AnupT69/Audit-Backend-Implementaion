package com.auditbackend.Audit.Backend.Implementaion.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {
	
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long Id;
	
	
	private String username;
	
	@Enumerated(EnumType.STRING)
	private AuditAction auditAction;
	
	
	private String ipAddress;
	
	private LocalDateTime timeStamp;

}
