package com.example.employee.jpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.employee.jpa.service.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder){
		/*UserDetails admin =User.withUsername("Swathi")
				.password( encoder.encode("swathi"))
				.roles("ADMIN")
				.build();
		UserDetails user =User.withUsername("Ron")
				.password(encoder.encode("ron"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin,user);*/
		return new UserInfoUserDetailsService();
		
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return  http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/api/addUser").permitAll()
				.and()
				.authorizeHttpRequests()
				.requestMatchers("/api/employees/**").authenticated()
				.and().formLogin()
				.and().build();
	}
 
		/*return http.csrf().disable()
			.authorizeRequests()
			.requestMatchers("/api/employees/**").authenticated()
			.and().formLogin()
			.and().build();*/
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
