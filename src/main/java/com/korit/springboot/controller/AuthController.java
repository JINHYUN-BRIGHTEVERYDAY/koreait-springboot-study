package com.korit.springboot.controller;

import com.korit.springboot.dto.SigninReqDto;
import com.korit.springboot.dto.SignupReqDto;
import com.korit.springboot.service.AuthService;
import com.korit.springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupReqDto requestDto) {

        authService.signup(requestDto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/api/auth/signin")
    public ResponseEntity<Map<String, String>> signin(@Valid @RequestBody SigninReqDto dto) {
        return ResponseEntity.ok(Map.of("accessToken", authService.signin(dto)));
    }



}
