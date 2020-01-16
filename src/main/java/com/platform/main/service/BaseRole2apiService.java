package com.platform.main.service;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseRole2api;

public interface BaseRole2apiService {

    AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseRole2api> pageInfo);

    void insert(BaseRole2api baseRole2api);

}
