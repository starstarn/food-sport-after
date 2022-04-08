package com.bs.grad.controller;

import com.bs.grad.domain.UserBreakfast;
import com.bs.grad.domain.UserLunch;
import com.bs.grad.mapper.UserLunchMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserLunchController {
    @Autowired
    private UserLunchMapper userLunchMapper;

    @RequestMapping(value = "add_lunch",method = RequestMethod.POST)
    public Msg addLunch(@RequestBody UserLunch userLunch) {
        try{
            userLunchMapper.insert(userLunch.getUser_name(), userLunch.getLunch(), userLunch.getRl(),userLunch.getTime(),userLunch.getImage());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }


    @RequestMapping(value = "s_lunch",method = RequestMethod.POST)
    public List<UserLunch> selLunch(@RequestBody UserLunch userLunch) {
        List<UserLunch> userResult = userLunchMapper.select(userLunch.getUser_name(),userLunch.getTime());
        if(userResult != null) {
            return userResult;
        }else {
            return null;
        }
        // return userResult;
    }

    //删除午餐
    @RequestMapping(value = "d_lunch",method = RequestMethod.POST)
    public Msg delLunch(@RequestBody UserLunch userLunch) {
        // userBreakfastMapper.delete(userBreakfast.getId());
        try{
            userLunchMapper.delete(userLunch.getId());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();

    }
}
