package com.boot.learn.interview;

import java.util.Arrays;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4};
        List list = Arrays.asList(ints);
        // 1 基本数据类型数组在转换为列表时，如果直接传递数组，基本类型数组将被视为一个对象而不会被解析成数组，如果直接传递参数将能正常解析
        System.out.println(list.size());
        List list1 = Arrays.asList(1,2,3,4);
        // 4
        System.out.println(list1.size());
        Integer[] tests = new Integer[]{1,2,3,4};
        List list2 = Arrays.asList(tests);
        // 4
        System.out.println(list2.size());
    }

}
