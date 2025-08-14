package com.auditbackend.Audit.Backend.Implementaion.Security.Services;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.auditbackend.Audit.Backend.Implementaion.Models.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetailsimpl implements UserDetails{
	
	private Long id;
	private String username;
	private String email;
	
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsimpl(Long id , String username,String email,String password ,Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UserDetailsimpl build(User user) {
		GrantedAuthority  authority = new SimpleGrantedAuthority(user.getRole().getRoleName().name());
		return new UserDetailsimpl(user.getUserId(),user.getUserName(),user.getEmail(),user.getPassword(),List.of(authority));
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}
