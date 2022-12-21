package com.example.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ThirdPartIndexDataProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdPartIndexDataProjectApplication.class, args);
    }

}
