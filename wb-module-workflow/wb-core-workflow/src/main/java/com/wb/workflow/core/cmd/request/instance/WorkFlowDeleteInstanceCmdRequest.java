package com.wb.workflow.core.cmd.request.instance;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowDeleteInstanceCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.instance
 * @Description: the work flow delete instance cmd request
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public class WorkFlowDeleteInstanceCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    //  the delete reason
    private String deleteReason;

    //  the cascade
    private boolean cascade;

    @Override
    public void check() {

    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public boolean isCascade() {
        return cascade;
    }

    public void setCascade(boolean cascade) {
        this.cascade = cascade;
    }
}
