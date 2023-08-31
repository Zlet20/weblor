package com.example.weblor.feature.model;

import java.util.UUID;

import com.example.weblor.common.BaseEntity;
import com.example.weblor.item.model.Item;
import com.example.weblor.item.model.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "pdf_file")
public class PdfFile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String filename;

    @Lob
    private byte[] content;
}
