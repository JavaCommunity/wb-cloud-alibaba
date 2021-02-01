package com.wb.oss.example.controller;

import com.wb.common.result.R;
import com.wb.oss.component.client.OssClient;
import com.wb.oss.component.request.minio.MinioGetRequest;
import com.wb.oss.component.request.minio.MinioPutRequest;
import com.wb.oss.component.request.minio.MinioRemoveRequest;
import com.wb.oss.component.response.OssResponse;
import com.wb.oss.component.response.minio.MinioGetResponse;
import com.wb.oss.component.response.minio.MinioPutResponse;
import com.wb.oss.component.response.minio.MinioRemoveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public R<OssResponse> upload(MultipartFile file) throws IOException {
        MinioPutRequest request = new MinioPutRequest();
        request.setObjectName(file.getOriginalFilename());
        request.setObjectContent(file.getInputStream());
        request.setContentType(file.getContentType());
        request.setSize(file.getSize());
        request.setBucketName("defaultds");
        request.setObjectId("122222222222222222222222223123");
        MinioPutResponse minioResponse = ossClient.putObject(request);
        return R.ok().data(minioResponse);
    }

    @GetMapping("/get")
    public void get() throws IOException {
        MinioGetRequest request = new MinioGetRequest();
        request.setBucketName("defaultds123123");
        request.setObjectName("访问是否成功.txt");
        MinioGetResponse minioGetResponse = ossClient.getObject(request);
        System.out.println(minioGetResponse);
    }

    @GetMapping("/remove")
    public R<MinioRemoveResponse> remove() throws IOException {
        MinioRemoveRequest request = new MinioRemoveRequest();
        request.setBucketName("defaultds");
        request.setObjectName("访问是否成功.txt");
        MinioRemoveResponse removeResponse = ossClient.removeObject(request);
        return R.ok().data(removeResponse);
    }
}
