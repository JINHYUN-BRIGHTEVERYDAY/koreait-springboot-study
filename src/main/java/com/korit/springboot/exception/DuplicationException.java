package com.korit.springboot.exception;

import com.korit.springboot.dto.ValidErrorResponseDto;
import lombok.Getter;


// 중복 예외처리
public class DuplicationException extends RuntimeException {
    @Getter
    private ValidErrorResponseDto validErrorResponseDto;
//    private String fieldName;
//    private String defaultMessage;


    public DuplicationException(String fieldName, String message) {
        super(message);
//        this.fieldName = fieldName;
//        this.defaultMessage = message1;
        this.validErrorResponseDto = new ValidErrorResponseDto(fieldName, message);
    }


}
