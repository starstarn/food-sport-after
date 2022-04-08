package com.bs.grad.mapper;

import com.bs.grad.domain.UserLunch;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserLunchMapper {
    @Insert("INSERT INTO user_lunch(user_name,lunch,rl,time,image) VALUES(#{user_name},#{lunch},#{rl},#{time},#{image})")
    int insert(@Param("user_name") String user_name, @Param("lunch") String lunch, @Param("rl") Integer rl, @Param("time") Date time,@Param("image") String image);
    @Select("select * from user_lunch where user_name=#{user_name} and time=#{time}")
    List<UserLunch> select(@Param("user_name") String user_name, @Param("time") Date time);
    @Delete("delete from user_lunch where id=#{id}")
    int delete(@Param("id") Integer id);
}
