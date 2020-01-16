package com.platform.main.dao;

import com.platform.main.bean.po.BaseRole2api;

import java.util.List;

public interface BaseRole2apiMapper {
    List<BaseRole2api> selectByBean(BaseRole2api baseRole2api);

    int insert(BaseRole2api baseRole2api);
}