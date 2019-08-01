package com.boot.testController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang.wenhan
 * @description TestController
 * @date 2019/5/28 15:05
 */
@RestController
@RequestMapping("/aop/test")
public class TestAopController {

    @GetMapping("/hello")
    public  String hello(){
        return "hahahahahahhaha";
    }


}
