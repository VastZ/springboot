package com.boot.dayask;

import java.util.Calendar;

/**
 * @author zhang.wenhan
 * @description a
 * @date 2019/7/17 11:01
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private final int beltSize;

    private static final int CURRENT_YEAR =
            Calendar.getInstance().get(Calendar.YEAR);

    private Elvis() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("Elvis wears size " + INSTANCE.beltSize() + " belt.");
//        以上程序输出内容是？
//        (a) Elvis wears size 0 belt.
//        (b) Elvis wears size 73 belt.
//        (c) Elvis wears size -1930 belt.
//        (d) 以上答案都不对
        // 答案是 -1930
        // public static final Elvis INSTANCE = new Elvis();
        // 因为有它 ，所以先执行了 构造方法 而 CURRENT_YEAR = 0 ，beltSize = -1930。
        // 在main() 调用了 INSTANCE.beltSize()。
        // INSTANCE 是在启动的时候已经初始化。
        // 所以直接调用了.beltSize(). 返回就是 -1930
    }
}