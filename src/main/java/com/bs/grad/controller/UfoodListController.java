package com.bs.grad.controller;

import com.bs.grad.domain.UfoodList;
import com.bs.grad.mapper.UfoodListMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UfoodListController {

    @Autowired
    private UfoodListMapper ufoodListMapper;

    // 添加自定义食物
    @RequestMapping(value = "makefood",method = RequestMethod.POST)
    public Msg makeFood(@RequestBody UfoodList ufoodList) {
        try{
            ufoodListMapper.insert(ufoodList.getName(),ufoodList.getRl(),ufoodList.getDanwei(),ufoodList.getUser_name(),ufoodList.getImage());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    // 查询
    @RequestMapping(value = "s_makefood",method = RequestMethod.POST)
    public List<UfoodList> selFood(@RequestBody UfoodList ufoodList) {
        List<UfoodList> ufoodResult = ufoodListMapper.select(ufoodList.getUser_name());
        if(ufoodResult != null) {
            return ufoodResult;
        }else {
            return null;
        }
        // return userResult;
    }

    //删除
    @RequestMapping(value = "d_ufood",method = RequestMethod.POST)
    public Msg delUfood(@RequestBody UfoodList ufoodList) {
        try{
            ufoodListMapper.delect(ufoodList.getId());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();

    }
}
