package com.springboot.fileupload.UploadController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class MultipartFileController {
    private static String UPLOAD_FOLDER = "D://uploadFile//";

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file){

        try {
            if(file.isEmpty()){
                System.out.println("请选择要上传的文件");
                return "请选择要上传的文件";
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("upload success");
            return "upload success";
        } catch (IOException e) {
            e.printStackTrace();
            return "upload fail";
        }


    }

}
