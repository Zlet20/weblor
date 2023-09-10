package com.example.weblor.common.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHelper {
	private ResponseHelper() {}
	
	public static ResponseEntity<Object> getResponse(Object obj, HttpStatus status, boolean isError){
		Map<String, Object> map = new HashMap<>();
		if(!isError) {
			map.put("content",obj);
			map.put("hasError", isError);
			map.put("errors","");
		}
		if(isError){
			map.put("content",null);
			map.put("hasError", isError);
			if(obj instanceof BindingResult) {
				map.put("errors", ErrorHelper.getAllError((BindingResult) obj));
			}
			if(obj instanceof String) {
				map.put("errors", obj);
			}
		}
		
		map.put("timestamp", LocalDateTime.now());
		map.put("status", status.value());
		return new ResponseEntity<>(map,status);
	}
}
