package com.example.weblor.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weblor.user.model.WUser;

public interface UserRepository extends JpaRepository<WUser, UUID>{

	Optional<WUser> findByUsername(String username);

}
