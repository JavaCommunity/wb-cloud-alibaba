package com.wb.office.component.config;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @ClassName: SupportFileTypeEnum
 * @Package: com.wb.office.component.config
 * @Description: the support file type enum
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public enum SupportFileTypeEnum {

    DOC,
    DOCX,
    PDF,
    XLSX,
    XLS;

    /**
     * the support file type with specified file type
     *
     * @param fileType the file type
     * @return the is support
     */
    public static boolean isSupport(String fileType) {
        return StringUtils.isEmpty(fileType) ? false : Arrays.asList(SupportFileTypeEnum.values())
                .stream().filter(type -> type.name().equalsIgnoreCase(fileType)).findAny().isPresent();
    }
}
