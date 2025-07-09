package com.zidio.zidioconnect.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadService{


    @Value("${file.upload-dir}")
    private String UploadDir; //Reads the upload path (D:/Workspace/zidio/upload) from the properties file.

// Below method handles file upload:
    public String upload(MultipartFile file)throws IOException {
        Path path = Paths.get(UploadDir); // Convert the folder path into a Path object (e.g., D:/Workspace/zidio/upload)
        // below one Creates the upload folder if it doesn't already exist
        if(!Files.exists(path)) {

            Files.createDirectories(path);
        }


        String fileName = UUID.randomUUID()+"_"+file.getOriginalFilename(); // Generates a unique filename by prepending a UUID to avoid overwriting existing files.
        Path targetPath= path.resolve(fileName);
        Files.copy(file.getInputStream(),targetPath, StandardCopyOption.REPLACE_EXISTING); // saves the uploaded file into server folder

        return "/files/"+fileName; // Returns a custom path string (not the real file system path) — just used later to generate download URL.



    }
}
