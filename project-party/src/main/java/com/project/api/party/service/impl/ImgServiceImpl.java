package com.project.api.party.service.impl;

import com.project.api.common.result.R;
import com.project.api.party.utils.OSSEntity;
import com.project.api.party.utils.ToImages;
import com.project.api.party.service.ImgService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Author 小坏
 * @Date 2022/08/29 14:44
 * @Version 1.0
 * @program: 图片统一转换
 */
@Service
public class ImgServiceImpl implements ImgService {
    @Override
    public R toImages(ToImages toImages) {
        return null;
    }

    @Override
    public R toFilePutLoad(MultipartFile file) {
        return null;
    }

    @Override
    public R toBasePutLoad(OSSEntity oss) {
        return null;
    }


//    @Resource
//    private OSSClient ossClient;
//
//    @Override
//    public R toImages(ToImages toImages) {
//        return R.ok();
//    }
//
//
//    @Override
//    public R toFilePutLoad(MultipartFile file) {
//        OSSEntity ossEntity = OSSUtils.build().putOSS(file);
//        HashMap<String, Object> map = getStringObjectHashMap(ossEntity);
//        return R.ok().setDta(map);
//    }
//
//    @Override
//    public R toBasePutLoad(OSSEntity os) {
//        OSSEntity ossEntity = OSSUtils.build().putOSS(os.getImage());
//        HashMap<String, Object> map = getStringObjectHashMap(ossEntity);
//        return R.ok().setDta(map);
//
//    }
//
//    private HashMap<String, Object> getStringObjectHashMap(OSSEntity ossEntity) {
//        ossClient.putObject(BizCodeEnume.ALI_BUCKET.getMsg(),
//                ossEntity.getFilename(),
//                ossEntity.getInputStream(),
//                ossEntity.getObjectMetadata());
//        String url = ossEntity.getUrl().concat(ossEntity.getFilename());
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("url", url);
//        return map;
//    }
}
