package com.boot.learn.proxy;

public class ThirdChannelProxy implements Payment {

    private Payment payment = new ThridChannelPayment();
    private PaymentLogger logger = new PaymentLogger();

    @Override
    public String doPay(String uid) {
        logger.log(uid);
        return payment.doPay(uid);
    }
}
