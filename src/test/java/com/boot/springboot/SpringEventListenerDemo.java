package com.boot.springboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;

public class SpringEventListenerDemo {
    // springboot 
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
//        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
//            @Override
//            public void onApplicationEvent(ApplicationEvent event) {
//                System.err.println("事件源：" + event);
//            }
//        });
        context.addApplicationListener(new ClosedListener());
        context.addApplicationListener(new RefreshedListener());
        // 启动spring应用上下文
        context.refresh();
        
        // 一个是 ContextRefreshedEvent
        // 一个是 PayloadApplicationEvent
        // 应用上下文发布事件
        context.publishEvent("HelloWorld"); // 发布一个HelloWorld事件
        // 一个是 MyEvent
        context.publishEvent(new MyEvent("Hello World"));
        // 一个是 ContextClosedEvent
        // 关闭上下文
        context.close();
        
    }

    private static class RefreshedListener implements ApplicationListener<ContextRefreshedEvent>{
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.err.println("关闭上下文：" + event);
        }
        
    }
    
    private static class ClosedListener implements ApplicationListener<ContextClosedEvent>{
        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            System.err.println("关闭上下文：" + event);
        }
        
    }
    
    @SuppressWarnings("serial")
    private static class MyEvent extends ApplicationEvent{

        public MyEvent(Object source) {
            super(source);
        }
        
    }
    
}
