package com.bs.grad.controller;

import com.bs.grad.domain.FoodList;
import com.bs.grad.domain.UfoodList;
import com.bs.grad.domain.UsportList;
import com.bs.grad.mapper.UserSportMapper;
import com.bs.grad.mapper.UsportListMapper;
import com.bs.grad.util.Msg;
import com.bs.grad.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsportListController {

    @Autowired
    private UsportListMapper usportListMapper;

    // 添加自定义运动
    @RequestMapping(value = "makesport",method = RequestMethod.POST)
    public Msg makeSport(@RequestBody UsportList usportList) {
        try{
            usportListMapper.insert(usportList.getName(),usportList.getRl(),usportList.getDanwei(),usportList.getUser_name(),usportList.getImage());
        }catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    // 查询
    @RequestMapping(value = "s_makesport",method = RequestMethod.POST)
    public List<UsportList> selFood(@RequestBody UsportList usportList) {
        List<UsportList> usportResult = usportListMapper.select(usportList.getUser_name());
        if(usportResult != null) {
            return usportResult;
        }else {
            return null;
        }
        // return userResult;
    }
}
