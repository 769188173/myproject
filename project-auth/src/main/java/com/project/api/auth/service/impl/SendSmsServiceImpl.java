package com.project.api.auth.service.impl;

import com.alibaba.alicloud.sms.ISmsService;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.project.api.common.result.R;
import com.project.api.common.utils.AuthServerConstant;
import com.project.api.common.utils.BizCodeEnume;
import com.project.api.common.utils.UUIDGenerator;
import com.project.api.auth.entity.SendCodeVo;
import com.project.api.auth.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author 小坏
 * @Date 2022/08/29 14:44
 * @Version 1.0
 * @program: 阿里云验证码封装
 */

@Service
public class SendSmsServiceImpl implements SendSmsService {

    @Value("${spring.cloud.alicloud.sms.code}")
    private String springAliSmsCode;

    @Autowired
    private ISmsService smsService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public R sendCheckCode(String phone) {

        //接口防刷
        //先验证redis是否有缓存验证码
        String redisCode = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone);
        System.out.println(redisCode);
        //如果命中缓存走
        if (!StringUtils.isEmpty(redisCode)) {
            long l = Long.parseLong(redisCode.split("_")[1]);
            if (System.currentTimeMillis() - l < 60000) {
                return R.error(BizCodeEnume.SMS_EXCEPTION.getCode(), BizCodeEnume.SMS_EXCEPTION.getMsg());
            }
        }

        //防止同一个phone在60秒内再次发送验证码
        String code = UUIDGenerator.MobileVfCode();
        String currentTime = code + "_" + System.currentTimeMillis();

        //防止同一个phone在60秒内再次发送验证码
        redisTemplate.opsForValue().set(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone, currentTime, 10, TimeUnit.MINUTES);

        //调用发送短信服务
        R r = sendCheckCode(phone, code);
        if (r.getCode() == 200) {
            return R.ok("发送成功！");
        }
        return R.error(BizCodeEnume.SMS_EXCEPTION.getCode(), BizCodeEnume.SMS_EXCEPTION.getMsg());
    }


    /**
     * 验证码登录对比
     *
     * @param vo
     * @return
     */
    @Override
    public R sendCheckPhoneCode(SendCodeVo vo) {
        //1、校验验证码
        //从redis中获取
        String code = vo.getCode();
        String b = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
        //如果命中缓存
        if (!StringUtils.isEmpty(b)) {
            //就把获取的code和redis中做对比
            if (code.equals(b.split("_")[0])) {
                //删除验证码
                redisTemplate.delete(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
                //验证码通过  //真正注册。调用远程服务进行注册/或者本地注册逻辑
                return R.ok("验证码对比成功！");

            } else {
                //验证不通过
                return R.error("验证码错误！");
            }
        } else {
            //如果等于null、就是没有查到
            return R.error("验证码超时！");
        }
    }

    public R sendCheckCode(String phone, String code) {
        SendSmsRequest request = new SendSmsRequest();
        // Required:the mobile number  接收短信的号码
        request.setPhoneNumbers(phone);
        // Required:SMS-SignName-could be found in sms console  签名
        request.setSignName("有铂科技");
        // Required:Template-could be found in sms console  模板
        request.setTemplateCode(springAliSmsCode);
        // Required:The param of sms template.For exmaple, if the template is "Hello,your verification code is ${code}". The param should be like following value
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = smsService.sendSmsRequest(request);
        } catch (ClientException e) {
            e.printStackTrace();
            sendSmsResponse = new SendSmsResponse();
        }

        if (sendSmsResponse.getCode().equals("OK")) {
            return R.ok(code);
        }

        if (sendSmsResponse.getCode().equals("isv.BUSINESS_LIMIT_CONTROL")) {
            return R.error("aliyun限流！");
        }
        return R.error("不存在");
    }


}


