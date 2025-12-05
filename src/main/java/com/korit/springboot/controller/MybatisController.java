package com.korit.springboot.controller;

import com.korit.springboot.dto.RequestDto;
import com.korit.springboot.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MybatisController {


    @Autowired
    private StudyMapper studyMapper;

    // @Autowired 달면 주입이 된다


    @PostMapping("/mybatis/study")
    public ResponseEntity<?> insert(@RequestBody RequestDto dto) {
        studyMapper.insert(dto.getName(), dto.getAge());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mybatis/study")
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        return ResponseEntity.ok(studyMapper.findAll());
    }

    @GetMapping("/mybatis/study/names")
    public ResponseEntity<List<String>> getNames() {
        return ResponseEntity.ok(studyMapper.findAllName());
    }

}
