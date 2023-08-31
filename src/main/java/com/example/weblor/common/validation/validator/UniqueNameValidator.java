package com.example.weblor.common.validation.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.weblor.common.validation.annotation.UniqueName;
import com.example.weblor.item.model.Item;
import com.example.weblor.item.repository.ItemRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String>{
	private String message;
	
	@Autowired
	private ItemRepository repository;
	@Override
	public void initialize(UniqueName uniqueName) {
		message = uniqueName.message();
	}
	
	@Override
	public boolean isValid(String itemName, ConstraintValidatorContext context) {
		Optional<Item> itemOpt = repository.findByItemName(itemName);
		
		if(itemOpt.isEmpty()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}

}
