package com.wb.flowable.ext.api.model;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @ClassName: FlowableModelExt
 * @Package: com.wb.flowable.ext.api.model
 * @Description: the flowable model ext
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface FlowableModelExt {

    /**
     * create model with the specified flowable model request
     *
     * @param request the flowable model request
     * @return the model id
     */
    String create(FlowableModelRequest request);

    /**
     * query model with the specified model id
     *
     * @param modelId the model id
     * @return the model
     */
    ObjectNode queryForId(String modelId);
}
