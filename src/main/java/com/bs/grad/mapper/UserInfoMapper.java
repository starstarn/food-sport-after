package com.bs.grad.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {
    @Insert("INSERT INTO user_info(user_name,user_password) VALUES(#{user_name},#{user_password})")
    int insert(@Param("user_name") String user_name, @Param("user_password") String user_password);

}
