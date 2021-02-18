package com.wb.common.wrapper;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: SysUserWrapper
 * @Package: com.wb.common.wrapper
 * @Description: the sys user wrapper
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class SysUserWrapper extends BaseEntity {

    //  the user name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
