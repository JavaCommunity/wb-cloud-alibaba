package com.wb.oss.service.service;

import com.wb.oss.service.vo.FileSingleVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: FileSingleService
 * @Package: com.wb.oss.service.service
 * @Description: the file single service
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public interface FileSingleService {

    /**
     * the file single upload
     *
     * @param file the file
     * @return the file single vo
     */
    FileSingleVo upload(MultipartFile file);

    /**
     * the file single download with the specified object id
     *
     * @param objectId the object id
     * @return the file single vo
     */
    FileSingleVo download(String objectId);
}
