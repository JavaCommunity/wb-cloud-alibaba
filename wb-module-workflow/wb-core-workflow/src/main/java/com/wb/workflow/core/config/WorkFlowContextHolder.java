package com.wb.workflow.core.config;

import com.wb.common.context.BaseContext;
import com.wb.common.wrapper.SysUserWrapper;

import java.util.Optional;

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
        userWrapper.setId("111111111111");
        userWrapper.setCreateOrg("技术部");
        userWrapper.setCreateOrgId("222222222222222222222");
//        Object obj = get(CONTEXT_USER_KEY);
//        if (!ObjectUtils.isEmpty(obj) && obj instanceof SysUserWrapper) {
//            SysUserWrapper userEntity = (SysUserWrapper) obj;
//            return userEntity;
//        }
//        return null;
        return userWrapper;
    }

    /**
     * get current user id
     *
     * @return the current user id
     */
    public static String getCurrentUserId() {
        SysUserWrapper currentUser = getCurrentUser();
        return Optional.ofNullable(currentUser.getId()).orElse(null);
    }
}
