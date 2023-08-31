package com.example.weblor.common.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.weblor.common.validation.validator.UniqueNameValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = UniqueNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UniqueName {
	String message() default "Name already used.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
