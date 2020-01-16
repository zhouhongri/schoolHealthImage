package com.platform.main.bean.po;

import java.io.Serializable;

/**
 * BASE_ACCOUNT2ROLE
 */
public class BaseAccount2role implements Serializable {

    private static final long serialVersionUID = 4125096758372084319L;


    private Long accountId;


    private Long roleId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}