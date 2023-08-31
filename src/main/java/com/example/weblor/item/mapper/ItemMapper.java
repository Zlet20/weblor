package com.example.weblor.item.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.weblor.item.dto.ItemDTO;
import com.example.weblor.item.dto.ItemResponseDTO;
import com.example.weblor.item.model.Item;

@Mapper
public interface ItemMapper {
	ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
	
	Item toModel(ItemDTO dto);
	
	ItemResponseDTO toItemResponseDTO (Item item);
}
