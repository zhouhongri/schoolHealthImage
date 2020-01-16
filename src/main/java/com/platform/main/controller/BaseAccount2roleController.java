package com.platform.main.controller;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.po.BaseAccount2role;
import com.platform.main.service.BaseAccount2roleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/base/baseAccount2role")
public class BaseAccount2roleController extends BaseController<BaseAccount2role> {

    @Resource
    private BaseAccount2roleService baseAccount2roleService;

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public AjaxResponseBody insert() {
        baseAccount2roleService.insert(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/selectByPage", method = RequestMethod.GET)
    public AjaxResponseBody selectByPage() {
        return baseAccount2roleService.selectByBean(ajaxResponseBody, pageInfo);
    }
}
