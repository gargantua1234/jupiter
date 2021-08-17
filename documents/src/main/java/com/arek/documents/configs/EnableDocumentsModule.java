package com.arek.documents.configs;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DocumentsConfig.class)
public @interface EnableDocumentsModule {
}
