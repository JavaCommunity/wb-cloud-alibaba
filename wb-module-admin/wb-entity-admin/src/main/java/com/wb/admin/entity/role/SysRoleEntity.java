package com.wb.admin.entity.role;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: SysRoleEntity
 * @Package: com.wb.admin.entity.role
 * @Description: 系统角色表
 * @Author：[bo.wang]
 * @Date: 2021/4/26
 * @Version: 1.0
 */
public class SysRoleEntity extends BaseEntity {

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

    /**
     * 子系统ID
     */
    private String subId;

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

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }
}
