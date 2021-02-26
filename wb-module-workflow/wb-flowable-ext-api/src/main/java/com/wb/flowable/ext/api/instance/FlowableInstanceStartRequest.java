package com.wb.flowable.ext.api.instance;

import java.util.Map;

/**
 * @ClassName: FlowableInstanceStartRequest
 * @Package: com.wb.flowable.ext.api.instance
 * @Description: the flowable instance start request
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public class FlowableInstanceStartRequest {

    //  the user id
    private String userId;

    //  the definition id
    private String definitionId;

    //  the business key
    private String businessKey;

    //  the variables
    private Map<String, Object> variables;

    /**
     * constructs a new flowable instance start request.
     */
    public FlowableInstanceStartRequest() {
    }

    /**
     * constructs a new flowable instance start request with
     * the specified user id and definition id and business key
     * and variables.
     *
     * @param userId       the user id
     * @param definitionId the definition id
     * @param businessKey  the business key
     * @param variables    the variables
     */
    public FlowableInstanceStartRequest(String userId, String definitionId, String businessKey, Map<String, Object> variables) {
        this.userId = userId;
        this.definitionId = definitionId;
        this.businessKey = businessKey;
        this.variables = variables;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
