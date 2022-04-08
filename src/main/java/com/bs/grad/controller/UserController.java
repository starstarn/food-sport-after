package com.bs.grad.controller;

import com.bs.grad.domain.UfoodList;
import com.bs.grad.domain.User;
import com.bs.grad.domain.UserBreakfast;
import com.bs.grad.mapper.UserMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    //注册
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public Msg register(@RequestBody User user) {
        try{
            userMapper.insert(user.getUser_name(), user.getUser_password(), user.getHeight(), user.getWeight(), user.getBirthday(), user.getSex(), user.getNick_name(),user.getBmi(),user.getS_weight(),user.getKll(),user.getBegin_weight());
        }catch (DuplicateKeyException e) {
            return Result.error(-201,"该用户名已存在");
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }


    @RequestMapping(value = "diff_name",method = RequestMethod.POST)
    public Msg registe(@RequestBody User user) {
        try{
            userMapper.insert1(user.getUser_name(), user.getUser_password(), user.getNick_name());
        }catch (DuplicateKeyException e) {
            return Result.error(-201,"该用户名已存在");
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }




    //登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Msg login(@RequestBody User user) {
        try{
            User userResult = userMapper.select(user.getUser_name());
            if(userResult==null){
                return Result.error(-202,"该用户不存在");
            }else {
                if(userResult.getUser_password().equals(user.getUser_password())){
                    return Result.success();
                }else {
                    return Result.error(-203,"密码错误");
                }
            }
        }catch (Exception e){
            return Result.error(-400,"出现异常");
        }
    }


    //判断用户名已存在
    @RequestMapping(value = "diff",method = RequestMethod.POST)
    public Msg Diff(@RequestBody User user) {
        try{
            User userResult = userMapper.select(user.getUser_name());
            if(userResult==null){
                return Result.error(-202,"该用户不存在");
            }else {
                if(userResult.getUser_password().equals(user.getUser_password())){
                    return Result.success();
                }else {
                    return Result.error(-203,"密码错误");
                }
            }
        }catch (Exception e){
            return Result.error(-400,"出现异常");
        }
    }

    //查找用户信息
    @RequestMapping(value = "sel_user",method = RequestMethod.POST)
    public User Sel(@RequestBody User user) {
        try{
            User userResult = userMapper.select(user.getUser_name());
            if(userResult!=null){
                return userResult;
            }else {
                return null;
                }
        }catch (Exception e){
            return null;
        }
    }

    // 修改用户体重
    @RequestMapping(value = "update_weight",method = RequestMethod.POST)
    public Msg updateWeight(@RequestBody User user) {
        try{
            userMapper.update(user.getUser_name(), user.getWeight(),user.getBmi(),user.getKll());
        }
        catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    // 修改用户目标体重
    @RequestMapping(value = "update_sweight",method = RequestMethod.POST)
    public Msg updateSweight(@RequestBody User user) {
        try{
            userMapper.update1(user.getUser_name(), user.getS_weight());
        }
        catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    // 修改用户基本信息
    @RequestMapping(value = "update_basic",method = RequestMethod.POST)
    public Msg updateBasic(@RequestBody User user) {
        try{
            userMapper.update2(user.getUser_name(),user.getSex(),user.getBirthday(),user.getHeight(),user.getBmi(),user.getKll());
        }
        catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    //修改用户昵称
    @RequestMapping(value = "update_nick",method = RequestMethod.POST)
    public Msg updateNick(@RequestBody User user) {
        try{
            userMapper.update3(user.getNick_name(),user.getUser_name());
        }
        catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    //修改用户宣言
    @RequestMapping(value = "update_xuan",method = RequestMethod.POST)
    public Msg updateXuan(@RequestBody User user) {
        try{
            userMapper.update4(user.getXuanyan(),user.getUser_name());
        }
        catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }


    //修改用户密码
    @RequestMapping(value = "update_pass",method = RequestMethod.POST)
    public Msg updatePass(@RequestBody User user) {
        try{
            userMapper.update5(user.getUser_password(),user.getUser_name());
        }
        catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }


    //注销用户
    @RequestMapping(value = "d_user",method = RequestMethod.POST)
    public Msg delUser(@RequestBody User user) {
        try{
            userMapper.delete(user.getUser_name());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();

    }


    //修改用户心情
    @RequestMapping(value = "update_mood",method = RequestMethod.POST)
    public Msg updateMood(@RequestBody User user) {
        try{
            userMapper.update6(user.getMood(),user.getUser_name());
        }
        catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }




    @RequestMapping("/test")
    public String hello(){
        return "你好呀";
    }

}