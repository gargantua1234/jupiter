package com.arek.files.service;

import com.arek.files.exception.FileStorageException;
import com.arek.files.resource.DirectoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InDirectoryStorage implements FileStorageService {

    private final DirectoryResource directoryResource;

    @Override
    public void initializeDirectory() {
        try {
            final Path tmpDirectory = Paths.get(directoryResource.getTmpPath());
            if (Files.notExists(tmpDirectory)) {
                Files.createDirectories(tmpDirectory);
            }
        } catch (IOException exception) {
            throw new FileStorageException("Could not initialize directory");
        }
    }

    @Override
    public void save(final MultipartFile file) {
        try {
            final Path tmpPath = Paths.get(directoryResource.getTmpPath());
            Files.copy(file.getInputStream(), tmpPath.resolve(
                    Objects.requireNonNull(file.getOriginalFilename())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
