package com.boot.learn.proxy;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target = target;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        System.out.println("ClassLoader :" + classLoader.getClass().toString());
        System.out.println("interfaces" + JSON.toJSONString(interfaces));
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志开始");
        String str = "我是jdk代理的 ";
        Object result = method.invoke(target, args);
        System.out.println("记录日志结束");
        return result;
    }
}
