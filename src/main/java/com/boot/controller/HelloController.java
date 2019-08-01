package com.boot.controller;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.lang.reflect.Method;

/**
 * @author zhang.wenhan
 * @description HelloController
 * @date 2019/7/2 15:54
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = Logger.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(){


        Method[] methods =  this.getClass().getMethods();

        for (Method method : methods){
            if(method.isAnnotationPresent(GetMapping.class)){
                String[] strs = method.getAnnotation(GetMapping.class).value();
                    System.out.println(JSON.toJSONString(strs));
            }
        }

        Thread.currentThread().getStackTrace();



        return "hello";
    }

    public static void main(String[] args) {
//        float f1 = 0.1f;
//        System.out.println(f1 * 10);
//        BigDecimal a = new BigDecimal(0.1f);
//        System.out.println(a.multiply(new BigDecimal("10")));
//        BigDecimal b = BigDecimal.valueOf(f1);
//        System.out.println(b.multiply(new BigDecimal("10")));
        String str = "a,b,c, ";
        String str1 = "a,b,c, ,";
        String str2 = "a,b,c, , ";
        String str3 = "a,b,c,,";
        String str4 = "a,b,c,, ";
        String[] strs = str.split(",");
        String[] strs1 = str1.split(",");
        String[] strs2 = str2.split(",");
        String[] strs3 = str3.split(",");
        String[] strs4 = str4.split(",");
        System.out.println(strs.length);
        System.out.println(strs1.length);
        System.out.println(strs2.length);
        System.out.println(strs3.length);
        System.out.println(strs4.length);
        System.out.println("我是第四:" + strs4[3] + "----");
        System.out.println("我是第五:" + strs4[4] + "----");
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(HttpServletRequest request) {
        try {
            DataInputStream di = new DataInputStream(request.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int i =0;
            int read = 0;
            //转换数据流
            while ((read = di.read(b)) !=-1)
            {
                bos.write(b, 0, read);
            }
            bos.close();
            di.close();
            String strData = new String(bos.toByteArray());
            System.out.println(strData);
            return strData;
        } catch (Exception e) {
            return "EXCEPTION";
        }
    }

}
