package com.project.api.party.utils;

//import com.aliyun.oss.model.ObjectMetadata;
import lombok.Data;

import java.io.InputStream;

@Data
public class OSSEntity {
    private String image;
    private String  filename;
    private InputStream inputStream;
//    private ObjectMetadata objectMetadata;
    private String url;
}

