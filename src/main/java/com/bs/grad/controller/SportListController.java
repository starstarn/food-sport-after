package com.bs.grad.controller;

import com.bs.grad.domain.SportList;
import com.bs.grad.mapper.SportListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportListController {

    @Autowired
    private SportListMapper sportListMapper;

    @RequestMapping(value = "sportlist",method = RequestMethod.POST)
    public List<SportList> selFood() {
        List<SportList> sportResult = sportListMapper.select();
        if(sportResult != null) {
            return sportResult;
        }else {
            return null;
        }
    }
}
