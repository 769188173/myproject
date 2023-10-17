package com.project.api.login.controller;

import com.project.api.login.feign.LoginProductionFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginProductionFeignService loginProductionFeignService;

    @GetMapping("/info")
    public String info(@RequestParam("input") String input){
        return loginProductionFeignService.getInfo(input);
    }

}
