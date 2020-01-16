package com.platform.main.dao;

import com.platform.main.bean.po.BaseAccount2role;

import java.util.List;

public interface BaseAccount2roleMapper {
    List<BaseAccount2role> selectByBean(BaseAccount2role baseAccount2role);

    int insert(BaseAccount2role baseAccount2role);

    int batchInsert(List list);

    int deleteByAccountId(Long accountId);
}