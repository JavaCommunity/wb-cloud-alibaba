package com.wb.oss.service.service.impl;

import com.wb.oss.component.client.OssClient;
import com.wb.oss.component.exception.OssServiceException;
import com.wb.oss.component.request.minio.MinioGetObjectRequest;
import com.wb.oss.component.request.minio.MinioPutObjectRequest;
import com.wb.oss.component.response.minio.MinioGetObjectResponse;
import com.wb.oss.component.response.minio.MinioPutObjectResponse;
import com.wb.oss.service.config.OssErrorMsgEnum;
import com.wb.oss.service.service.FileSingleService;
import com.wb.oss.service.vo.FileSingleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @ClassName: FileSingleServiceImpl
 * @Package: com.wb.oss.service.service.impl
 * @Description: the file single service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Service
public class FileSingleServiceImpl implements FileSingleService {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(FileSingleServiceImpl.class);

    @Autowired
    private OssClient ossClient;

    @Override
    public FileSingleVo upload(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            MinioPutObjectRequest putObjectRequest = new MinioPutObjectRequest("defaule",
                    file.getOriginalFilename(), inputStream);
            MinioPutObjectResponse putObjectResponse = ossClient.putObject(putObjectRequest);
            if (!putObjectResponse.isSuccess()) {
                throw new OssServiceException(OssErrorMsgEnum.FILE_SINGLE_UPLOAD.getErrMsg(), FileSingleServiceImpl.class);
            }
            FileSingleVo fileSingleVo = new FileSingleVo();
            fileSingleVo.setFileName(putObjectResponse.getObjectName());
            fileSingleVo.setSize(putObjectResponse.getSize());
            return fileSingleVo;
        } catch (Exception e) {
            log.error("[Oss Starter] File Single Upload Error,ErrMsg:{}", e.getMessage());
            throw new OssServiceException(OssErrorMsgEnum.FILE_SINGLE_UPLOAD.getErrMsg(), FileSingleServiceImpl.class);
        }
    }

    @Override
    public FileSingleVo download(String objectId) {
        Assert.hasLength(objectId, "'objectId' must not be null！");

        MinioGetObjectRequest minioGetObjectRequest = new MinioGetObjectRequest("defaule", objectId);
        MinioGetObjectResponse response = ossClient.getObject(minioGetObjectRequest);
        if (!response.isSuccess()) {
            throw new OssServiceException(OssErrorMsgEnum.FILE_SINGLE_DOWNLOAD.getErrMsg(), FileSingleServiceImpl.class);
        }

        FileSingleVo fileSingleVo = new FileSingleVo();
        fileSingleVo.setFileContent(response.getObjectContent());
        fileSingleVo.setFileName(objectId);
        return fileSingleVo;
    }
}
