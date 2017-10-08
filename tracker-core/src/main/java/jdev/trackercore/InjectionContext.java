package jdev.trackercore;

import Services.DataPeekService;
import Services.DataSendService;
import Services.GPSService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
public class InjectionContext {



    @Bean
    public DataPeekService dataPeekService() {
        return new DataPeekService();
    }

    @Bean
    public DataSendService dataSendService() {
        return new DataSendService();
    }

    @Bean
    public GPSService gpsService() {
        return new GPSService();
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }
}
