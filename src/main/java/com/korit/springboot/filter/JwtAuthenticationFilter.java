package com.korit.springboot.filter;

import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.jwt.JwtTokenProvider;
import com.korit.springboot.mapper.UserMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String bearerToken = request.getHeader("Authorization");

        // 잘못된 토큰이 들어오는 상황
        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            // 다음 필터로 넘겨버리기
            filterChain.doFilter(request, response);
            return;
        }

        // 정상적인 토큰인 경우
        String accessToken = bearerToken.replaceAll("Bearer ", "");


        // 유효하지 않은 토큰의 경우 다음 필터로 넘겨버리기
        if (!jwtTokenProvider.validateToken(accessToken)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 토큰이 유효한 경우
        int userId = jwtTokenProvider.getuserId(accessToken);
        UserEntity foundUser = userMapper.findUserById(userId);


        if (foundUser == null) {
            filterChain.doFilter(request, response);
            return;
        }


        // 권한 부여하기
        SecurityContextHolder.getContext().setAuthentication(null);


        // 다음 필터 -> 인증 처리
        filterChain.doFilter(request, response);
    }

}