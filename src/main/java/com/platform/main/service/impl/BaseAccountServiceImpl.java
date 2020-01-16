package com.platform.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.code.util.Constant;
import com.platform.code.util.StringUtils;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseAccount;
import com.platform.main.bean.po.BaseAccount2role;
import com.platform.main.dao.AccountMapper;
import com.platform.main.dao.BaseAccount2roleMapper;
import com.platform.main.service.BaseAccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class BaseAccountServiceImpl extends BaseService implements BaseAccountService {

    @Resource
    private AccountMapper baseAccountMapper;

    @Resource
    private BaseAccount2roleMapper baseAccount2roleMapper;

    @Override
    public AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseAccount> pageInfo) {
        if (pageInfo != null) {
            Page<BaseAccount> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            baseAccountMapper.selectByBean(pageInfo.getObj());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setResult(page.getResult());
            ajaxResponseBody.setResult(pageInfo);
        }
        return ajaxResponseBody;
    }

    @Override
    public AjaxResponseBody selectByPrimaryKey(AjaxResponseBody ajaxResponseBody, Long accountId) {
        if (accountId != null) {
            BaseAccount baseAccount = baseAccountMapper.selectByPrimaryKey(accountId);
            ajaxResponseBody.setResult(baseAccount);
        }
        return ajaxResponseBody;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void batchDeleteByPrimaryKey(Long[] accountIds) {
        if (accountIds != null && accountIds.length > 0) {
            List list = Arrays.asList(accountIds);
            baseAccountMapper.batchDeleteByPrimaryKey(list);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void deleteByPrimaryKey(Long accountId) {
        if (accountId != null && accountId > 0) {
            baseAccountMapper.deleteByPrimaryKey(accountId);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void insert(BaseAccount baseAccount) {
        if (baseAccount != null) {
            if (baseAccount.getState() == null) {
                baseAccount.setState(1);
            }
            baseAccount.setRegisterTime(new Date());
            baseAccount.setPasswordRetry(1);
            if (StringUtils.isEmpty(baseAccount.getLoginPwd())) {
                baseAccount.setLoginPwd(Constant.DEFAULT_LOGIN_PASSWORD);
            }
            baseAccount.setLoginPwd(new BCryptPasswordEncoder().encode(baseAccount.getLoginPwd()));
            baseAccountMapper.insert(baseAccount);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void updateByPrimaryKey(BaseAccount baseAccount) {
        if (baseAccount != null && baseAccount.getAccountId() != null) {
            if (StringUtils.isEmpty(baseAccount.getLoginPwd())) {
                baseAccount.setLoginPwd(Constant.DEFAULT_LOGIN_PASSWORD);
            }
            baseAccount.setLoginPwd(new BCryptPasswordEncoder().encode(baseAccount.getLoginPwd()));
            baseAccountMapper.updateByPrimaryKey(baseAccount);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void updateCurrentAccountRole(Long accountId, Long[] roleIds) {
        if (accountId != null && roleIds != null && roleIds.length > 0) {
            List list = new ArrayList();
            for (Long roleId : roleIds) {
                BaseAccount2role baseAccount2role = new BaseAccount2role();
                baseAccount2role.setAccountId(accountId);
                baseAccount2role.setRoleId(roleId);
                list.add(baseAccount2role);
            }
            baseAccount2roleMapper.deleteByAccountId(accountId);
            baseAccount2roleMapper.batchInsert(list);
        }
    }
}
