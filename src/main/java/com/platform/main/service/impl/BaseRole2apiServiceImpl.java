package com.platform.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseRole2api;
import com.platform.main.dao.BaseRole2apiMapper;
import com.platform.main.dao.RoleMapper;
import com.platform.main.service.BaseRole2apiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BaseRole2apiServiceImpl extends BaseService implements BaseRole2apiService {

    @Resource
    private BaseRole2apiMapper baseRole2apiMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseRole2api> pageInfo) {
        if (pageInfo != null) {
            Page<BaseRole2api> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            baseRole2apiMapper.selectByBean(pageInfo.getObj());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setResult(page.getResult());
            ajaxResponseBody.setResult(pageInfo);
        }
        return ajaxResponseBody;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void insert(BaseRole2api baseRole2api) {
        if (baseRole2api != null) {
            baseRole2apiMapper.insert(baseRole2api);
        }
    }
}
