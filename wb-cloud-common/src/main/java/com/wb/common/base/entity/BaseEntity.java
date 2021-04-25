package com.wb.common.base.entity;

import java.io.Serializable;

/**
 * @ClassName: BaseEntity
 * @Package: com.wb.common.base.entity
 * @Description: the base entity
 * @Author：[bo.wang]
 * @Date: 2021/1/19
 * @Version: 1.0
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -7401505758964001730L;

    private String id;

    private String createTime;

    private String createUserId;

    private String createUser;

    private String createOrgId;

    private String createOrg;

    private String updateTime;

    private String updateUserId;

    private String updateUser;

    private String forOrgId;

    private String delTime;

    private String delFlag;

    /**
     * 数据年度
     */
    private String dataYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId;
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getForOrgId() {
        return forOrgId;
    }

    public void setForOrgId(String forOrgId) {
        this.forOrgId = forOrgId;
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDataYear() {
        return dataYear;
    }

    public void setDataYear(String dataYear) {
        this.dataYear = dataYear;
    }
}
