package com.korit.springboot.controller;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    @PostMapping("/api/users")
    public ResponseEntity<Map<String, Integer>> create(@Valid @RequestBody CreateUserReqDto createUserReqDto) throws MethodArgumentNotValidException {
        // @Valid 검증은 Controller 메서드에 `@Valid` 어노테이션이 있어야 작동합니다.
        // 현재 코드에는 `@Valid`가 빠져 있으니 아래처럼 추가하는 것을 권장합니다.
        // public ResponseEntity<?> create(@RequestBody @Valid CreateUserReqDto createUserReqDto) { ... }

        userService.duplicatedUsername(createUserReqDto.getUsername());
        int createdUserId = userService.createUser(createUserReqDto);
//        userService.createUser(createUserReqDto);
        return ResponseEntity.ok(Map.of("cretedUserId", createdUserId));
    }
}