package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	//Hard coded security 
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//
//		UserDetails john = User.builder()
//				.username("john")
//				.password("{noop}test123")
//				.roles("USER")
//				.build();
//
//		UserDetails mary = User.builder()
//				.username("mary")
//				.password("{noop}test123")
//				.roles("ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(john, mary);
//
//	}
	
	
	//Add support for JDBC
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//Define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?"
				);
		
		//Define query to retrieve authorities by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?"
				);
		
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http.authorizeHttpRequests(configurer ->

	        configurer
	            .requestMatchers("/students/studentList").hasAnyRole("USER", "ADMIN") // Both roles can access
	            .requestMatchers("/students/**").hasRole("ADMIN") // Only ADMIN can access other /students endpoints
	            .anyRequest().authenticated() // All other requests must be authenticated

	    )
	    .formLogin(form -> form
	            .loginPage("/showLoginPage")
	            .loginProcessingUrl("/authenticateTheUser")
	            .defaultSuccessUrl("/students/studentList", true) // Redirect on success
	            .permitAll()
	    )
	    .logout(logout -> logout.permitAll()
	    )
	    .exceptionHandling(configurer ->
	            configurer.accessDeniedPage("/access-denied"));

	    return http.build();
	}

}






