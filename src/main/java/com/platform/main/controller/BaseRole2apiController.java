package com.platform.main.controller;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.po.BaseRole2api;
import com.platform.main.service.BaseRole2apiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/base/baseRole2api")
public class BaseRole2apiController extends BaseController<BaseRole2api> {

    @Resource
    private BaseRole2apiService baseRole2apiService;

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public AjaxResponseBody insert() {
        baseRole2apiService.insert(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/selectByPage", method = RequestMethod.GET)
    public AjaxResponseBody selectByPage() {
        return baseRole2apiService.selectByBean(ajaxResponseBody, pageInfo);
    }
}
