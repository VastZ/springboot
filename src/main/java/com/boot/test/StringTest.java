package com.boot.test;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class StringTest {
    
    public static void main(String[] args) {
//        stringSpiltTest();
        testPass1();
    }

    public static void testPass1(){
        BigDecimal a =  new BigDecimal(1);
        BigDecimal b = change(a);
        System.out.println(a);
        System.out.println(b);
    }

    public static BigDecimal change(BigDecimal bigDecimal){
        bigDecimal = bigDecimal.add(new BigDecimal(1));
        return bigDecimal;
    }

    public static void testPass(){
        String str = "a";
        String str1 = change(str);
        System.out.println(str);
        System.out.println(str1);
    }

    public static String change(String str){
        str = str + "b";
        return str;
    }

    public static void stringSpiltTest(){
        String str = "zhaoliang20170625@163.com;wangyuanyuan5bj@163.com";
        StringTokenizer stk = new StringTokenizer(str,";");
        while (stk.hasMoreTokens())
            System.out.println(stk.nextToken());
    }

    public static void strTest(){
        String s = "2-ceprovider0000000081-obposition0000000091";
        String[] ss = s.split("-");
        String s1 = "2-ceprovider0000000081";
        String[] s1s = s1.split("-");
        System.out.println(ss.length);
        System.out.println(s1s.length);

        System.out.println( s.substring(s.lastIndexOf("-")));
        System.out.println( s1.substring(s1.lastIndexOf("-")));

        String id = "130125199109250015";
        System.out.println(id.substring(16));
        System.out.println(id.substring(16, 17));

        String time = "2019-02-21 00:00:00";
        System.out.println(time.substring(0, 10));

        Boolean n =  1 > 2;

        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setAge(11);
        u1.setName("zhangsan");
        User u2 = new User();
        u2.setAge(11);
        u2.setName("zhangsan2");
        User u3 = new User();
        u3.setAge(13);
        u3.setName("zhangsan3");
        User u4 = new User();
        u4.setAge(14);
        u4.setName("zhangsan4");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        Map<Integer, List<User>> map = list.stream().collect(Collectors.groupingBy(User :: getAge));
        System.out.println(JSON.toJSONString(map));
    }
}
