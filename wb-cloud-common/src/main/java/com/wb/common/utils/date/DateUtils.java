package com.wb.common.utils.date;

import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtils
 * @Package: com.wb.common.utils.date
 * @Description: the date utils
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class DateUtils {

    //  the date format
    public static SimpleDateFormat DATE_FORMAT = null;

    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return
     */
    public static String formatDateTime(Date date) {
        if (ObjectUtils.isEmpty(date)) {
            return null;
        }
        return DATE_FORMAT.format(date);
    }

    /**
     * 将string字符串类型的日期转换为date
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String strDate) throws ParseException {
        return DATE_FORMAT.parse(strDate);
    }
}
