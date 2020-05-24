package com.liuaq.userclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy
@ComponentScan("com.liuaq.userclient.*")
public class UserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);
    }

}
