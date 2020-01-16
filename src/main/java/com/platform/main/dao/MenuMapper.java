package com.platform.main.dao;

import com.platform.main.bean.po.BaseMenu;

import java.util.List;

public interface MenuMapper {

    List<BaseMenu> selectMenuListByRoleSign(String roleSign);

    List<BaseMenu> selectMenuChildListByRoleSign(String roleSign);

    BaseMenu selectByPrimaryKey(Long menuId);

    List<BaseMenu> selectByBean(BaseMenu baseMenu);

    int batchDeleteByPrimaryKey(List menuIds);

    int deleteByPrimaryKey(Long menuId);

    int insert(BaseMenu baseMenu);

    int updateByPrimaryKey(BaseMenu baseMenu);

    List<Long> selectParentIdByPrimaryKeys(List menuIds);
}
