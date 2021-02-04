package com.wb.quartz.component.vo;

import java.io.Serializable;

/**
 * @ClassName: MethodUtils
 * @Package: com.wb.quartz.component.vo
 * @Description: the quartz job vo
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class QuartzJobVo implements Serializable {

    //  the slf4j log
    private static final long serialVersionUID = 58414302829411473L;

    //  the code
    private String code;

    //  the name
    private String name;

    //  the group
    private String group;

    //  the core expression
    private String cronExpression;

    //  the bean id
    private String beanId;

    //  the resource class
    private String resourceClass;

    //  the method name
    private String methodName;

    //  the data
    private String data;

    //  the misfire type
    private String misfireType;

    //  the trigger name
    private String triggerName;

    //  the trigger group
    private String triggerGroup;

    //  the status
    private String status;

    //  the description
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getResourceClass() {
        return resourceClass;
    }

    public void setResourceClass(String resourceClass) {
        this.resourceClass = resourceClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMisfireType() {
        return misfireType;
    }

    public void setMisfireType(String misfireType) {
        this.misfireType = misfireType;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
