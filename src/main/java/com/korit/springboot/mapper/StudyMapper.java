package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


// 추상 메서드 정의
@Mapper
public interface StudyMapper {
    int insert(@Param("name") String name, @Param("age") int age);
    List<String> findAllName();
}

