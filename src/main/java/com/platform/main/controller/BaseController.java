package com.platform.main.controller;

import com.platform.code.util.ErrorCode;
import com.platform.main.bean.AjaxResponseBody;
import com.platform.main.bean.bo.PageInfo;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController<T> {
    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    protected T obj;

    protected PageInfo<T> pageInfo;

    protected AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();

    @ModelAttribute
    public void init(HttpServletResponse response, HttpServletRequest request, PageInfo<T> pageInfo, T obj) {
        this.request = request;
        this.ajaxResponseBody = new AjaxResponseBody(ErrorCode.SUCCESS.getStatusCode(), ErrorCode.SUCCESS.getName());
        this.response = response;
        this.session = request.getSession();
        this.obj = obj;
        pageInfo.setObj(obj);
        this.pageInfo = pageInfo;
    }
}
