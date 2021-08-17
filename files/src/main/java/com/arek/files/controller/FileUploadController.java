package com.arek.files.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileUploadController {

//    private final FileStorageService fileStorageService;

    @GetMapping("/test")
    public String testController() {
        return "Test ok";
    }
}
