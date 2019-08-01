package com.boot.learn.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyDemo {

    public static void main(String[] args) {
//        Payment payment = new ThridChannelPayment();
        // 单一的代理模式

        Payment payment = new ThirdChannelProxy();
        System.out.println(payment.doPay("mic"));
        // JDK动态代理 通过接口的方法名在动态生成代理类里面调用业务实现类的同名方法去实现拦截
        DynamicProxy dynamicProxy = new DynamicProxy();
        Payment payment1 = new ThridChannelPayment();
        Payment payment2 = (Payment) dynamicProxy.bind(payment1);
        System.out.println(payment2.doPay("Mic"));

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", ThridChannelPayment.class.getInterfaces());
        String path = "PaymentProxy.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("success");
        }catch (IOException e) {
            e.printStackTrace();
        }


        // CGlib 通过继承具体要运行的业务类，动态生成业务类的子类，重写业务方法
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "code");
//        ThridChannelPayment payment = new ThridChannelPayment();
//        CglibDynamicProxy proxy = new CglibDynamicProxy();
//        ThridChannelPayment payment3 = (ThridChannelPayment) proxy.getInstance(payment);
//        System.out.println(payment3.doPay("Kobe"));

    }

}
