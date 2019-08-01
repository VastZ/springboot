package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.db.entity.TestJson;
import com.boot.db.mapper.TestJsonMapper;
import com.boot.service.AUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger("CARD");

    @Autowired
    private TestJsonMapper testJsonMapper;

    @Autowired
    private AUserService aUserService;
    
    // 获取详情
    @RequestMapping(value="/getDetailById", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getDetailById() {
        LOGGER.info("hhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        TestJson res =  testJsonMapper.selectByPrimaryKey(1);
        return JSON.toJSONString(res);
    }


    // 获取详情
    @RequestMapping(value="/testT", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String testT() {
        LOGGER.info("hhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        TestJson res =  testJsonMapper.selectByPrimaryKey(1);
        return JSON.toJSONString(res);
    }

    @GetMapping("/transcation")
    public String testTranscation() {
        aUserService.testTranscation();
        return "success";
    }

}
