package com.boot.learn.proxy;

public class PaymentLogger{

    public void log(String uid){
        System.out.println(uid + "-> 发起了支付");
    }

}
