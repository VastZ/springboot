package com.boot.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
    
    public static void main(String[] args) {
        String str = "{}";
        JSONObject obj = JSON.parseObject(str);
        System.out.println(obj == null);
        System.out.println(obj.getString("sss"));


    }
    
}
