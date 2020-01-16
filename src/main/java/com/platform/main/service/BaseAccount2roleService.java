package com.platform.main.service;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseAccount2role;

public interface BaseAccount2roleService {

    AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseAccount2role> pageInfo);

    void insert(BaseAccount2role baseAccount2role);

}
