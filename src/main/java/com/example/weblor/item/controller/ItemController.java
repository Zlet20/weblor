package com.example.weblor.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weblor.item.dto.ItemDTO;
import com.example.weblor.item.dto.ItemResponseDTO;
import com.example.weblor.item.model.Status;
import com.example.weblor.item.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemService service;
	
	
	@PostMapping
	public Object createItem(@Valid @RequestBody ItemDTO rq,BindingResult result) {
		if(result.hasErrors()){
			return result;
		}
		ItemResponseDTO rp = service.createItem(rq);
		 return rp; 
	}
	
	@GetMapping("/{id}")
	public Object getItem(@PathVariable("id") Long id) {
		ItemResponseDTO rp = service.findById(id);
		 return rp; 
	}
		
	@GetMapping("/all")
	public Object getAllItem() {
		List<ItemResponseDTO> rp = service.getAllItem();
		return rp;
	}
	
	@GetMapping("/status")
	public Object getItemByStatus(@PathVariable Status status) {
		List<ItemResponseDTO> rp = service.getItemByStatus(status);
		return rp;
	}
	
	@PutMapping("/{id}")
	public Object updateItem(@PathVariable("id") Long id,@RequestBody ItemDTO dto) {
		ItemResponseDTO rp = service.updateItemById(id,dto);
		return rp;
	}
	
	@DeleteMapping("/{id}")
	public String deleteItem(@PathVariable("id") Long id) {
		service.deleteItem(id);
		return "Delete success";
		
	}
	
	
	
}
