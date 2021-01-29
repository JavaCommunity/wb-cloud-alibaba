package com.wb.oss.example.controller;

import com.wb.common.result.R;
import com.wb.oss.component.client.OssClient;
import com.wb.oss.component.request.minio.MinioRequest;
import com.wb.oss.component.response.OssResponse;
import com.wb.oss.component.response.minio.MinioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: AttachController
 * @Package: com.wb.oss.example.controller
 * @Description: the attach controller
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/attach/")
public class AttachController {

    @Autowired
    private OssClient ossClient;

    @PostMapping("/upload")
    public R<OssResponse> upload(MultipartFile file) {
        MinioRequest minioRequest = new MinioRequest();
        MinioResponse minioResponse = ossClient.putObject(minioRequest);
        return R.ok().data(minioResponse);
    }
}
