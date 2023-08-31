package com.example.weblor.feature.service;

import com.example.weblor.feature.model.StudentInfo;

import jakarta.validation.Valid;

public interface FeatureService {

	void registerToUseItem(@Valid StudentInfo dto, Long id);

}
