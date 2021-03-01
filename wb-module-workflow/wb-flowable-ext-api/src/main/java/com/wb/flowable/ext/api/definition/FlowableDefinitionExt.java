package com.wb.flowable.ext.api.definition;

import org.flowable.engine.repository.ProcessDefinition;

/**
 * @ClassName: FlowableDefinitionExt
 * @Package: com.wb.flowable.ext.api.definition
 * @Description: the flowable definition ext
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public interface FlowableDefinitionExt {

    /**
     * check definition with the specified the definition id
     *
     * @param definitionId the definition id
     */
    void checkForId(String definitionId);

    /**
     * query definition with the specified definition id
     *
     * @param definitionId the definition id
     * @return the process definition
     */
    ProcessDefinition queryForId(String definitionId);

    /**
     * query definition with the specified deploy id.
     *
     * @param deployId the deploy id
     * @return the process definition
     */
    ProcessDefinition queryForDeployId(String deployId);
}
