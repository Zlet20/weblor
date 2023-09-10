package com.example.weblor.security.dto;


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
public class LoginRequestDTO {
	@NotBlank(message = "{username.not-blank}")
	private String username;
	@Size(min = 8, max = 64)
	@NotBlank(message = "{password.not-blank}")
	private String password;
}
