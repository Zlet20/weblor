package com.example.weblor.common.validation.validator;


import com.example.weblor.common.validation.annotation.Email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String>{
	private String message;

	@Override
	public void initialize(Email email) {
		message = email.message();
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if(email.contains("@hcmut.edu.vn")) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}

}
