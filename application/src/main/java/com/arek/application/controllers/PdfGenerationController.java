package com.arek.application.controllers;

import com.arek.documents.services.PdfGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/generate-pdf")
@RequiredArgsConstructor
public class PdfGenerationController {

    private final PdfGenerationService pdfGenerationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Resource> getExamplePdf() throws Exception {
        final File pdfFile = pdfGenerationService.generateExamplePdf();
        final Resource resource = new UrlResource(pdfFile.toURI());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
