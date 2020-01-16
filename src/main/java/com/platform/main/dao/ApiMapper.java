package com.platform.main.dao;

import com.platform.main.bean.po.BaseApi;

import java.util.List;

public interface ApiMapper {
    List<BaseApi> selectApiListByRoleSign(String roleSign);

    List<BaseApi> selectByBean(BaseApi baseApi);

    BaseApi selectByPrimaryKey(Long baseApi);

    int batchDeleteByPrimaryKey(List apiIds);

    int deleteByPrimaryKey(Long apiId);

    int insert(BaseApi baseApi);

    int updateByPrimaryKey(BaseApi baseApi);
}
