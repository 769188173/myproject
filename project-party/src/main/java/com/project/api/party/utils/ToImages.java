package com.project.api.party.utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ToImages {
    private String type;
    private String images;
    private MultipartFile multipartFile;
}

