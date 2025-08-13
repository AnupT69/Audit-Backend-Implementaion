package com.auditbackend.Audit.Backend.Implementaion.Services;

import com.auditbackend.Audit.Backend.Implementaion.Models.Role;
import com.auditbackend.Audit.Backend.Implementaion.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void updateUserRole(Long userId , String roleName);

    List<User> getAllUsers();

    User findByUserName(String username);

    List<Role> getAllRoles();

    Optional<User> findByEmail(String email);

    User registerUser(User user);
}
