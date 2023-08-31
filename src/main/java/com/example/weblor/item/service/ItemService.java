package com.example.weblor.item.service;

import java.util.List;

import com.example.weblor.item.dto.ItemDTO;
import com.example.weblor.item.dto.ItemResponseDTO;
import com.example.weblor.item.model.Status;

import jakarta.validation.Valid;

public interface ItemService {

	ItemResponseDTO createItem(@Valid ItemDTO rq);

	ItemResponseDTO findById(Long id);

	List<ItemResponseDTO> getAllItem();
	
	List<ItemResponseDTO> getItemByStatus(Status status);

	ItemResponseDTO updateItemById(Long id, ItemDTO dto) ;

	void deleteItem(Long id);

}
