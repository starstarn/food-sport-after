package com.bs.grad.mapper;

import com.bs.grad.domain.UserBreakfast;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserBreakfastMapper {
    @Insert("INSERT INTO user_breakfast(user_name,breakfast,rl,time,image) VALUES(#{user_name},#{breakfast},#{rl},#{time},#{image})")
    int insert(@Param("user_name") String user_name, @Param("breakfast") String breakfast, @Param("rl") Integer rl, @Param("time") Date time, @Param("image") String image);
    @Select("select * from user_breakfast where user_name=#{user_name} and time=#{time}")
    List<UserBreakfast> select(@Param("user_name") String user_name, @Param("time") Date time);
    @Delete("delete from user_breakfast where id=#{id}")
    int delete(@Param("id") Integer id);
}
