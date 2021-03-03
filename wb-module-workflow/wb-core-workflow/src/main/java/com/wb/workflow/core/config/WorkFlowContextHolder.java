package com.wb.workflow.core.config;

import com.wb.common.context.BaseContext;
import com.wb.common.wrapper.SysUserWrapper;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;
import org.springframework.util.ObjectUtils;

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

    //  the context user key
    public static final String CONTEXT_USER_KEY = "work_flow_user";

    //  the context user id key
    public static final String CONTEXT_USER_ID_KEY = "work_flow_user_id";

    /**
     * get current user info
     *
     * @return the user info
     */
    public static SysUserWrapper getCurrentUser() {
        Object obj = BaseContext.get(CONTEXT_USER_KEY);
        if (ObjectUtils.isEmpty(obj) || !(obj instanceof SysUserWrapper)) {
            return null;
        }
        SysUserWrapper userEntity = (SysUserWrapper) obj;
        return userEntity;
    }

    /**
     * set user wrapper
     *
     * @param userWrapper the user wrapper
     */
    public static void setCurrentUser(SysUserWrapper userWrapper) {
        WorkFlowReqCheckUtils.checkEmpty(userWrapper, "userWrapper");
        BaseContext.put(CONTEXT_USER_KEY, userWrapper);
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

    /**
     * clear default context
     */
    public static void clear() {
        BaseContext.clear();
    }
}
