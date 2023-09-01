package com.example.weblor.item.dto;

import java.util.UUID;

import com.example.weblor.item.model.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ItemResponseDTO {
	private UUID id;
	private String name;
	private Status status;
}
