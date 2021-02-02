package com.wb.common.utils.file;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;

/**
 * @ClassName: ResponseFileUtils
 * @Package: com.wb.common.utils.file
 * @Description: the response file utils
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class ResponseFileUtils {

    /**
     * the response file to browser
     *
     * @param fileContent the file content
     * @param fileName    the file name
     * @param fileSize    the file size
     * @param req         the http servlet request
     * @param resp        the http servlet response
     */
    public static void responseFile(InputStream fileContent, String fileName, String contentType, long fileSize, HttpServletRequest req, HttpServletResponse resp) {
        Assert.notNull(fileContent, "'fileContent' must not null！");

        try (InputStream inputStream = new BufferedInputStream(fileContent);
             BufferedOutputStream outputStream = new BufferedOutputStream(resp.getOutputStream())) {
            resp.setCharacterEncoding("UTF-8");
            String downloadFileName = null;
            String userAgent = req.getHeader("User-Agent");
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                downloadFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            } else {
                downloadFileName = new String((fileName).getBytes("UTF-8"), "ISO-8859-1");
            }
            ResponseFileUtils.handleContentType(contentType, resp);
            resp.setHeader("Content-disposition", "attachment; filename=" + downloadFileName);
            // resp.setHeader("Content-Length", String.valueOf(fileSize));
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = inputStream.read(buff, 0, buff.length))) {
                outputStream.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * the handle content type
     *
     * @param contentType the content type
     * @param resp        the http servlet response
     */
    private static void handleContentType(String contentType, HttpServletResponse resp) {
        if (StringUtils.isEmpty(contentType)) {
            return;
        }

        switch (contentType) {
            case "text":
                resp.setContentType("text/plain;");
                break;
            case "doc":
                resp.setContentType("application/msword;");
                break;
            case "xls":
                resp.setContentType("application/ms-excel;");
                break;
            case "pdf":
                resp.setContentType("application/pdf;");
                break;
            case "jpg":
            case "jpeg":
                resp.setContentType("image/jpeg;");
                break;
            default:
                resp.setContentType("application/x-msdownload;");
        }
    }
}
