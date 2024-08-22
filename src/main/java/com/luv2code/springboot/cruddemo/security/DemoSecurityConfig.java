package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails hayashi = User.builder()
				.username("hayashi")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();

		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails miyu = User.builder()
				.username("miyu")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();

		return new InMemoryUserDetailsManager(hayashi, mary, miyu);		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer ->
		
		configurer
		          .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
		          .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
		          .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
		          .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
		          .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")	          
				);
		
		// use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
























