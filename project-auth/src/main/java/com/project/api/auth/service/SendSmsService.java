package com.project.api.auth.service;

import com.project.api.common.result.R;
import com.project.api.auth.entity.SendCodeVo;

public interface SendSmsService {

    //获取验证码
    R sendCheckCode(String phone);


    //验证验证码
    R sendCheckPhoneCode(SendCodeVo vo);
}

