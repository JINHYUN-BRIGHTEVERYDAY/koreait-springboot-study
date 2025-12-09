package com.korit.springboot.mapper;

import com.korit.springboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int insert(UserEntity userEntity);

    // username으로 찾기
    UserEntity findUserByUsername(@Param("username") String username);

    // userId로 찾기
    UserEntity findUserByUserId(@Param("userId") int userId);
}
