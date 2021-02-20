package com.wb.workflow.core.config;

import com.wb.common.context.BaseContext;
import com.wb.common.wrapper.SysUserWrapper;

/**
 * @ClassName: WorkFlowContextHolder
 * @Package: com.wb.workflow.core.config
 * @Description: the work flow context holder
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowContextHolder extends BaseContext {

    /**
     * get current user info
     *
     * @return the user info
     */
    public static SysUserWrapper getCurrentUser() {
        SysUserWrapper userWrapper = new SysUserWrapper();
        userWrapper.setName("张三");
//        Object obj = get(CONTEXT_USER_KEY);
//        if (!ObjectUtils.isEmpty(obj) && obj instanceof SysUserWrapper) {
//            SysUserWrapper userEntity = (SysUserWrapper) obj;
//            return userEntity;
//        }
//        return null;
        return userWrapper;
    }
}
