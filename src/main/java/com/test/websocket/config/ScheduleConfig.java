package com.test.websocket.config;

import com.test.websocket.service.HeartBeatService;
import com.test.websocket.service.Registrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jay on 12/25/14.
 */

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduleConfig {

    @Bean
    public Registrar registrar()
    {
        return new Registrar();
    }

    @Bean
    public HeartBeatService heartBeatService()
    {
        return new HeartBeatService();
    }
}
