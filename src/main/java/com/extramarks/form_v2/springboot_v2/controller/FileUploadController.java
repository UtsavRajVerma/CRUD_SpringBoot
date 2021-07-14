package com.extramarks.form_v2.springboot_v2.controller;

import com.extramarks.form_v2.springboot_v2.fileHelper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("profilePicture")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize()+" Bytes");
        System.out.println(file.getContentType());
        System.out.println(file.getName());

        try {
            //Validation 1
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Picture not uploaded!");
            }

            //Validation 2
            if (!(file.getContentType().equals("image/jpg") || file.getContentType().equals("image/png") || file.getContentType().equals("image/jpeg"))) {
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("File type not supported!");
            }

            //File Upload
            boolean uploadStatus=fileUploadHelper.fileUploaded(file);
            if(uploadStatus){
//                return ResponseEntity.ok("File upload successful!");
                return ResponseEntity.ok(ServletUriComponentsBuilder     // -> Gives localhost or server path -> localhost:9191
                        .fromCurrentContextPath().path("/image/")        // -> localhost:9191/image/
                        .path(file.getOriginalFilename())               // -> localhost:9191/image/<File Name>
                        .toUriString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again!");
    }

}
