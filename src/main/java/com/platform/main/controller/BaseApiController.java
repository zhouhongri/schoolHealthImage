package com.platform.main.controller;

import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.po.BaseApi;
import com.platform.main.service.ApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/base/baseApi")
public class BaseApiController extends BaseController<BaseApi> {

    @Resource
    private ApiService baseApiService;

    @RequestMapping(path = "/selectByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody selectByPrimaryKey(Long apiId) {
        return baseApiService.selectByPrimaryKey(ajaxResponseBody, apiId);
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public AjaxResponseBody insert() {
        baseApiService.insert(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/deleteByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody deleteByPrimaryKey(Long apiId) {
        baseApiService.deleteByPrimaryKey(apiId);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/batchDeleteByPrimaryKey", method = RequestMethod.GET)
    public AjaxResponseBody batchDeleteByPrimaryKey(Long[] apiIds) {
        baseApiService.batchDeleteByPrimaryKey(apiIds);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/updateByPrimaryKey", method = RequestMethod.POST)
    public AjaxResponseBody updateByPrimaryKey() {
        baseApiService.updateByPrimaryKey(obj);
        return ajaxResponseBody;
    }

    @RequestMapping(path = "/selectByPage", method = RequestMethod.GET)
    public AjaxResponseBody selectByPage() {
        return baseApiService.selectByBean(ajaxResponseBody, pageInfo);
    }
}
