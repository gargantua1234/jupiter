package com.arek.files.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    void initializeDirectory();

    void save(final MultipartFile file);
}
