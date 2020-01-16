package com.platform.main.service;

import com.platform.main.bean.bo.User;
import com.platform.main.bean.po.BaseAccount;

public interface UserService {

    User loadUserByUsername(String userName);

    BaseAccount getBaseUserById(Long accountId);
}
