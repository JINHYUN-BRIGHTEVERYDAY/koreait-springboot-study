package com.korit.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ExceptionController {

    // 특정 예외가 터지면 강제로 낚아채기 -> 대신 응답하기
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> duplicatedException(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

}
