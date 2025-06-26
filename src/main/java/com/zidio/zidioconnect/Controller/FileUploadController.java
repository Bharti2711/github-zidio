package com.zidio.zidioconnect.Controller;


import com.zidio.zidioconnect.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("api/file")

public class FileUploadController{


    @Autowired
    private FileUploadService fileUploadservice;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>>upload(@RequestParam("file") MultipartFile file)throws IOException {
        Path path = Path.of(fileUploadservice.upload(file));
        String url = "/api/file/" + path.getFileName().toString();
        return ResponseEntity.ok(Map.of("ResumeUrl",url));

    }
    @GetMapping("/{fileName}")

    public ResponseEntity<Resource>download(@PathVariable String fileName) throws IOException{

        Path path = Paths.get("upload/resumes").resolve(fileName);
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
    }
}

