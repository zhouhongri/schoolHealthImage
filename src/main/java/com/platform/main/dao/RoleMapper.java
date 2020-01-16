package com.platform.main.dao;

import com.platform.main.bean.po.BaseRole;

import java.util.List;

public interface RoleMapper {
    List<BaseRole> selectByAccountId(Long accountId);

    List<BaseRole> selectByBean(BaseRole baseRole);

    BaseRole selectByPrimaryKey(Long baseRole);

    int batchDeleteByPrimaryKey(List roleIds);

    int deleteByPrimaryKey(Long roleId);

    int insert(BaseRole baseRole);

    int updateByPrimaryKey(BaseRole baseRole);
}