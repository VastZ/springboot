package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.service.StatisticCacl;

@RestController
public class UserController {

    @Autowired
    StatisticCacl statisticCacl;
    
    @RequestMapping("/caiyu/index")
    public String cacl() {
        try {
            statisticCacl.dealStatisticCacl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hello";
    }



}
