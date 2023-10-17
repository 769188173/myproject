package com.project.api.production.java;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RefreshScope
@Slf4j
class productionController {
    @Value("${haha:1}")
    private String info;
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getInfo(@RequestParam String input) {
        log.info("hello");
        return "Hello Nacos Discovery " + info + "input=" + input;
    }
}