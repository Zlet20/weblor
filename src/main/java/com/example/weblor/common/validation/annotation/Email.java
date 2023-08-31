package com.example.weblor.common.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.weblor.common.validation.validator.EmailValidator;
import com.example.weblor.common.validation.validator.UniqueNameValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = EmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Email {
	String message() default "Email invalid.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
