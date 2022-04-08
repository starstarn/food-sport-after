package com.bs.grad.controller;

import com.bs.grad.domain.User;
import com.bs.grad.domain.UserWeight;
import com.bs.grad.mapper.UserWeightMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserWeightController {

    @Autowired
    private UserWeightMapper userWeightMapper;

    @RequestMapping(value = "add_weight",method = RequestMethod.POST)
    public Msg weight(@RequestBody UserWeight userWeight) {
        try{
            userWeightMapper.insert(userWeight.getUser_name(),userWeight.getTime(),userWeight.getT_weight());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    //修改体重
    @RequestMapping(value = "update_tweight",method = RequestMethod.POST)
    public Msg updateTweight(@RequestBody UserWeight userWeight) {
        try{
            userWeightMapper.update(userWeight.getUser_name(), userWeight.getT_weight(),userWeight.getTime());
        }
        catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    //查找体重
    @RequestMapping(value = "sel_tweight",method = RequestMethod.POST)
    public UserWeight Sel(@RequestBody UserWeight userWeight) {
        try{
            UserWeight userResult = userWeightMapper.select(userWeight.getUser_name(),userWeight.getTime());
            if(userResult!=null){
                return userResult;
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    //查找用户所有体重
    @RequestMapping(value = "all_weight",method = RequestMethod.POST)
    public List<UserWeight> Sella(@RequestBody UserWeight userWeight) {
        try{
            List<UserWeight> userResult = userWeightMapper.select1(userWeight.getUser_name());
            if(userResult!=null){
                return userResult;
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }
}
