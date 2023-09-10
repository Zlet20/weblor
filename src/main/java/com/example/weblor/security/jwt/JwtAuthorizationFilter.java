package com.example.weblor.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtHelper helper;
	
	@Autowired
	private UserDetailsService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = helper.getToken(request);
		
		if(helper.validate(token)) {
			String username = helper.getUsername(token);
			UserDetails userDetails = service.loadUserByUsername(username);
			Authentication auth 
				= new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			
		}
		filterChain.doFilter(request, response);
		
	}
}
