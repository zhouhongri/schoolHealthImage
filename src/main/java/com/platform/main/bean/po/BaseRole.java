package com.platform.main.bean.po;

import java.io.Serializable;

/**
 * base_role
 */
public class BaseRole implements Serializable {

    private static final long serialVersionUID = 4125096758372084310L;

    private Long roleId;

    private String roleSign;

    private String roleName;

    private String roleDescription;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

}