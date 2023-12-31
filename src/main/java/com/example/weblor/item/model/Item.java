package com.example.weblor.item.model;


import com.example.weblor.common.BaseEntity;
import com.example.weblor.user.model.WUser;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@Enumerated(EnumType.STRING)
	private Status status = Status.UNOCCUPIED;
}
