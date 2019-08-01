package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.qibaidu.entity.InnerMessageSys;
import com.boot.qibaidu.mapper.InnerMessageSysMapper;
import com.boot.service.AUserService;
import com.boot.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang.wenhan
 * @description QibaiduController
 * @date 2019/4/22 13:32
 */
@RestController
@RequestMapping("/qibaidu")
public class QibaiduController {

    @Autowired
    JsonService jsonService;

    @Autowired
    InnerMessageSysMapper innerMessageSysMapper;

    @Autowired
    AUserService aUserService;

    @GetMapping("/test")
    public String test(){
        InnerMessageSys innerMessageSys = innerMessageSysMapper.selectByPrimaryKey("04ef785baf754137854e7cefc8fdb8ab");
        return JSON.toJSONString(innerMessageSys);
    }

    @GetMapping("/test1")
    public String test1(){
        try{
            jsonService.save("1");
        } catch (Exception e){
            System.out.println("捕获异常");
            e.printStackTrace();
        }
        return "1";
    }

    @GetMapping("/test2")
    public String test2(){
        try{
            aUserService.testSave("0");
        } catch (Exception e){
            System.out.println("捕获异常");
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " 线程开始");
            aUserService.testSave("1");
            System.out.println(Thread.currentThread().getName() + " 线程开始第二个");
            aUserService.testSave("0");
            System.out.println(Thread.currentThread().getName() + " 线程开始第三个");
            aUserService.testSave("1");
            System.out.println(Thread.currentThread().getName() + " 线程结束");

        }).start();

        return "test2";
    }


}
