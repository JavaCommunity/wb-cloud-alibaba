package com.wb.admin.entity.role;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: SysRoleMenuEntity
 * @Package: com.wb.admin.entity.role
 * @Description: 系统角色菜单实体类
 * @Author：[bo.wang]
 * @Date: 2021/4/26
 * @Version: 1.0
 */
public class SysRoleMenuEntity extends BaseEntity {

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 子系统ID
     */
    private String subId;

    /**
     * 状态
     */
    private String state;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
