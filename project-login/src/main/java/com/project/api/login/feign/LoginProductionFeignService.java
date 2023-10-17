package com.project.api.login.feign;

import com.project.api.login.fallback.LoginFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "project-production",fallback = LoginFallbackFactory.class)
public interface LoginProductionFeignService {

    @GetMapping("/info")
    String getInfo(@RequestParam("input") String input);
}




