package com.korit.springboot.controller;

import com.korit.springboot.dto.ValidErrorResponseDto;
import com.korit.springboot.exception.DuplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    // 특정 예외가 터지면 강제로 낚아채기 -> 대신 응답하기
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> duplicatedException(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidErrorResponseDto>> validException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new LinkedHashMap<>();

        e.getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
//            System.out.println(error.getField());
//            System.out.println(error.getDefaultMessage());
        });

        List<ValidErrorResponseDto> errors = e.getFieldErrors()
                .stream()
                .map(error -> new ValidErrorResponseDto(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DuplicationException.class)
    public ResponseEntity<ValidErrorResponseDto> duplicatedException(DuplicationException e) {
        return ResponseEntity.badRequest().body(e.getValidErrorResponseDto());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> authenticationException(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> authenticationException(BadCredentialsException e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }

}
