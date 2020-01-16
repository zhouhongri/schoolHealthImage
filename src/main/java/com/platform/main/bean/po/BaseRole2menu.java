package com.platform.main.bean.po;

import java.io.Serializable;

/**
 * BASE_ROLE2MENU
 */
public class BaseRole2menu implements Serializable {

    private static final long serialVersionUID = 4125096758372084319L;


    private Long roleId;


    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}