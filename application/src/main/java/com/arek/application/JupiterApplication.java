package com.arek.application;

import com.arek.documents.configs.EnableDocumentsModule;
import com.arek.documents.services.PdfGenerationService;
import com.arek.files.configs.EnableFileModule;
import com.arek.files.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.arek.application",
        "com.arek.domain",
        "com.arek.exception"})
@PropertySource("classpath:db.properties")
@EnableJpaRepositories("com.arek.domain.repositories")
@EntityScan("com.arek.domain.entities")
@EnableFileModule
@EnableDocumentsModule
public class JupiterApplication implements CommandLineRunner {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private PdfGenerationService pdfGenerator;

    public static void main(String[] args) {
        SpringApplication.run(JupiterApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        fileStorageService.initializeDirectory();
        pdfGenerator.generateExamplePdf();
    }


    // TODO: 11.08.2021
    //  2) zwrocic z resta plik moze to byc wygenerowany pdf
    //  5) dodac spring security
    //  6) potestowac konfiguracje obiektów json
    //  7) dodać testowanie klas controllera
    //  8) 

}
