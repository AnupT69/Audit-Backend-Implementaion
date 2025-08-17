package com.auditbackend.Audit.Backend.Implementaion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auditbackend.Audit.Backend.Implementaion.Models.Role;
import com.auditbackend.Audit.Backend.Implementaion.Models.User;
import com.auditbackend.Audit.Backend.Implementaion.Services.AuditLogService;
import com.auditbackend.Audit.Backend.Implementaion.Services.UserService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.*;
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuditLogService auditlogService;
	
	@GetMapping("/getusers")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@PutMapping("/update-role")
	public ResponseEntity<String> updateUserRole(@RequestParam Long userId,@RequestParam String roleName,HttpServletRequest request){
		String ipAddress = request.getHeader("");
		if(ipAddress == null || ipAddress.isEmpty())
		{
			ipAddress = request.getRemoteAddr();
		}
		userService.updateUserRole(userId, roleName);
		
		
		return ResponseEntity.ok("User role updated");
	}
	
	@GetMapping("/roles")
	public List<Role> getAllRoles(){
		return userService.getAllRoles();
		
	}
	
	

}
