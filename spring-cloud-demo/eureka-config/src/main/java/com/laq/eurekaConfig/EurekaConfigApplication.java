package com.laq.eurekaConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigApplication.class, args);
    }

}
