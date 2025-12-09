package com.korit.springboot.security;

import com.korit.springboot.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@RequiredArgsConstructor
public class PrincipalUser implements UserDetails {
    @Getter
    private final UserEntity userEntity;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userEntity.getUserRoleEntities().stream()
                .map(userRoleEntity ->
                        new SimpleGrantedAuthority(userRoleEntity.getRoleEntity().getRoleName()))
                .toList();
    }


    public int getUserId() {
        return userEntity.getUserId();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }


}
