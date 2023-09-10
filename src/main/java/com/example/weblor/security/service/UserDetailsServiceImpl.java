package com.example.weblor.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.weblor.user.model.WUser;
import com.example.weblor.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		WUser user = repository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: " + username));

		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
}
