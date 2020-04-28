package com.srtmaker.configuration;

import com.srtmaker.service.SrtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SrtService getSrtService() {
        return new SrtService();
    }
}
