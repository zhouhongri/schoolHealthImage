package com.platform.main.service;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseRole2menu;

public interface BaseRole2menuService {

    AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseRole2menu> pageInfo);

    void insert(BaseRole2menu baseRole2menu);
}
