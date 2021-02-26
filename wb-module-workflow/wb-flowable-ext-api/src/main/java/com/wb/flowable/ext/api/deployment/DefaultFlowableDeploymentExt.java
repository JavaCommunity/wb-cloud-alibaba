package com.wb.flowable.ext.api.deployment;

import com.wb.flowable.ext.api.config.FlowableErrorEnum;
import com.wb.flowable.ext.api.utils.FlowableReqCheckUtils;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: DefaultFlowableDeploymentExt
 * @Package: com.wb.flowable.ext.api.deployment
 * @Description: the default flowable deployment ext
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
@Component
public class DefaultFlowableDeploymentExt implements FlowableDeploymentExt {

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public void checkForId(String deploymentId) {
        FlowableReqCheckUtils.checkEmpty(deploymentId, "deploymentId");

        if (ObjectUtils.isEmpty(queryForId(deploymentId))) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_DEPLOYMENT.getMsg());
        }
    }

    @Override
    public Deployment queryForId(String deploymentId) {
        FlowableReqCheckUtils.checkEmpty(deploymentId, "deploymentId");

        return repositoryService
                .createDeploymentQuery()
                .deploymentId(deploymentId)
                .singleResult();
    }
}
