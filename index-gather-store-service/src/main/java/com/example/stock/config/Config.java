package com.example.stock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Config {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
