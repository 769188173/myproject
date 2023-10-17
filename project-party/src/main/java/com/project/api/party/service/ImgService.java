package com.project.api.party.service;

import com.project.api.common.result.R;
import com.project.api.party.utils.OSSEntity;
import com.project.api.party.utils.ToImages;
import org.springframework.web.multipart.MultipartFile;

public interface ImgService {
    R toImages(ToImages toImages);

    R toFilePutLoad(MultipartFile file);

    R toBasePutLoad(OSSEntity oss);
}
