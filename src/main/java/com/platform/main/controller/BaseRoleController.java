package com.platform.main.controller;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.po.BaseRole;
import com.platform.main.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/base/baseRole")
public class BaseRoleController extends BaseController<BaseRole> {

    @Resource
    private RoleService baseRoleService;

    @RequestMapping(path = "/selectByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody selectByPrimaryKey(Long roleId) {
        return baseRoleService.selectByPrimaryKey(ajaxResponseBody, roleId);
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public AjaxResponseBody insert() {
        baseRoleService.insert(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/deleteByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody deleteByPrimaryKey(Long roleId) {
        baseRoleService.deleteByPrimaryKey(roleId);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/batchDeleteByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody batchDeleteByPrimaryKey(Long[] roleIds) {
        baseRoleService.batchDeleteByPrimaryKey(roleIds);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/updateByPrimaryKey", method = RequestMethod.POST)
    public AjaxResponseBody updateByPrimaryKey() {
        baseRoleService.updateByPrimaryKey(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/selectByPage", method = RequestMethod.GET)
    public AjaxResponseBody selectByPage() {
        return baseRoleService.selectByBean(ajaxResponseBody, pageInfo);
    }

    @RequestMapping(path = "/selectByBean", method = RequestMethod.GET)
    public AjaxResponseBody selectByBean() {
        return baseRoleService.selectByBean(ajaxResponseBody, obj);
    }

    @RequestMapping(path = "/selectByCurrentAccountRoles", method = RequestMethod.GET)
    public AjaxResponseBody selectByCurrentAccountRoles(Long accountId) {
        return baseRoleService.selectByCurrentAccountRoles(ajaxResponseBody, accountId);
    }

    @RequestMapping(path = "/updateCurrentRoleMenu", method = RequestMethod.POST)
    public AjaxResponseBody updateCurrentRoleMenu(String roleSign, Long roleId, Long[] menuIds) {
        baseRoleService.updateCurrentRoleMenu(roleSign, roleId, menuIds);
        return ajaxResponseBody;
    }
}
