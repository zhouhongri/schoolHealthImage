package com.platform.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseRole2menu;
import com.platform.main.dao.BaseRole2menuMapper;
import com.platform.main.service.BaseRole2menuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BaseRole2menuServiceImpl implements BaseRole2menuService {

    @Resource
    private BaseRole2menuMapper baseRole2menuMapper;

    @Override
    public AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseRole2menu> pageInfo) {
        if (pageInfo != null) {
            Page<BaseRole2menu> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            baseRole2menuMapper.selectByBean(pageInfo.getObj());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setResult(page.getResult());
            ajaxResponseBody.setResult(pageInfo);
        }
        return ajaxResponseBody;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void insert(BaseRole2menu baseRole2menu) {
        if (baseRole2menu != null) {
            baseRole2menuMapper.insert(baseRole2menu);
        }
    }
}
