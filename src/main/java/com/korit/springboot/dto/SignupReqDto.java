package com.korit.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class SignupReqDto {
    private String username;
    private String password;
    private String name;
    private String email;
}
