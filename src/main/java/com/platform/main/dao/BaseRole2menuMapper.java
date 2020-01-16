package com.platform.main.dao;

import com.platform.main.bean.po.BaseRole2menu;

import java.util.List;

public interface BaseRole2menuMapper {
    List<BaseRole2menu> selectByBean(BaseRole2menu baseRole2menu);

    int insert(BaseRole2menu baseRole2menu);

    int batchInsert(List list);

    int deleteByRoleId(Long roleId);
}