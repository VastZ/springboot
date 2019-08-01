package com.boot.springboot;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

public class ApplicationEventMulticasterDemo {

    public static void main(String[] args) {

        ApplicationEventMulticaster caster = new SimpleApplicationEventMulticaster();
        
        caster.addApplicationListener(event -> {
            System.out.println("监听事件：" + event);
        });
        
        caster.multicastEvent(new PayloadApplicationEvent<Object>("1", "Hello"));
        caster.multicastEvent(new PayloadApplicationEvent<Object>("2", "Hello"));

    }

}
