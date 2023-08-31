package com.example.weblor.feature.service;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.weblor.feature.model.PdfFile;
import com.example.weblor.feature.repository.PdfFileRepository;

@Service
public class PdfFileServiceImpl implements PdfFileService {
	@Autowired
	private PdfFileRepository repository;

	@Transactional
	public void savePdfFileToDatabase(String filePath, String fileName) {
		try (FileInputStream fis = new FileInputStream(new File(filePath))) {
			byte[] content = fis.readAllBytes();
			PdfFile pdfFile = new PdfFile();
			pdfFile.setFilename(fileName);
			pdfFile.setContent(content);
			repository.save(pdfFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public PdfFile getPdfFileById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
