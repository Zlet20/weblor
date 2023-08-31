package com.example.weblor.item.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.weblor.item.model.Item;
import com.example.weblor.item.model.Status;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	Optional<Item> findByItemName(String itemName);


	List<Item> findItemByStatus(Status status);


	boolean existsByName(String name);

}
