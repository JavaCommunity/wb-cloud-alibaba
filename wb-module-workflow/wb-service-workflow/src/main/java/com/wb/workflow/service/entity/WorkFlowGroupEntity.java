package com.wb.workflow.service.entity;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: WorkFlowGroupEntity
 * @Package: com.wb.workflow.service.entity
 * @Description: the work flow group entity
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowGroupEntity extends BaseEntity {

    /**
     * 名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
