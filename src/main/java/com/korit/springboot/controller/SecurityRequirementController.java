package com.korit.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.apache.ibatis.annotations.Options;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRequirementController {

    @Operation(security = @SecurityRequirement(name = "Bearer Authentication"))
    @GetMapping("/api/security")
    public ResponseEntity<?> get(){

        return ResponseEntity.ok("응답");
    }
}