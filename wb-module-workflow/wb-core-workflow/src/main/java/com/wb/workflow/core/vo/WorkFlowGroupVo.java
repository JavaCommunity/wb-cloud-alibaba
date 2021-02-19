package com.wb.workflow.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: WorkFlowGroupVo
 * @Package: com.wb.workflow.core.vo
 * @Description: the work flow group vo
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@ApiModel(value = "WorkFlowGroupVo", description = "流程分组信息vo")
public class WorkFlowGroupVo {

    @ApiModelProperty(value = "分组名称")
    private String name;

    @ApiModelProperty(value = "描述信息")
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
