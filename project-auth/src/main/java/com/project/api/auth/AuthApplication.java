package com.project.api.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {
    public static void main(String[] args) {
        //APP 每个服务的名称开头比如 APILogSpringApplication
        SpringApplication.run(AuthApplication.class, args);
    }
}

