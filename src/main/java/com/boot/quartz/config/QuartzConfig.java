package com.boot.quartz.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot.quartz.job.TestQuartz;
import com.boot.quartz.job.TestQuartz2;

@Configuration
public class QuartzConfig {

//    @Bean("job1")
    public JobDetail testQuartzDetail() {
        return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz1", "test")
                .storeDurably()
                .build();
    }

//    @Bean("trigger1")
    public Trigger testQuartzTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(testQuartzDetail()).withIdentity("testQuartz1", "test")
                .withSchedule(scheduleBuilder).build();
    }

//    @Bean("job2")
    public JobDetail testQuartzDetail2() {
        return JobBuilder.newJob(TestQuartz2.class).withIdentity("testQuartz2", "test").storeDurably().build();
    }

//    @Bean("trigger2")
    public Trigger testQuartzTrigger2() throws SchedulerException {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/15 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(testQuartzDetail2()).withIdentity("testQuartz2", "test")
                .withSchedule(scheduleBuilder).build();
    }

}
