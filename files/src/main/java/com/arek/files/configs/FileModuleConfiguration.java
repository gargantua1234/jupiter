package com.arek.files.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.arek.files")
@PropertySource("classpath:directory.properties")
public class FileModuleConfiguration {
}
