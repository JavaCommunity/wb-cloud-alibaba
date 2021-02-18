package com.wb.flowable.ext.api.config;

/**
 * @ClassName: FlowableAppendSignTypeEnum
 * @Package: com.wb.flowable.ext.api.config
 * @Description: the flowable append sign type enum
 * @Author：[bo.wang]
 * @Date: 2021/2/10
 * @Version: 1.0
 */
public enum FlowableAppendSignTypeEnum {

    BEFORE("BEFORE", "前加签"),
    AFTER("AFTER", "后加签");;

    //  the type
    private String type;

    //  the description
    private String description;

    /**
     * constructs a new flowableAppendSignTypeEnum with the
     * specified type and description.
     *
     * @param type        the type
     * @param description the description
     */
    FlowableAppendSignTypeEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
