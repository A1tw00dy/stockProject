package com.example.stock.config;
 
import com.example.stock.job.IndexDataSyncJob;
import org.checkerframework.checker.units.qual.Current;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.CurrentDateTimeProvider;


@Configuration
public class QuartzConfiguration {

//    private static final int interval = 1;

    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(IndexDataSyncJob.class).withIdentity("indexDataSyncJob").storeDurably().build();
    }

    @Bean
    public Trigger weatherDataSyncTrigger() {
//        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInMinutes(interval).repeatForever();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 16 * * ?");
//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1);
//        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
//                .withIdentity("indexDataSyncTrigger").withSchedule(scheduleBuilder).build();

        return TriggerBuilder.newTrigger().startNow().forJob(weatherDataSyncJobDetail()).withSchedule(scheduleBuilder).build();
    }
}