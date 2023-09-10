package com.example.weblor.security.service;

import com.example.weblor.security.dto.LoginRequestDTO;


public interface AuthService {

	String login( LoginRequestDTO rq);

}
