package com.platform.main.controller;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.po.BaseMenu;
import com.platform.main.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/menu")
public class MenuController extends BaseController<BaseMenu> {

    @Resource
    private MenuService menuService;

    @RequestMapping(path = "/selectMenuInfo", method = RequestMethod.GET)
    public AjaxResponseBody selectMenuInfo() {
        return menuService.selectMenuInfo(ajaxResponseBody);
    }
}
