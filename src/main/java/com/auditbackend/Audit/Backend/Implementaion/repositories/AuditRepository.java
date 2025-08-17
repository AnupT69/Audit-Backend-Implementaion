package com.auditbackend.Audit.Backend.Implementaion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditbackend.Audit.Backend.Implementaion.Models.AuditLog;

public interface AuditRepository extends JpaRepository<AuditLog, Long>{

}
