package com.arek.files.service;

import com.arek.files.exception.FileStorageException;
import com.arek.files.resource.DirectoryResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class InDirectoryStorage implements FileStorageService {

    private final Path tmpDirectory;

    public InDirectoryStorage(final DirectoryResource directoryResource) {
        tmpDirectory = Paths.get(directoryResource.getTmpPath());
    }

    @Override
    public void initializeDirectory() {
        try {
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
            Files.copy(file.getInputStream(),
                    tmpDirectory.resolve(Objects.requireNonNull(file.getOriginalFilename())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
