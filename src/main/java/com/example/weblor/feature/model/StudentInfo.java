package com.example.weblor.feature.model;

import java.time.LocalDate;
import java.util.UUID;

import com.example.weblor.item.model.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "student_info")
public class StudentInfo {
	private UUID id;
	private String classNumberName;
	@NotBlank(message = "name.not-blank")
	private String name;
	
	@Email(message = "{email.invalid}")
	@Size(min = 3, max = 100, message = "{user.email.size}")
	@NotBlank(message = "{user.email.not-blank}")
	private String email;
	
	
	 @OneToOne(mappedBy = "student")
	private UsageInfo usageInfo;

}
