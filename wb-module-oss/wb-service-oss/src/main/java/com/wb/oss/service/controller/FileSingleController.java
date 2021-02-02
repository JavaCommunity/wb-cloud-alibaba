package com.wb.oss.service.controller;

import com.wb.common.result.R;
import com.wb.common.utils.file.ResponseFileUtils;
import com.wb.oss.service.service.FileSingleService;
import com.wb.oss.service.vo.FileSingleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: FileUploadSingleController
 * @Package: com.wb.oss.service.controller
 * @Description: the file single controller
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@RestController
@RequestMapping("file/single/")
public class FileSingleController {

    @Autowired
    private FileSingleService fileSingleService;

    @PostMapping(value = "v1/upload")
    public R<FileSingleVo> upload(MultipartFile file) {
        FileSingleVo fileSingleVo = fileSingleService.upload(file);
        return R.ok().data(fileSingleVo);
    }

    @GetMapping(value = "v1/download")
    public void download(@RequestParam(value = "objectId") String objectId, HttpServletRequest req, HttpServletResponse resp) {
        FileSingleVo fileSingleVo = fileSingleService.download(objectId);
        ResponseFileUtils.responseFile(fileSingleVo.getFileContent(),
                fileSingleVo.getFileName(), "docx", 0l, req, resp);
    }
}
