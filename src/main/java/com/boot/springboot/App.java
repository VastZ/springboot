package com.boot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.boot.controller")
public class App {
    
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
}
