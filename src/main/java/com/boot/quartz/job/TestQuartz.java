package com.boot.quartz.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.fastjson.JSON;
import com.boot.db.pojo.User;
import com.boot.service.UserService;

public class TestQuartz extends QuartzJobBean {

    private final Logger logger = LoggerFactory.getLogger(TestQuartz.class);

    @Autowired
    private UserService userService;
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("TestQuartzJob 开始执行");
        List<User> list = userService.getUserByAge(18);
        logger.info("TestQuartzJob 执行结束，res:{}", JSON.toJSONString(list));
        
    }

}
