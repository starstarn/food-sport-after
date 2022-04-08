package com.bs.grad.controller;

import com.bs.grad.domain.UserBreakfast;
import com.bs.grad.mapper.UserBreakfastMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserBreakfastController {
    @Autowired
    private UserBreakfastMapper userBreakfastMapper;

    // 添加早餐
    @RequestMapping(value = "add_breakfast",method = RequestMethod.POST)
    public Msg addBreakfast(@RequestBody UserBreakfast userBreakfast) {
        try{
            userBreakfastMapper.insert(userBreakfast.getUser_name(), userBreakfast.getBreakfast(), userBreakfast.getRl(),userBreakfast.getTime(),userBreakfast.getImage());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }


    // 查找早餐
    @RequestMapping(value = "s_breakfast",method = RequestMethod.POST)
    public List<UserBreakfast> selBreakfast(@RequestBody UserBreakfast userBreakfast) {
        List<UserBreakfast> userResult = userBreakfastMapper.select(userBreakfast.getUser_name(),userBreakfast.getTime());
        if(userResult != null) {
            return userResult;
        }else {
            return null;
        }
        // return userResult;
    }

    //删除早餐
    @RequestMapping(value = "d_breakfast",method = RequestMethod.POST)
    public Msg delBreakfast(@RequestBody UserBreakfast userBreakfast) {
        try{
            userBreakfastMapper.delete(userBreakfast.getId());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();

    }

}
