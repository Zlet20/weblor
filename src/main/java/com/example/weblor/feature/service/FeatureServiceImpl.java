package com.example.weblor.feature.service;

import org.springframework.stereotype.Service;

import com.example.weblor.feature.model.StudentInfo;

import jakarta.validation.Valid;

@Service
public class FeatureServiceImpl implements FeatureService{

	@Override
	public void registerToUseItem(@Valid StudentInfo dto, Long itemId) {
		
	}

}
