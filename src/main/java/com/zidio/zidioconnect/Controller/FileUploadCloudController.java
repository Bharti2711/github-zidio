package com.zidio.zidioconnect.Controller;

import com.zidio.zidioconnect.service.FileUploadCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/file/cloud")
public class FileUploadCloudController {

    @Autowired
    private FileUploadCloudService fileUploadCloudService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String cloudUrl = fileUploadCloudService.upload(file);
        return ResponseEntity.ok(Map.of("ResumeUrl", cloudUrl));
    }
}
