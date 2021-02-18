package com.wb.flowable.ext.api.idgenerator;

import java.util.UUID;

/**
 * @ClassName: DefaultFlowableIdGeneratorExt
 * @Package: com.wb.flowable.ext.api.idgenerator
 * @Description: the default flowable id generator ext
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class DefaultFlowableIdGeneratorExt implements FlowableIdGeneratorExt {

    //  the id prefix
    private String idPrefix;

    /**
     * constructs a new default flowable id generator ext with the specified id prefix
     *
     * @param idPrefix the id prefix
     */
    public DefaultFlowableIdGeneratorExt(String idPrefix) {
        this.idPrefix = idPrefix;
    }

    @Override
    public String getNextId() {
        return idPrefix + UUID.randomUUID().toString();
    }
}
