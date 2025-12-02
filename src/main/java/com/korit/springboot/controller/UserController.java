package com.korit.springboot.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// 1.
// RestController -> 데이터 응답만 담당 (데이터 요청과 응답을 처리)
/*
* RestfulAPI -> 뷰는 없다
* 컨트롤러 다음에 레이어 -> 서비스 -> 레퍼지토리 -> 데이터베이스
*
*
* */
@RestController
public class UserController {

    private String username = "test12";
    private String password = "1234";

    // 서블릿의 doGet -> 하나만 가능
    // 클래스 안에 메서드로 -> 여러 개 가능
    @GetMapping("/info")
    public ResponseEntity<String> printInfo() {
        return ResponseEntity.ok("UserController!!!");
    }


    // url을 따로따로 하지 말고
//    @GetMapping("/users")
//    public Map<String, String> getUsers(HttpServletResponse response) {
//        // JSON 형태로 요청하지 않았지만 JSON으로 응답이 오도록
//        response.setStatus(400);
//        response.setContentType("applicaion/json");
//        return Map.of("username", username , "password", password);
//    }


    // url을 따로따로 하지 말고
    @GetMapping("/users")
    public ResponseEntity<Map<String, String>> getUsers(HttpServletResponse response) {
        // JSON 형태로 요청하지 않았지만 JSON으로 응답이 오도록
//        response.setStatus(400);
//        response.setContentType("applicaion/json");
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("username", username , "password", password));
    }
}
