package com.arek.exception.com.arek.exception.handler;

import com.arek.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> getDataNotFoundHandler(final DataNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
