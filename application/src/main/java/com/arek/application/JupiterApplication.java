package com.arek.application;

import com.arek.documents.configs.EnableDocumentsModule;
import com.arek.files.configs.EnableFileModule;
import com.arek.files.service.FileStorageService;
import com.arek.security.config.EnableSecurityModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@EnableSecurityModule
public class JupiterApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(JupiterApplication.class);

    @Autowired
    private FileStorageService fileStorageService;

    public static void main(String[] args) {
        SpringApplication.run(JupiterApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        LOGGER.info("Starting command line runner run method");
        fileStorageService.initializeDirectory();
        LOGGER.info("Ending command line runner run method");
    }

    // TODO: 11.08.2021
    //  5) dodac spring security
    //  6) potestowac konfiguracje obiektów json
    //  7) dodać testowanie klas controllera
    //  8) dodać logowanie oparte na aop
}
