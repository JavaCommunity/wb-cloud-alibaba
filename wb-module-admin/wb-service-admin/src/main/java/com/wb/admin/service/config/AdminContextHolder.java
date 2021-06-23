package com.wb.admin.service.config;

import com.wb.common.wrapper.SysUserWrapper;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AdminContextHolder
 * @Package: com.wb.admin.service.config
 * @Description: admin上下文
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
public class AdminContextHolder {

    //  token key
    private static final String CONTEXT_TOKEN_KEY = "oauth2_token";

    //  user key
    private static final String CONTEXT_USER_KEY = "user";

    //  上下文
    private static final ThreadLocal<Map<String, Object>> DEFAULT_CONTEXT = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>(16);
        }
    };

    /**
     * 设置token
     *
     * @param token
     */
    public static void setToken(final String token) {
        Assert.hasText(token, "'token' must not be null！");

        DEFAULT_CONTEXT.get().put(CONTEXT_TOKEN_KEY, token);
    }

    /**
     * 清除
     */
    public static void clear() {
        DEFAULT_CONTEXT.get().clear();
    }

    /**
     * 获取当前用户信息
     *
     * @return
     */
    public static SysUserWrapper getCurrentUser() {
        Object obj = DEFAULT_CONTEXT.get().get(CONTEXT_USER_KEY);
        if (ObjectUtils.isEmpty(obj) || !(obj instanceof SysUserWrapper)) {
            return null;
        }
        SysUserWrapper userEntity = (SysUserWrapper) obj;
        return userEntity;
    }
}
