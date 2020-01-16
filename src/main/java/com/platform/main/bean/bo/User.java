package com.platform.main.bean.bo;

import com.platform.main.bean.po.BaseAccount;
import com.platform.main.bean.po.BaseRole;
import com.platform.main.bean.po.BaseUser;

import java.io.Serializable;
import java.util.List;

public class User extends BaseAccount implements Serializable {

    private static final long serialVersionUID = 4125096758372084309L;

    private BaseUser baseUser;

    private List<BaseRole> baseRoleList;

    public BaseUser getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }

    public List<BaseRole> getBaseRoleList() {
        return baseRoleList;
    }

    public void setBaseRoleList(List<BaseRole> baseRoleList) {
        this.baseRoleList = baseRoleList;
    }

}
