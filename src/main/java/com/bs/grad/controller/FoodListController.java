package com.bs.grad.controller;

import com.bs.grad.domain.FoodList;
import com.bs.grad.mapper.FoodListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodListController {

    @Autowired
    private FoodListMapper foodListMapper;

    // 查询所有食物列表
    @RequestMapping(value = "foodlist",method = RequestMethod.POST)
    public List<FoodList> selFood() {
        List<FoodList> foodResult = foodListMapper.select();
        if(foodResult != null) {
            return foodResult;
        }else {
            return null;
        }
    }

    //按type类型查询
    @RequestMapping(value = "s_type",method = RequestMethod.POST)
    public List<FoodList> selType(@RequestBody FoodList foodList) {
        List<FoodList> foodResult = foodListMapper.select1(foodList.getType());
        if(foodResult != null) {
            return foodResult;
        }else {
            return null;
        }
    }

    //按name类型查询
    @RequestMapping(value = "s_name",method = RequestMethod.POST)
    public FoodList selName(@RequestBody FoodList foodList) {
        FoodList foodResult = foodListMapper.select2(foodList.getName());
        if(foodResult != null) {
            return foodResult;
        }else {
            return null;
        }
    }
}

