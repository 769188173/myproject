package com.project.api.production;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProductionApplication {
    public static void main(String[] args) {
        //APP 每个服务的名称开头比如 APILogSpringApplication
        SpringApplication.run(ProductionApplication.class, args);
    }
}

