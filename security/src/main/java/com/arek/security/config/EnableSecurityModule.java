package com.arek.security.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AppSecurityConfig.class)
public @interface EnableSecurityModule {
}
