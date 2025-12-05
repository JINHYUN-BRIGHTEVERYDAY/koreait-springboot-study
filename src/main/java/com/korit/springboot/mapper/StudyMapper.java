package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


// 추상 메서드 정의
@Mapper
public interface StudyMapper {
    int insert(@Param("name") String name, @Param("age") int age);
    List<String> findAllName();
    @MapKey("studyId")
    List<Map<String, Object>> findAll();
}

