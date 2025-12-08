package com.korit.springboot.service;

import com.korit.springboot.dto.SigninReqDto;
import com.korit.springboot.dto.SignupReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;


//    public void signup(SignupReqDto dto) {
//
//
//
//        // 2) 이메일 중복 확인
//
//        if (userMapper.existsByEmail(dto.getEmail())) {
//            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
//        }
//
//        // 3) 비밀번호 암호화
//        String encodedPassword = passwordEncoder.encode(dto.getPassword());
//
//        // 4) 엔티티 생성
//
//        UserEntity userEntity = UserEntity.builder()
//                .email(dto.getEmail())
//                .password(encodedPassword)
//                .name(dto.getName())
//                .build();
//
//        // 5) 저장
//
//        userMapper.save(userEntity);
//
//    }

    public String signin(SigninReqDto dto) {
        final String username = dto.getUsername();
        final String password = dto.getPassword();
        final String defaultMessage = "사용자 정보를 확인하세요";
        UserEntity foundUser = userMapper.findUserByUsername(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException(defaultMessage);
        }
        if (!passwordEncoder.matches(password, foundUser.getPassword())) {
            throw new BadCredentialsException(defaultMessage);
        }
        // 토큰 생성
        String accessToken = "정상 로그인으로 생성된 JWT 토큰입니다"; // JWT 라이브러리

        return accessToken;
    }
}