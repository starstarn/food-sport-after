package com.bs.grad.mapper;

import com.bs.grad.domain.FoodList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodListMapper {
    @Select("select * from food_list")
    List<FoodList> select();
    @Select("select * from food_list where type=#{type}")
    List<FoodList> select1(@Param("type") String type);
    @Select("select * from food_list where name=#{name}")
    FoodList select2(@Param("name") String name);
}
