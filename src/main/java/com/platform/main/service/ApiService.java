package com.platform.main.service;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseApi;

import java.util.List;

public interface ApiService {
    List<BaseApi> selectApiListByRoleSign(String roleSign);

    AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseApi> pageInfo);

    AjaxResponseBody selectByPrimaryKey(AjaxResponseBody ajaxResponseBody, Long apiId);

    void deleteByPrimaryKey(Long apiId);

    void batchDeleteByPrimaryKey(Long[] apiIds);

    void insert(BaseApi baseApi);

    void updateByPrimaryKey(BaseApi baseApi);
}
