package com.project.api.data.controller;

import com.project.api.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maich
 * @date 2023/10/4 16:53
 */
@Slf4j
@RestController
public class DataController {

    @GetMapping("/test")
    public R test(){
        log.info("this only a test");
        return R.ok("test");
    }
}
