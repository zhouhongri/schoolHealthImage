package com.platform.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseRole;
import com.platform.main.bean.po.BaseRole2menu;
import com.platform.main.dao.AccountMapper;
import com.platform.main.dao.BaseRole2menuMapper;
import com.platform.main.dao.MenuMapper;
import com.platform.main.dao.RoleMapper;
import com.platform.main.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseService implements RoleService {

    @Resource
    private RoleMapper baseRoleMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private BaseRole2menuMapper baseRole2menuMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<BaseRole> selectByAccountId(Long accountId) {
        return baseRoleMapper.selectByAccountId(accountId);
    }

    @Override
    public AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseRole> pageInfo) {
        if (pageInfo != null) {
            Page<BaseRole> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            baseRoleMapper.selectByBean(pageInfo.getObj());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setResult(page.getResult());
            ajaxResponseBody.setResult(pageInfo);
        }
        return ajaxResponseBody;
    }

    @Override
    public AjaxResponseBody selectByPrimaryKey(AjaxResponseBody ajaxResponseBody, Long roleId) {
        if (roleId != null) {
            BaseRole baseRole = baseRoleMapper.selectByPrimaryKey(roleId);
            ajaxResponseBody.setResult(baseRole);
        }
        return ajaxResponseBody;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void batchDeleteByPrimaryKey(Long[] roleIds) {
        if (roleIds != null && roleIds.length > 0) {
            List list = Arrays.asList(roleIds);
            baseRoleMapper.batchDeleteByPrimaryKey(list);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void deleteByPrimaryKey(Long roleId) {
        if (roleId != null && roleId > 0) {
            baseRoleMapper.deleteByPrimaryKey(roleId);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void insert(BaseRole baseRole) {
        if (baseRole != null) {
            baseRoleMapper.insert(baseRole);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void updateByPrimaryKey(BaseRole baseRole) {
        if (baseRole != null && baseRole.getRoleId() != null) {
            baseRoleMapper.updateByPrimaryKey(baseRole);
        }
    }

    @Override
    public AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, BaseRole baseRole) {
        ajaxResponseBody.setResult(baseRoleMapper.selectByBean(baseRole));
        return ajaxResponseBody;
    }

    @Override
    public AjaxResponseBody selectByCurrentAccountRoles(AjaxResponseBody ajaxResponseBody, Long accountId) {
        ajaxResponseBody.setResult(baseRoleMapper.selectByAccountId(accountId));
        return ajaxResponseBody;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 30, rollbackFor = Throwable.class)
    public void updateCurrentRoleMenu(String roleSign, Long roleId, Long[] menuIds) {
        if (roleId != null && menuIds != null && menuIds.length > 0) {
            List list = new ArrayList();
            for (Long menuId : menuIds) {
                BaseRole2menu baseRole2menu = new BaseRole2menu();
                baseRole2menu.setRoleId(roleId);
                baseRole2menu.setMenuId(menuId);
                list.add(baseRole2menu);
            }

            List<Long> menuIdsAsList = Arrays.asList(menuIds);
            List<Long> parentIdList = menuMapper.selectParentIdByPrimaryKeys(menuIdsAsList);
            for (Long parentMenuId : parentIdList) {
                // 获取父ID
                BaseRole2menu baseRole2menu = new BaseRole2menu();
                baseRole2menu.setRoleId(roleId);
                baseRole2menu.setMenuId(parentMenuId);
                list.add(baseRole2menu);
            }
            baseRole2menuMapper.deleteByRoleId(roleId);
            baseRole2menuMapper.batchInsert(list);
        }
    }
}
