package com.example.weblor.feature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weblor.feature.model.PdfFile;
import com.example.weblor.feature.model.StudentInfo;
import com.example.weblor.feature.service.FeatureService;
import com.example.weblor.feature.service.PdfFileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/features")
public class FeatureController {
	@Autowired
	private FeatureService service;
	
	@Autowired
	private PdfFileService pdfService;
	@PostMapping("/{itemId}/{pdfId}")
	public Object riegisterToUseItem(@Valid @RequestBody StudentInfo dto,
			@PathVariable("itemId") Long itemId,
			@PathVariable("pdfId") Long pdfId) {
		service.registerToUseItem(dto,itemId);
		PdfFile pdfFile = pdfService.getPdfFileById(pdfId);

		return pdfFile.getContent();
	}
	
	@PostMapping()
	public String inputForm(@PathVariable String filePath,@PathVariable String fileName ) {
		pdfService.savePdfFileToDatabase(filePath,fileName);
		return "Success";	
	}
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
		PdfFile pdfFile = pdfService.getPdfFileById(id);

        if (pdfFile != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", pdfFile.getFilename());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfFile.getContent());
        }

        return ResponseEntity.notFound().build();
    }
	
}
