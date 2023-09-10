package com.example.weblor.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.weblor.user.model.WUser;
import com.example.weblor.common.exception.BusinessException;
import com.example.weblor.security.dto.LoginRequestDTO;
import com.example.weblor.security.jwt.JwtHelper;
import com.example.weblor.user.repository.UserRepository;

@Service
@PropertySources({ @PropertySource("classpath:/validation/message.properties") })
public class AuthServiceImpl implements AuthService{

    @Value("${user.password.not-equals}")
    private String messagePasswordNotEquals;

   

    @Autowired
    private UserRepository userRepository;

   
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
	private JwtHelper jwts;

    @Override
    public String login(LoginRequestDTO loginDTO) {
		Optional<WUser> userOpt = userRepository.findByUsername(loginDTO.getUsername());
		
		String encodedPassword = userOpt.get().getPassword();
		
		if(!encoder.matches(loginDTO.getPassword(), encodedPassword)) {
			throw new BusinessException(messagePasswordNotEquals);
		}
		
		return jwts.generateJwtToken(loginDTO.getUsername());
    }
}
