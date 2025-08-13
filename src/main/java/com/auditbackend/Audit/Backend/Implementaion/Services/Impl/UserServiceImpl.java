package com.auditbackend.Audit.Backend.Implementaion.Services.Impl;

import com.auditbackend.Audit.Backend.Implementaion.Models.AppRole;
import com.auditbackend.Audit.Backend.Implementaion.Models.Role;
import com.auditbackend.Audit.Backend.Implementaion.Models.User;
import com.auditbackend.Audit.Backend.Implementaion.Services.UserService;
import com.auditbackend.Audit.Backend.Implementaion.repositories.RoleRepository;
import com.auditbackend.Audit.Backend.Implementaion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void updateUserRole(Long userId, String roleName) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        AppRole appRole = AppRole.valueOf(roleName);
        Role role = roleRepository.findByRoleName(appRole).orElseThrow(()->new RuntimeException("Role Not found"));
        user.setRole(role);
        userRepository.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        Optional<User> user = userRepository.findByUserName(username);
        return user.orElseThrow(()->new RuntimeException("User not found"));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User registerUser(User user) {
        if(user.getPassword()!=null)
        {
            user.setPassword(user.getPassword());
            return userRepository.save(user);
        }
        return user;
    }
}
