package com.platform.main.bean.po;

import java.io.Serializable;

/**
 * BASE_ROLE2API
 */
public class BaseRole2api implements Serializable {

    private static final long serialVersionUID = 4125096758372084319L;


    private Long roleId;


    private Long apiId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }
}