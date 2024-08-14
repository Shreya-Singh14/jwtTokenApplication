package com.alpha.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alpha.EntityClasses.Ent;
import com.alpha.repository.Repo;

@Component
public class UserDetailsImpl implements UserDetailsService{
	@Autowired
	private Repo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Ent user= repo.findByUsername(username);
//		
//		if(user==null) {
//			
//			 System.out.println("User not found");
//			
//			throw new UsernameNotFoundException("Could not find specified user");
//		}
//		CustomUserDetails customUserDetails=new CustomUserDetails(user);
//		return customUserDetails;
		
		Optional<Ent> user = repo.findByUsername(username);
		
		return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Not found"));
	}

}
