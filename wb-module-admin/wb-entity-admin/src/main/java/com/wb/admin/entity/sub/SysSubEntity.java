package com.wb.admin.entity.sub;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: SysSubEntity
 * @Package: com.wb.admin.entity.sub
 * @Description: 系统子系统实体类
 * @Author：[bo.wang]
 * @Date: 2021/4/26
 * @Version: 1.0
 */
public class SysSubEntity extends BaseEntity {

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private String state;

    /**
     * 描述信息
     */
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
