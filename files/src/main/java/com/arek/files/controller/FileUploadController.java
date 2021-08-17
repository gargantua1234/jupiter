package com.arek.files.controller;

import com.arek.files.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileStorageService fileStorageService;

    @GetMapping("/test")
    public String testController() {
        return "Test ok";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String uploadFile(@RequestParam final MultipartFile file) {
        fileStorageService.save(file);
        return "File Uploaded";
    }
}
