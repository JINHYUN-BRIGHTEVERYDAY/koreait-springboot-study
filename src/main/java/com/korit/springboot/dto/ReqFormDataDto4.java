package com.korit.springboot.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReqFormDataDto4 {
    private String name;
    private int age;
    private MultipartFile file;
}
