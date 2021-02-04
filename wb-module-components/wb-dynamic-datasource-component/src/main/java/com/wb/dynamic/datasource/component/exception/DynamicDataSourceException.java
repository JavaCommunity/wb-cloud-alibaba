package com.wb.dynamic.datasource.component.exception;

/**
 * @ClassName: DynamicDataSourceException
 * @Package: com.wb.dynamic.datasource.component.exception
 * @Description: the dynamic datasource exception
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class DynamicDataSourceException extends RuntimeException {

    /**
     * constructs a new dynamic datasource exception
     */
    public DynamicDataSourceException() {
        super();
    }

    /**
     * constructs a new dynamic datasource exception with the specified message
     *
     * @param message the message
     */
    public DynamicDataSourceException(String message) {
        super(message);
    }
}
