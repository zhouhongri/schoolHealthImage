package com.platform.main.controller;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.po.BaseMenu;
import com.platform.main.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/base/baseMenu")
public class BaseMenuController extends BaseController<BaseMenu> {

    @Resource
    private MenuService baseMenuService;

    @RequestMapping(path = "/selectByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody selectByPrimaryKey(Long menuId) {
        return baseMenuService.selectByPrimaryKey(ajaxResponseBody, menuId);
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public AjaxResponseBody insert() {
        baseMenuService.insert(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/deleteByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody deleteByPrimaryKey(Long menuId) {
        baseMenuService.deleteByPrimaryKey(menuId);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/batchDeleteByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody batchDeleteByPrimaryKey(Long[] menuIds) {
        baseMenuService.batchDeleteByPrimaryKey(menuIds);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/updateByPrimaryKey", method = RequestMethod.POST)
    public AjaxResponseBody updateByPrimaryKey() {
        baseMenuService.updateByPrimaryKey(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/selectByPage", method = RequestMethod.GET)
    public AjaxResponseBody selectByPage() {
        return baseMenuService.selectByBean(ajaxResponseBody, pageInfo);
    }

    @RequestMapping(path = "/selectAllMenuInfo", method = RequestMethod.GET)
    public AjaxResponseBody selectAllMenuInfo() {
        return baseMenuService.selectAllMenuInfo(ajaxResponseBody);
    }

    @RequestMapping(path = "/selectMenuChildListByRoleSign", method = RequestMethod.GET)
    public AjaxResponseBody selectMenuChildListByRoleSign(String roleSign) {
        return baseMenuService.selectMenuChildListByRoleSign(ajaxResponseBody, roleSign);
    }
}
