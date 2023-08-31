package com.example.weblor.item.model;


import com.example.weblor.common.BaseEntity;
import com.example.weblor.user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter

@Entity
@Table(name = "w_item")
public class Item extends BaseEntity{
	private String name ;
	
	private Status status = Status.UNOCCUPIED;
}
