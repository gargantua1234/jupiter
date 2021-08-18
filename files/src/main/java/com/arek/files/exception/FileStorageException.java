package com.arek.files.exception;

public class FileStorageException extends RuntimeException {

    public FileStorageException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
