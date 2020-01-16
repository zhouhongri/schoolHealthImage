package com.platform.main.controller;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.po.BaseRole2menu;
import com.platform.main.service.BaseRole2menuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/base/baseRole2menu")
public class BaseRole2menuController extends BaseController<BaseRole2menu> {

    @Resource
    private BaseRole2menuService baseRole2menuService;

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public AjaxResponseBody insert() {
        baseRole2menuService.insert(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/selectByPage", method = RequestMethod.GET)
    public AjaxResponseBody selectByPage() {
        return baseRole2menuService.selectByBean(ajaxResponseBody, pageInfo);
    }
}
