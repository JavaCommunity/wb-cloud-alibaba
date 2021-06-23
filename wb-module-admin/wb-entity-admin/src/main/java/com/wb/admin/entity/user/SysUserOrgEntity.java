package com.wb.admin.entity.user;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: SysUserOrgEntity
 * @Package: com.wb.admin.entity.user
 * @Description: 系统用户机构实体类
 * @Author：[bo.wang]
 * @Date: 2021/4/26
 * @Version: 1.0
 */
public class SysUserOrgEntity extends BaseEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 机构ID
     */
    private String orgId;

    /**
     * 子系统ID
     */
    private String subId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }
}
