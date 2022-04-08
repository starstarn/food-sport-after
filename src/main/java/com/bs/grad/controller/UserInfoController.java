package com.bs.grad.controller;

import com.bs.grad.domain.UserInfo;
import com.bs.grad.mapper.UserInfoMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class UserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    //注册
    @RequestMapping(value = "double",method = RequestMethod.POST)
    public Msg register(@RequestBody UserInfo userInfo) {
        try{
            userInfoMapper.insert(userInfo.getUser_name(), userInfo.getUser_password());
        }catch (DuplicateKeyException e) {
            return Result.error(-201,"该用户名已存在");
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }
}
