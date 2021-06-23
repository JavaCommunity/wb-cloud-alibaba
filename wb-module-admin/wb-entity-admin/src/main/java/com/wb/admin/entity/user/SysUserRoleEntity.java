package com.wb.admin.entity.user;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: SysUserRoleEntity
 * @Package: com.wb.admin.entity.user
 * @Description: 系统用户角色实体类
 * @Author：[bo.wang]
 * @Date: 2021/4/26
 * @Version: 1.0
 */
public class SysUserRoleEntity extends BaseEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 子系统ID
     */
    private String subId;

    /**
     * 是否是默认角色
     */
    private String isDefault;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
