package com.project.api.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LoginApplication {
    public static void main(String[] args) {
        //APP 每个服务的名称开头比如 APILogSpringApplication
        SpringApplication.run(LoginApplication.class, args);
    }
}

