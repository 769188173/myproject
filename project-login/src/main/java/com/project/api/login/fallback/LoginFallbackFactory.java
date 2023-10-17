package com.project.api.login.fallback;

import com.alibaba.fastjson.JSONObject;
import com.project.api.login.feign.LoginProductionFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

@Slf4j
public class LoginFallbackFactory implements FallbackFactory {
    @Override
    public LoginProductionFeignService create(Throwable cause) {
        log.error("服务异常。。。。。。。。。。。。。。。。。。。" + cause);
        return input -> {
            JSONObject  data = new JSONObject();
            data.put("code","414");
            data.put("message","Fallback回滚，远程调用失败");
            return data.toJSONString();
        };
    }
}
