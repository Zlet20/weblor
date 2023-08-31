package com.example.weblor.item.dto;


import com.example.weblor.common.validation.annotation.UniqueName;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ItemDTO {
	@UniqueName(message = "{uniquename.existed}")
	@NotBlank(message = "{name.not-blank}")	
private String name;
}
