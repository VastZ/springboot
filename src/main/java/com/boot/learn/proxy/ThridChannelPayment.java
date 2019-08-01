package com.boot.learn.proxy;

public class ThridChannelPayment implements Payment {

    @Override
    public String doPay(String uid) {
        System.out.println(uid + "-> 正在支付中");
        return "success";
    }
}
