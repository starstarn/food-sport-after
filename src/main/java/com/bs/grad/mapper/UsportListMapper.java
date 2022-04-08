package com.bs.grad.mapper;

import com.bs.grad.domain.UsportList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsportListMapper {
    @Insert("INSERT INTO usport_list(name,rl,danwei,user_name,image) VALUES(#{name},#{rl},#{danwei},#{user_name},#{image})")
    int insert(@Param("name") String name, @Param("rl") Integer rl,@Param("danwei") String danwei,@Param("user_name") String user_name,@Param("image") String image);
    @Select("select * from usport_list where user_name=#{user_name}")
    List<UsportList> select(@Param("user_name") String user_name);
}
