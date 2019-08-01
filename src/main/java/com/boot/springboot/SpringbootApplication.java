package com.boot.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class}, scanBasePackages = "com.boot")
//@ComponentScan(basePackages={"com.boot.controller", "com.boot.service", "com.boot.db"})
//@ComponentScan(value = "com.boot")
@MapperScan({"com.boot.db.dao", "com.boot.db.mapper", "com.boot.qibaidu.mapper"})

//@ComponentScan("com.boot.controller")
@EnableScheduling
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
