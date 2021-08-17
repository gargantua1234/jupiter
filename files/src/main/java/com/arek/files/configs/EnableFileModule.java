package com.arek.files.configs;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FileModuleConfiguration.class)
public @interface EnableFileModule {
}
