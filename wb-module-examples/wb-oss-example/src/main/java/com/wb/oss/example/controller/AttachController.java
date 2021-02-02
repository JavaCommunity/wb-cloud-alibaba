package com.wb.oss.example.controller;

import com.wb.common.result.R;
import com.wb.oss.component.client.OssClient;
import com.wb.oss.component.request.minio.MinioGetObjectRequest;
import com.wb.oss.component.request.minio.MinioPutObjectRequest;
import com.wb.oss.component.request.minio.MinioRemoveObjectRequest;
import com.wb.oss.component.response.GenericResponse;
import com.wb.oss.component.response.minio.MinioGetObjectResponse;
import com.wb.oss.component.response.minio.MinioPutObjectResponse;
import com.wb.oss.component.response.minio.MinioRemoveObjectResponse;
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

//    @PostMapping("/upload")
//    public R<GenericResponse> upload(MultipartFile file) throws IOException {
//        MinioPutObjectRequest request = new MinioPutObjectRequest();
//        request.setObjectName(file.getOriginalFilename());
//        request.setObjectContent(file.getInputStream());
//        request.setContentType(file.getContentType());
//        request.setSize(file.getSize());
//        request.setBucketName("defaultds");
//        request.setObjectId("122222222222222222222222223123");
//        MinioPutObjectResponse minioResponse = ossClient.putObject(request);
//        return R.ok().data(minioResponse);
//    }

//    @GetMapping("/get")
//    public void get() throws IOException {
//        MinioGetObjectRequest request = new MinioGetObjectRequest();
//        request.setBucketName("defaultds123123");
//        request.setObjectName("访问是否成功.txt");
//        MinioGetObjectResponse minioGetResponse = ossClient.getObject(request);
//        System.out.println(minioGetResponse);
//    }
//
//    @GetMapping("/remove")
//    public R<MinioRemoveObjectResponse> remove() throws IOException {
//        MinioRemoveObjectRequest request = new MinioRemoveObjectRequest();
//        request.setBucketName("defaultds");
//        request.setObjectName("访问是否成功.txt");
//        MinioRemoveObjectResponse removeResponse = ossClient.removeObject(request);
//        return R.ok().data(removeResponse);
//    }
}
