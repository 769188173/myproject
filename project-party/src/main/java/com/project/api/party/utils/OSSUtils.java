package com.project.api.party.utils;

//import com.aliyun.oss.model.ObjectMetadata;
import com.project.api.common.utils.BASE64DecodedMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OSSUtils {


    private final static String bucketName = "https://alibaba-api.oss-cn-shanghai.aliyuncs.com/";

    /**
     * 文件流上传阿里云
     *
     * @param file
     * @return
     */
    public OSSEntity putOSS(MultipartFile file) {
        return putLoadOSS(file);
    }

    /**
     * base64上传阿里云
     *
     * @param base64
     * @return
     */
    public OSSEntity putOSS(String base64) {
        String base = "data:image/jpg;base64,/".concat(base64);
        MultipartFile file = BASE64DecodedMultipartFile.base64ToMultipart(base);
        return putLoadOSS(file);
    }

    /**
     * base64上传阿里云
     * @param file
     * @return
     */
    private OSSEntity putLoadOSS(MultipartFile file) {
        return null;
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        //获取上传文件的扩展名,截取扩展名
//        //设置文本类型
//        objectMetadata.setContentType("image/jpg");
//        InputStream inputStream = null;
//        try {
//            inputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //获取上传的文件的名字
//        String filename = file.getOriginalFilename();
//        //随机uuid是为了拼接文件名，防止用户上传两个名字相同的文件后覆盖掉前一个
//        UUID uuid = UUID.randomUUID();
//        //这里是为了按上传时间分配目录。精确到月
//        String date = new SimpleDateFormat("yyyy/MM/").format(new Date());
//        //拼接成完整的文件名。
//        filename = date.concat(uuid.toString()).concat(filename);
//
//        OSSEntity oss = new OSSEntity();
//        oss.setFilename(filename);
//        oss.setInputStream(inputStream);
//        oss.setObjectMetadata(objectMetadata);
//        oss.setUrl(bucketName);
//        return oss;
    }


    public static OSSUtils build() {
        return new OSSUtils();
    }
}
