package com.project.api.auth.controller;

import com.project.api.common.result.R;
import com.project.api.auth.entity.SendCodeVo;
import com.project.api.auth.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author 小坏
 * @Date 2022/08/29 14:44
 * @Version 1.0
 * @program: 普通登录
 */

@RestController
@RequestMapping("/auth/login")
public class AuthLoginController {

    @Autowired
    private SendSmsService sendSmsService;


    @GetMapping("sendMail")
    public void sendMail() {
        System.out.println("邮箱");
    }

    /**
     * 阿里云获取验证码
     * @param phone
     * @return
     */
    @GetMapping("sendCode")
    public R sendCode(@RequestParam("phone") String phone) {
        return R.ok(sendSmsService.sendCheckCode(phone));
    }

    /**
     * 验证验证码
     * @param vo
     * @return
     */
    @PostMapping("sendCheckPhoneCode")
    public R sendCheckPhoneCode(@RequestBody SendCodeVo vo) {
        return R.ok(sendSmsService.sendCheckPhoneCode(vo));
    }

}


