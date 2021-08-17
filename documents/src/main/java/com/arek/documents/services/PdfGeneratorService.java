package com.arek.documents.services;

import com.arek.documents.generators.PdfGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class PdfGeneratorService {

    private final PdfGenerator pdfGenerator;

    public File generateExamplePdf() throws Exception {
        return pdfGenerator.generatePdf("welcome",
                Collections.singletonMap("name", "Spring Boot 2"));
    }
}
