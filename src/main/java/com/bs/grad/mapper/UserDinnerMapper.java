package com.bs.grad.mapper;

import com.bs.grad.domain.UserDinner;
import com.bs.grad.domain.UserLunch;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserDinnerMapper {
    @Insert("INSERT INTO user_dinner(user_name,dinner,rl,time,image) VALUES(#{user_name},#{dinner},#{rl},#{time},#{image})")
    int insert(@Param("user_name") String user_name, @Param("dinner") String dinner, @Param("rl") Integer rl, @Param("time") Date time,@Param("image") String image);
    @Select("select * from user_dinner where user_name=#{user_name} and time=#{time}")
    List<UserDinner> select(@Param("user_name") String user_name, @Param("time") Date time);
    @Delete("delete from user_dinner where id=#{id}")
    int delete(@Param("id") Integer id);
}
