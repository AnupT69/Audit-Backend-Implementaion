package com.auditbackend.Audit.Backend.Implementaion.repositories;

import com.auditbackend.Audit.Backend.Implementaion.Models.AppRole;
import com.auditbackend.Audit.Backend.Implementaion.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
