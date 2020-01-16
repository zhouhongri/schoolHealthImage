package com.platform.main.service.impl;

import com.platform.main.bean.bo.User;
import com.platform.main.bean.po.BaseAccount;
import com.platform.main.dao.AccountMapper;
import com.platform.main.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public User loadUserByUsername(String userName) {
        return accountMapper.loadUserByUsername(userName);
    }

    @Override
    public BaseAccount getBaseUserById(Long accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }
}
