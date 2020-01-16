package com.platform.main.bean.po;

import java.io.Serializable;
import java.util.Date;

/**
 * base_account
 */
public class BaseAccount implements Serializable {

    private static final long serialVersionUID = 4125096758372084319L;

    private Long accountId;

    private Long userId;

    private String loginName;

    private String loginPwd;

    private String phone;

    private String email;

    private Date registerTime;

    private Date lastLoginTime;

    private Date lastPwdModifyTime;

    private Integer passwordRetry;

    /**
     * -1：已删除
     * 1：正常
     * 2：账号未启用
     * 3：账号已被锁定
     */
    private Integer state;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastPwdModifyTime() {
        return lastPwdModifyTime;
    }

    public void setLastPwdModifyTime(Date lastPwdModifyTime) {
        this.lastPwdModifyTime = lastPwdModifyTime;
    }

    public Integer getPasswordRetry() {
        return passwordRetry;
    }

    public void setPasswordRetry(Integer passwordRetry) {
        this.passwordRetry = passwordRetry;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}