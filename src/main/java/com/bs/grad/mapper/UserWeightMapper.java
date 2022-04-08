package com.bs.grad.mapper;

import com.bs.grad.domain.UserWeight;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserWeightMapper {
    @Insert("INSERT INTO user_weight(user_name,time,t_weight) VALUES(#{user_name},#{time},#{t_weight})")
    int insert(@Param("user_name") String user_name, @Param("time") Date time, @Param("t_weight") Integer t_weight);
    @Update("update user_weight set t_weight=#{t_weight} where user_name=#{user_name} and time=#{time}")
    int update(@Param("user_name") String user_name,@Param("t_weight") Integer t_weight,@Param("time") Date time);
    @Select("select * from user_weight where user_name=#{user_name} and time=#{time}")
    UserWeight select(@Param("user_name") String user_name,@Param("time") Date time);
    @Select("select * from user_weight where user_name=#{user_name}")
    List<UserWeight> select1(@Param("user_name") String user_name);
}
