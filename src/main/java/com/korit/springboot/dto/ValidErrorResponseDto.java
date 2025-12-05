package com.korit.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidErrorResponseDto {
    private final String fieldName;
    private final String message;
}
