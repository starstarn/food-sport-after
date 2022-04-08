package com.bs.grad.mapper;

import com.bs.grad.domain.UserBreakfast;
import com.bs.grad.domain.UserSport;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserSportMapper {
    @Insert("INSERT INTO user_sport(user_name,sport,rl,time,image) VALUES(#{user_name},#{sport},#{rl},#{time},#{image})")
    int insert(@Param("user_name") String user_name, @Param("sport") String sport, @Param("rl") Integer rl, @Param("time") Date time,@Param("image") String image);
    @Select("select * from user_sport where user_name=#{user_name} and time=#{time}")
    List<UserSport> select(@Param("user_name") String user_name, @Param("time") Date time);
    @Delete("delete from user_sport where id=#{id}")
    int delete(@Param("id") Integer id);
}
