package com.platform.code.util;

import com.alibaba.fastjson.JSON;
import com.platform.main.bean.AjaxResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * response返回工具类
 */
public class ResponseResultUtil {
    public static void createResult(AjaxResponseBody responseBody) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setHeader(Constant.HEADER_CONTENT_TYPE, Constant.HEADER_CHARSET);
        response.setCharacterEncoding(Constant.RESPONSE_BODY_UNICODE);
        try {
            response.getWriter().write(JSON.toJSONString(responseBody));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createResult(String pageUrl) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        response.setHeader(Constant.HEADER_CONTENT_TYPE, Constant.HEADER_CHARSET);
        response.setCharacterEncoding(Constant.RESPONSE_BODY_UNICODE);
        try {
            response.sendRedirect(request.getContextPath() + pageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void result(String msg, String status) {
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        ajaxResponseBody.setStatus(status);
        ajaxResponseBody.setMsg(msg);
        createResult(ajaxResponseBody);
    }

    public static void result(String msg, String status, String pageUrl) {
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        ajaxResponseBody.setStatus(status);
        ajaxResponseBody.setMsg(msg);
        createResult(pageUrl);
    }
}
