package com.bs.grad.mapper;


import com.bs.grad.domain.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(user_name,user_password,height,weight,birthday,sex,nick_name,bmi,s_weight,kll,begin_weight) VALUES(#{user_name},#{user_password},#{height},#{weight},#{birthday},#{sex},#{nick_name},#{bmi},#{s_weight},#{kll},#{begin_weight})")
    int insert(@Param("user_name") String user_name, @Param("user_password") String user_password, @Param("height") Integer height,@Param("weight") Integer weight,@Param("birthday") String birthday,@Param("sex") String sex,@Param("nick_name") String nick_name,@Param("bmi") Double bmi,@Param("s_weight") Integer s_weight,@Param("kll") Integer kll,@Param("begin_weight") Integer begin_weight);

    @Insert("INSERT INTO user(user_name,user_password,nick_name) VALUES(#{user_name},#{user_password},#{nick_name})")
    int insert1(@Param("user_name") String user_name, @Param("user_password") String user_password,@Param("nick_name") String nick_name);


    @Select("select * from user where user_name=#{user_name}")
    User select(@Param("user_name") String user_name);
    @Select("select * from user where user_name=#{user_name}")
    User select1(@Param("user_name") String user_name);
    @Update("update user set weight=#{weight},bmi=#{bmi},kll=#{kll} where user_name=#{user_name}")
    int update(@Param("user_name") String user_name,@Param("weight") Integer weight,@Param("bmi") Double bmi,@Param("kll") Integer kll);
    @Update("update user set s_weight=#{s_weight} where user_name=#{user_name}")
    int update1(@Param("user_name") String user_name,@Param("s_weight") Integer s_weight);
    @Update("update user set sex=#{sex},birthday=#{birthday},height=#{height},bmi=#{bmi},kll=#{kll} where user_name=#{user_name}")
    int update2(@Param("user_name") String user_name, @Param("sex") String sex, @Param("birthday") String birthday, @Param("height") Integer height,@Param("bmi") Double bmi,@Param("kll") Integer kll);
    @Update("update user set nick_name=#{nick_name} where user_name=#{user_name}")
    int update3(@Param("nick_name") String nick_name,@Param("user_name") String user_name);
    @Update("update user set xuanyan=#{xuanyan} where user_name=#{user_name}")
    int update4(@Param("xuanyan") String xuanyan,@Param("user_name") String user_name);
    @Update("update user set user_password=#{user_password} where user_name=#{user_name}")
    int update5(@Param("user_password") String user_password,@Param("user_name") String user_name);
    @Delete("delete from user where user_name=#{user_name}")
    int delete(@Param("user_name") String user_name);

    @Update("update user set mood=#{mood} where user_name=#{user_name}")
    int update6(@Param("mood") String mood,@Param("user_name") String user_name);

}
