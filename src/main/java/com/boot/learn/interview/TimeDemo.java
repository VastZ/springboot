package com.boot.learn.interview;

import java.util.Calendar;
import java.util.Date;

public class TimeDemo {

    public static void main(String[] args) {
        // 获取从 1970年1月1日0时0分0秒到现在的毫秒数？
        System.currentTimeMillis();
        Date date = new Date();
        date.getTime();
        Calendar.getInstance().getTimeInMillis();

    }
}
