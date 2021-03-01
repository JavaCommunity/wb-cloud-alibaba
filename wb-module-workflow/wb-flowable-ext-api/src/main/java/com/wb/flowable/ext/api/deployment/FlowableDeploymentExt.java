package com.wb.flowable.ext.api.deployment;

import org.flowable.engine.repository.Deployment;

/**
 * @ClassName: FlowableDeploymentExt
 * @Package: com.wb.flowable.ext.api.deployment
 * @Description: the flowable deployment ext
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public interface FlowableDeploymentExt {

    /**
     * check deployment with the specified deployment id
     *
     * @param deploymentId the deployment id
     */
    void checkForId(String deploymentId);

    /**
     * query deployment with the specified deployment id
     *
     * @param deploymentId the deployment id
     * @return the deployment info
     */
    Deployment queryForId(String deploymentId);

    /**
     * deploy process with the specified model id and code.
     *
     * @param modelId the model id
     * @param code    the code
     * @return teh deployment
     */
    Deployment deploy(String modelId, String code);
}
