package com.boot.test;

import java.math.BigDecimal;

/**
 * @author zhang.wenhan
 * @description MathTest
 * @date 2019/7/3 10:53
 */
public class MathTest {

    public static void main(String[] args) {
        double a = 1461.6;
        double b = 711.6;
        double c = 1249.2;
        double d = a + b + c;
        double e = 3422.4;
        System.out.println(d);

        double m = Math.round(d * 100) / 100 ;
        System.out.println(m);
        double n = (double)Math.round(d * 100) / 100 ;
        System.out.println(d);
        BigDecimal money = new BigDecimal("0");

        money = money.add(BigDecimal.valueOf(a)).setScale(2, BigDecimal.ROUND_HALF_UP);
        money = money.add(BigDecimal.valueOf(b)).setScale(2, BigDecimal.ROUND_HALF_UP);
        money = money.add(BigDecimal.valueOf(c)).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(money);
        if (money.doubleValue() == e){
            System.out.println("我终于对了");
        }
    }
}
