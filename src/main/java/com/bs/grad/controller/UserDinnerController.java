package com.bs.grad.controller;

import com.bs.grad.domain.UserDinner;
import com.bs.grad.domain.UserLunch;
import com.bs.grad.mapper.UserDinnerMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDinnerController {
    @Autowired
    private UserDinnerMapper userDinnerMapper;

    @RequestMapping(value = "add_dinner",method = RequestMethod.POST)
    public Msg addDinner(@RequestBody UserDinner userDinner) {
        try{
            userDinnerMapper.insert(userDinner.getUser_name(), userDinner.getDinner(), userDinner.getRl(),userDinner.getTime(),userDinner.getImage());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }


    @RequestMapping(value = "s_dinner",method = RequestMethod.POST)
    public List<UserDinner> selDinner(@RequestBody UserDinner userDinner) {
        List<UserDinner> userResult = userDinnerMapper.select(userDinner.getUser_name(),userDinner.getTime());
        if(userResult != null) {
            return userResult;
        }else {
            return null;
        }
        // return userResult;
    }

    //删除晚餐
    @RequestMapping(value = "d_dinner",method = RequestMethod.POST)
    public Msg delDinner(@RequestBody UserDinner userDinner) {
        // userBreakfastMapper.delete(userBreakfast.getId());
        try{
            userDinnerMapper.delete(userDinner.getId());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();

    }
}
