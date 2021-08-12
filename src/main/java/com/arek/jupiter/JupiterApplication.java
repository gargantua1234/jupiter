package com.arek.jupiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:db.properties")
public class JupiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JupiterApplication.class, args);
    }

    // TODO: 11.08.2021
    //  2) zwrocic z resta plik moze to byc wygenerowany pdf
    //  3) obsluzyc zwracanie wyjatków (wykorzystac advaice)
    //  4) podzielic plik na moduly
    //  5) dodac spring security



}
