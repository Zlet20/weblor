package com.example.weblor.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.weblor.security.jwt.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration   {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtAuthorizationFilter jwtAuthFilter;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider autheProvider = new DaoAuthenticationProvider();

		autheProvider.setUserDetailsService(userDetailsService);
		autheProvider.setPasswordEncoder(getPasswordEncoder());
		return autheProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
		final List<GlobalAuthenticationConfigurerAdapter> configurers = new ArrayList<>();
        configurers.add(new GlobalAuthenticationConfigurerAdapter() {
                    @Override
                    public void configure(AuthenticationManagerBuilder auth) throws Exception {
                        
                    }
                }
        );
		return authConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors();

		// SESSION -> STATELESS
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// CSRF
		http.csrf().disable();

		// JWT FILTER
		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

	
		
		http.authorizeHttpRequests(
		        auth -> auth.requestMatchers("/api/v1/**").permitAll()
				.requestMatchers("/api/v1/auth/**").permitAll()
				.requestMatchers("/api/v1/users/password").permitAll()
				.anyRequest().authenticated());
		return http.build();
	}
}
