package com.example.weblor.feature.service;

import com.example.weblor.feature.model.PdfFile;

public interface PdfFileService {
	void savePdfFileToDatabase(String filePath, String fileName);

	PdfFile getPdfFileById(Long id);
}
