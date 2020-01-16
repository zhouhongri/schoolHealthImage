package com.platform.main.service;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import com.platform.main.bean.po.BaseMenu;

public interface MenuService {

    AjaxResponseBody selectMenuInfo(AjaxResponseBody ajaxResponseBody);

    /*BaseMenu selectByPrimaryKey(Long menuId);

    List<BaseMenu> selectByBean(BaseMenu baseMenu);*/

    AjaxResponseBody selectByBean(AjaxResponseBody ajaxResponseBody, PageInfo<BaseMenu> pageInfo);

    AjaxResponseBody selectByPrimaryKey(AjaxResponseBody ajaxResponseBody, Long menuId);

    void deleteByPrimaryKey(Long menuId);

    void batchDeleteByPrimaryKey(Long[] menuIds);

    void insert(BaseMenu baseMenu);

    void updateByPrimaryKey(BaseMenu baseMenu);

    AjaxResponseBody selectAllMenuInfo(AjaxResponseBody ajaxResponseBody);

    AjaxResponseBody selectMenuChildListByRoleSign(AjaxResponseBody ajaxResponseBody, String roleSign);
}
