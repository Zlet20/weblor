package com.example.weblor.user.model;

import java.util.ArrayList;
import java.util.List;

import com.example.weblor.common.BaseEntity;
import com.example.weblor.feature.model.UsageInfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name = "w_user")
public class WUser extends BaseEntity{
	private String username;

	private String password;

	private String email;
	
	}
