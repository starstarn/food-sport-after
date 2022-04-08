package com.bs.grad.mapper;

import com.bs.grad.domain.SportList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SportListMapper {
    @Select("select * from sport_list")
    List<SportList> select();
}
