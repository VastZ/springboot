package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.db.entity.TestJson;
import com.boot.db.mapper.TestJsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class TestController2 {

    private static final Logger LOGGER = LoggerFactory.getLogger("TEST");

    @Autowired
    private TestJsonMapper testJsonMapper;
    
    // 获取详情
    @RequestMapping(value="/testJson", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getDetailById() {
        LOGGER.info("hhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        TestJson res =  testJsonMapper.selectByPrimaryKey(1);
        return JSON.toJSONString(res);
    }


}
