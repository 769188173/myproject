package com.project.api.auth.entity;

import lombok.Data;

@Data
public class SendCodeVo {
    private String phone;
    private String code;
}

