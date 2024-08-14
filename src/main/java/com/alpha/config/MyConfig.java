package com.alpha.config;
//import org.springframework.security.core.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alpha.EntityClasses.Ent;

@Configuration
@EnableWebSecurity

public class MyConfig{
	@Autowired
	private JwtFilter jwtFilter;

	private final UserDetailsService userDetailsService;
	//private final PasswordEncoder passwordEncoder;
	
	@Autowired
	MyConfig(UserDetailsImpl userDetailsImpl){
			this.userDetailsService = userDetailsImpl;
		}

		  @Bean 
		  public BCryptPasswordEncoder paswordEncoder() {
			  return new BCryptPasswordEncoder();
		  
		  }
		  
		  @Bean 
		  public AuthenticationProvider authenticationProvider() {
	
		  DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		  
		  authProvider.setUserDetailsService(userDetailsService);
		  authProvider.setPasswordEncoder(paswordEncoder());
		  
		  return authProvider; 
		  }
	
		 
	 

		  
		  //AuthnticationManager will talk to authentication provider
		  
		  @Bean
		  public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception {
			  return config.getAuthenticationManager();
		  }
		  
		  
		  @Bean
		    public WebMvcConfigurer corsConfigurer() {
		        return new WebMvcConfigurer() {
		            @Override
		            public void addCorsMappings(CorsRegistry registry) {
		                registry.addMapping("/**")
		                        .allowedOrigins("http://localhost:8080") // Adjust as needed
		                        .allowedMethods("*");
		            }
		        };
		    }
		  
			

		  
		  @Bean
		  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		      http
		          .authorizeHttpRequests(auth -> auth
		              .requestMatchers("/views/**","/signup","/authlogin","/login").permitAll()
		              .requestMatchers(HttpMethod.POST,"/login").permitAll()
		        	  .requestMatchers(HttpMethod.POST,"/authlogin").permitAll()
		              .requestMatchers(HttpMethod.POST,"/signup").permitAll()
		              .anyRequest().authenticated()
		             // .anyRequest().permitAll()
		              
		          )
		          .formLogin(login -> login
		              .loginPage("/login")
		             // .loginProcessingUrl("/authlogin")  // This should match the form action URL
		             // .defaultSuccessUrl("/homee", true)  // Redirect to /homee on successful login
		              .permitAll()
		          )
		       
		          .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		          .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
		          .logout(logout -> logout.logoutSuccessUrl("/login")
		        		 
		              .permitAll()
		          );
		      
		          http.csrf(csrf -> csrf.disable());
//		      http.csrf(csrf -> csrf.disable()
//		    		  .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class));
	      http.cors(Customizer.withDefaults());
		      return http.build();
		  }


}
