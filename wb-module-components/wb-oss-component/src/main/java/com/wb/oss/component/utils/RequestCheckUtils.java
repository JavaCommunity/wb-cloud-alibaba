package com.wb.oss.component.utils;

import com.wb.oss.component.exception.OssServiceException;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RequestCheckUtils
 * @Package: com.wb.oss.component.utils
 * @Description: the request check utils
 * @Author：[bo.wang]
 * @Date: 2021/2/1
 * @Version: 1.0
 */
public class RequestCheckUtils {

    //  the default bucket verify str
    public static final String DEFAULT_BUCKET_VERIFY_STR = "^[^-][0-9a-z-]{2,63}$";

    //  the default bucket pattern
    public static final Pattern DEFAULT_BUCKET_PATTERN = Pattern.compile(DEFAULT_BUCKET_VERIFY_STR);

    /**
     * the check bucket with specified bucket name
     *
     * @param bucketName the bucket name
     * @return <tt>true<tt/> the check success
     */
    public static boolean checkBucket(String bucketName) {
        if (StringUtils.isEmpty(bucketName) || !regularExpressionMatcher(bucketName, DEFAULT_BUCKET_PATTERN)) {
            throw new OssServiceException(String.format("the specified bucketName[%s] contains illegal characters, allowing only %s",
                    bucketName, DEFAULT_BUCKET_VERIFY_STR), RequestCheckUtils.class);
        }
        return true;
    }

    /**
     * the regular expression matcher
     *
     * @param origin  the origin
     * @param pattern the pattern
     * @return <tt>true<tt/> the match success
     */
    public static boolean regularExpressionMatcher(String origin, Pattern pattern) {
        if (pattern == null) {
            return true;
        }
        Matcher matcher = pattern.matcher(origin);
        return matcher.matches();
    }
}
