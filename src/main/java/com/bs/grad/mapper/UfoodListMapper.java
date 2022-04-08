package com.bs.grad.mapper;

import com.bs.grad.domain.UfoodList;
import com.bs.grad.domain.UsportList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UfoodListMapper {
    @Insert("INSERT INTO ufood_list(name,rl,danwei,user_name,image) VALUES(#{name},#{rl},#{danwei},#{user_name},#{image})")
    int insert(@Param("name") String name,@Param("rl") Integer rl, @Param("danwei") String danwei,@Param("user_name") String user_name,@Param("image") String image);
    @Select("select * from ufood_list where user_name=#{user_name}")
    List<UfoodList> select(@Param("user_name") String user_name);
    @Delete("delect from ufood_list where id=#{id}")
    int delect(@Param("id") Integer id);
}
