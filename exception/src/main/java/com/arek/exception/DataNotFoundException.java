package com.arek.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataNotFoundException extends RuntimeException {
    private final String message;
}
