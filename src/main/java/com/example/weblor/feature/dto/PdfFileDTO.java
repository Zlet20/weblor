package com.example.weblor.feature.dto;

import com.example.weblor.feature.model.PdfFile;

import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PdfFileDTO {
	private String filename;

    @Lob
    private byte[] content;
}
