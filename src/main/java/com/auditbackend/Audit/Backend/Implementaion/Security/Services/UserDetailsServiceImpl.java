package com.auditbackend.Audit.Backend.Implementaion.Security.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auditbackend.Audit.Backend.Implementaion.Models.User;
import com.auditbackend.Audit.Backend.Implementaion.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUserName(username).orElseThrow(()->new RuntimeException("User not found with username: "+username));
		
		return UserDetailsimpl.build(user);
	}
	

}


//UserDetails--> UserDetailSImpl :- 
//UserDetailsService --> implements
