package com.example.weblor.common;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@Id
	@GeneratedValue
	protected UUID id;

	@Version
	protected int version;

	@CreatedDate
	protected LocalDateTime createdAt;

	@CreatedBy
	protected String createdBy;

	@LastModifiedDate
	protected LocalDateTime lastModifiedAt;

	@LastModifiedBy
	protected String lastModifiedBy;
}
