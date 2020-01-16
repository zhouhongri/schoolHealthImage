package com.platform.main.service;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseRole;

import java.util.List;

public interface RoleService {
    List<BaseRole> selectByAccountId(Long accountId);

    AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseRole> pageInfo);

    AjaxResponseBody selectByPrimaryKey(AjaxResponseBody ajaxResponseBody, Long roleId);

    void deleteByPrimaryKey(Long roleId);

    void batchDeleteByPrimaryKey(Long[] roleIds);

    void insert(BaseRole baseRole);

    void updateByPrimaryKey(BaseRole baseRole);

    AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, BaseRole baseRole);

    AjaxResponseBody selectByCurrentAccountRoles(AjaxResponseBody ajaxResponseBody, Long accountId);

    void updateCurrentRoleMenu(String roleSign, Long roleId, Long[] menuIds);
}
