package com.example.weblor.item.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.weblor.common.exception.BusinessException;
import com.example.weblor.item.dto.ItemDTO;
import com.example.weblor.item.dto.ItemResponseDTO;
import com.example.weblor.item.mapper.ItemMapper;
import com.example.weblor.item.model.Item;
import com.example.weblor.item.model.Status;
import com.example.weblor.item.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository repository;
	
	 @Value("${name.existed}")
	    private String errorsNameExisted;
	@Override
	public ItemResponseDTO createItem(ItemDTO dto) {
			Item rp = repository.save(ItemMapper.INSTANCE.toModel(dto));
		return ItemMapper.INSTANCE.toItemResponseDTO(rp);
	}


	@Override
	public ItemResponseDTO findById(Long id) {
		Optional<Item> rp = repository.findById(id);
		return ItemMapper.INSTANCE.toItemResponseDTO(rp.get());
	}


	@Override
	public List<ItemResponseDTO> getAllItem() {
		List<Item> rp = repository.findAll();
		return rp.stream().map(ItemMapper.INSTANCE::toItemResponseDTO).collect(Collectors.toList());
	}
	
	@Override
	public List<ItemResponseDTO> getItemByStatus(Status status) {
		List<Item> rp = repository.findItemByStatus(status);
		return rp.stream().map(ItemMapper.INSTANCE::toItemResponseDTO).collect(Collectors.toList());
	}


	@Override
	public ItemResponseDTO updateItemById(Long id,ItemDTO dto) {
		Item rp = repository.findById(id).get();
		
		if(isValidString(dto.getName())) {
			if (!rp.getName().equals(dto.getName()) && repository.existsByName(dto.getName())) {
                throw new BusinessException(errorsNameExisted);
			
		}
			rp.setName(dto.getName());
			
		}
			
		return ItemMapper.INSTANCE.toItemResponseDTO(repository.save(rp));
	}
	 private boolean isValidString(String s) {
	        if (s == null || s.length() == 0) {
	            return false;
	        }
	        return true;
	    }


	@Override
	public void deleteItem(Long id) {
		if(!repository.existsById(id)) {
			throw new BusinessException("Id not existed");
		}
		repository.deleteById(id);
		
	}
}
