package com.alpha.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alpha.EntityClasses.Ent;

public class CustomUserDetails implements UserDetails{
	//private Ent user;
	
	private String username;
	private String password;
	
	public CustomUserDetails(Ent user) {
		/*
		 * super(); this.username = user.getUsername(); this.password =
		 * user.getPassword();
		 */
		username = user.getUsername();
		password = user.getPassword();
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	

	@Override
	public String getPassword() {
		return password;
		//return user.getPassword();
	}

	@Override
	public String getUsername() {
		return username;
		//return user.getUsername();
	}
	

}
