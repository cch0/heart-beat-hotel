package com.test.websocket.config;

import com.test.websocket.service.DailyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public DailyService dailyService()
    {
        return new DailyService();
    }

}
