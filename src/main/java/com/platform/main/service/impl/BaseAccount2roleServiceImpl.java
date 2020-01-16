package com.platform.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseAccount2role;
import com.platform.main.dao.BaseAccount2roleMapper;
import com.platform.main.service.BaseAccount2roleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BaseAccount2roleServiceImpl implements BaseAccount2roleService {

    @Resource
    private BaseAccount2roleMapper baseAccount2roleMapper;

    @Override
    public AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseAccount2role> pageInfo) {
        if (pageInfo != null) {
            Page<BaseAccount2role> page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            baseAccount2roleMapper.selectByBean(pageInfo.getObj());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setResult(page.getResult());
            ajaxResponseBody.setResult(pageInfo);
        }
        return ajaxResponseBody;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10, rollbackFor = Throwable.class)
    public void insert(BaseAccount2role baseAccount2role) {
        if (baseAccount2role != null) {
            baseAccount2roleMapper.insert(baseAccount2role);
        }
    }
}
