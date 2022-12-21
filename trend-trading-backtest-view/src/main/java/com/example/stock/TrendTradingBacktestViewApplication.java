package com.example.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TrendTradingBacktestViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrendTradingBacktestViewApplication.class, args);
    }

}
