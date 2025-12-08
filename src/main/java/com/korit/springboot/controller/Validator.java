package com.korit.springboot.controller;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    // 이메일: 일반적인 이메일 형식
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

    // 비밀번호: 8~20자, 대문자/소문자/숫자/특수문자 포함
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$";

    // 이름: 한글/영어 가능, 2~20자
    private static final String NAME_REGEX =
            "^[A-Za-z가-힣]{2,20}$";

    public void validateEmail(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }
    }

    public void validatePassword(String password) {
        if (!password.matches(PASSWORD_REGEX)) {
            throw new IllegalArgumentException("비밀번호는 8~20자, 영문/숫자/특수문자를 포함해야 합니다.");
        }
    }

    public void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("이름 형식이 올바르지 않습니다.");
        }
    }
}