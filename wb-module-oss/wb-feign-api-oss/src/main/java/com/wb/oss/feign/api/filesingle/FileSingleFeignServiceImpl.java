package com.wb.oss.feign.api.filesingle;

import com.wb.common.result.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: FileSingleFeignServiceImpl
 * @Package: com.wb.oss.feign.api.filesingle
 * @Description: the file single feign service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class FileSingleFeignServiceImpl implements FileSingleFeignService {

    @Override
    public R<FileSingleFeignVo> upload(MultipartFile file) {
        return null;
    }
}
