package com.arek.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.arek.application", "com.arek.domain"})
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "com.arek.domain.repositories")
@EntityScan(basePackages = "com.arek.domain.entities")
public class JupiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JupiterApplication.class, args);
    }

    // TODO: 11.08.2021
    //  2) zwrocic z resta plik moze to byc wygenerowany pdf
    //  3) obsluzyc zwracanie wyjatków (wykorzystac advaice)
    //  5) dodac spring security

}
