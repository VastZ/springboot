package com.boot.learn.interview;

public class OuterDemo {

    static class Inner{
        int one = 5;
        static int two = 5;
        static final int three = 5;
        static final int four = new Integer(5);
    }

    public static void main(String[] args) {
        // 虚拟机当加载静态内部类时如果是确定的属性值时，虚拟机会直接将值存放到元存储中(静态方法区)，
        // 其他未确定值需要在运行时动态计算，由虚拟机分配地址和值。如果设置的值不是static,
        // 那么不能直接访问，因为此时值属于对象而不是类。
        System.out.println(Inner.two);
        System.out.println(Inner.three);
        System.out.println(Inner.four);
    }
}
