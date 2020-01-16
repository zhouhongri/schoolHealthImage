package com.platform.main.dao;

import com.platform.main.bean.bo.User;
import com.platform.main.bean.po.BaseAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Long accountId);

    int insert(BaseAccount baseAccount);

    BaseAccount selectByPrimaryKey(Long accountId);

    int updateByPrimaryKey(BaseAccount baseAccount);

    User loadUserByUsername(@Param("userName") String userName);

    List<BaseAccount> selectByBean(BaseAccount baseAccount);

    int batchDeleteByPrimaryKey(List accountIds);

    List<BaseAccount> selectByRoleId(Long roleId);
}