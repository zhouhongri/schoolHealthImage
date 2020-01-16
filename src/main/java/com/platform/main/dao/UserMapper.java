package com.platform.main.dao;

import com.platform.main.bean.po.BaseUser;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

}