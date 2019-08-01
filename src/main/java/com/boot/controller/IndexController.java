package com.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.mq.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.db.pojo.User;
import com.boot.service.UserService;

//@Controller
@RestController // 为组合注解，已经集成了@ResponseBody的注解
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @RequestMapping(value = {"/index", "show"}, method = RequestMethod.GET)
//    @GetMapping(value= {"/index", "show"})  
    @ResponseBody
    public Map<String, String> index() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("路桥川", "钟大哥");
        map.put("任逸帆", "西班牙语");
        return map;
    }

    @RequestMapping(value = {"/index2", "show2"}, method = RequestMethod.POST)
//    @PostMapping(value={"/index2","show2"})
    public Map<String, String> index2() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("路桥川2", "钟大哥2");
        map.put("任逸帆2", "西班牙语2");
        return map;
    }

    @GetMapping("/getUsers")
    public List<User> getUserByAge(int age) {

        return userService.getUserByAge(age);
    }

    @GetMapping("/mq/sendMsg")
    public String sendMsg() {
        rabbitMqProducer.send();
        return "发送完成";
    }


}
