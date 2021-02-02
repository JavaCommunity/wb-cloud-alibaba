package com.wb.oss.feign.api.filesingle;

import com.wb.common.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: FileSingleFeignService
 * @Package: com.wb.oss.feign.api.filesingle
 * @Description: the file single service
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@FeignClient(name = "${wb-cloud.feign.oss-application-name}", fallback = FileSingleFeignServiceImpl.class)
public interface FileSingleFeignService {

    @PostMapping(value = "file/single/v1/upload")
    R<FileSingleFeignVo> upload(MultipartFile file);
}
