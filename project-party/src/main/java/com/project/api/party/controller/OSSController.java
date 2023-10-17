package com.project.api.party.controller;

import com.project.api.common.result.R;
import com.project.api.party.utils.OSSEntity;
import com.project.api.party.utils.ToImages;
import com.project.api.party.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

/**
 * @Author 小坏
 * @Date 2022/08/29 14:44
 * @Version 1.0
 * @program: 图片上传服务
 */

@RestController
@RequestMapping("party/oss")
public class OSSController {

    @Autowired
    private ImgService imgService;

    /**
     * @param toImages
     * @return
     */
    @PostMapping("toImages")
    public R toImages(@RequestBody ToImages toImages) {
        return imgService.toImages(toImages);

    }


    /**
     * 图片文件流转换base64
     *
     * @param file
     * @return
     */
    @PostMapping("upLoad")
    public R toImages(@RequestParam("file") MultipartFile file) throws IOException {
        return R.ok();
    }


    /**
     * 阿里云文件图片上传
     *
     * @param file
     * @return
     */
    @PostMapping("toFilePutLoad")
    public R toFilePutLoad(@RequestParam("file") MultipartFile file) {
        return imgService.toFilePutLoad(file);
    }


    /**
     * 阿里云BASE64图片上传
     *
     * @return
     */
    @PostMapping("toBasePutLoad")
    public R toBasePutLoad(@RequestBody OSSEntity os) {
        return imgService.toBasePutLoad(os);
    }

}

