package com.boot.dayask;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhang.wenhan
 * @description SetTest
 * @date 2019/7/24 8:38
 */
public class SetTest {

    public static void main(String[] args) {
        Set<Short> set=new HashSet<>();
        for(Short i=0; i<100; i++) {//自动拆箱：short(基本类型)–> Short（包装类型）
            set.add(i);//将i自动装箱后添加到set集合中
            set.remove( i-1);//i-1位int类型，在remove（Object o）方法中自动包装为Integer
            //System.out.println(b);//false，删除失败，不会影响set集合中元素
        }
        System.out.println(set.size());
        String str = "41081119660830304x";
        System.out.println(str.toUpperCase());
    }
}
