package com.springboot.fileupload.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;

@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(MultipartException.class)
    public String multipartExceptionError(MultipartException e){
        e.getStackTrace();
        System.out.println(e.getCause().getMessage());
        return "upload  error";
    }
}
