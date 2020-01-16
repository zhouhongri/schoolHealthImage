package com.platform.main.service;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseAccount;

public interface BaseAccountService {

    AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseAccount> pageInfo);

    AjaxResponseBody selectByPrimaryKey(AjaxResponseBody ajaxResponseBody, Long accountId);

    void deleteByPrimaryKey(Long accountId);

    void batchDeleteByPrimaryKey(Long[] accountIds);

    void insert(BaseAccount baseAccount);

    void updateByPrimaryKey(BaseAccount baseAccount);

    void updateCurrentAccountRole(Long accountId, Long[] roleIds);
}
