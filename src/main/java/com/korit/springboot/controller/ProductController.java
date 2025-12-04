package com.korit.springboot.controller;

import com.korit.springboot.dto.ProductDto;
import com.korit.springboot.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;


    @PostMapping("mybatis/product")
    public ResponseEntity<?> insert(@RequestBody ProductDto dto) {
        productMapper.insert(dto.getProductName(), dto.getProductSize(), dto.getProductPrice());
        return ResponseEntity.ok().build();
    }

}
