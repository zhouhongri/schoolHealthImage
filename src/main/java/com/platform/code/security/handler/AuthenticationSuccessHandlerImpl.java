package com.platform.code.security.handler;

import com.alibaba.fastjson.JSON;
import com.platform.code.security.bean.SelfUserDetails;
import com.platform.code.util.Constant;
import com.platform.code.util.ErrorCode;
import com.platform.main.bean.AjaxResponseBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功
 */
@Component("authenticationSuccessHandlerImpl")
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setStatus(ErrorCode.USER_LOGIN_SUCCESS.getStatusCode());
        responseBody.setMsg(ErrorCode.USER_LOGIN_SUCCESS.getName());

        SelfUserDetails userDetails = (SelfUserDetails) authentication.getPrincipal();

        // 存储session
        httpServletRequest.getSession().setAttribute("user", userDetails.getUsername());

        // 登录名
        responseBody.setResult(userDetails.getUsername());

        httpServletResponse.setHeader(Constant.HEADER_CONTENT_TYPE, Constant.HEADER_CHARSET);
        httpServletResponse.setCharacterEncoding(Constant.RESPONSE_BODY_UNICODE);
        httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
    }
}
