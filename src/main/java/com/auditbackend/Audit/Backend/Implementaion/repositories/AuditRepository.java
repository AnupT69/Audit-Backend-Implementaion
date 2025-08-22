package com.auditbackend.Audit.Backend.Implementaion.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.auditbackend.Audit.Backend.Implementaion.Models.AuditLog;

@Repository
public interface AuditRepository extends JpaRepository<AuditLog, Long>,JpaSpecificationExecutor<AuditLog>{
	
List<AuditLog> findByUserId(String userId,Pageable pageable);
List<AuditLog> findByModuleAndAction(String module,String action,Pageable pageable);
List<AuditLog> findByEntityType(String entityType,Pageable pageable);
}
