package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


// Controller가 Mapper를 의존
@Mapper
public interface ProductMapper {
    // @Param을 붙여 써야
    int insert(@Param("product_name") String product_name,
               @Param("product_size") int product_size,
               @Param("product_price") int product_price);
}