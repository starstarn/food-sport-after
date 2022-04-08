package com.bs.grad.controller;

import com.bs.grad.domain.UserBreakfast;
import com.bs.grad.domain.UserSport;
import com.bs.grad.mapper.UserSportMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserSportController {

    @Autowired
    private UserSportMapper userSportMapper;

    @RequestMapping(value = "add_sport",method = RequestMethod.POST)
    public Msg register(@RequestBody UserSport userSport) {
        try{
            userSportMapper.insert(userSport.getUser_name(), userSport.getSport(), userSport.getRl(),userSport.getTime(),userSport.getImage());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }


    @RequestMapping(value = "s_sport",method = RequestMethod.POST)
    public List<UserSport> login(@RequestBody UserSport userSport) {
        List<UserSport> userResult = userSportMapper.select(userSport.getUser_name(),userSport.getTime());
        if(userResult != null) {
            return userResult;
        }else {
            return null;
        }
        // return userResult;
    }

    //删除运动
    @RequestMapping(value = "d_sport",method = RequestMethod.POST)
    public Msg delSport(@RequestBody UserSport userSport) {
        // userBreakfastMapper.delete(userBreakfast.getId());
        try{
            userSportMapper.delete(userSport.getId());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();

    }
}
