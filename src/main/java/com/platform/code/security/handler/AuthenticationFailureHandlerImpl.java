package com.platform.code.security.handler;

import com.alibaba.fastjson.JSON;
import com.platform.code.util.Constant;
import com.platform.code.util.ErrorCode;
import com.platform.main.bean.AjaxResponseBody;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败
 */
@Component("authenticationFailureHandlerImpl")
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        if (e instanceof BadCredentialsException) {
            responseBody.setMsg(ErrorCode.USER_LOGIN_USERNAME_PASSWORD_ERROR.getName());
            responseBody.setStatus(ErrorCode.USER_LOGIN_USERNAME_PASSWORD_ERROR.getStatusCode());
        } else if (e instanceof DisabledException) {
            responseBody.setMsg(ErrorCode.USER_LOGIN_ACCOUNT_NOT_ACTIVATED.getName());
            responseBody.setStatus(ErrorCode.USER_LOGIN_ACCOUNT_NOT_ACTIVATED.getStatusCode());
        } else if (e instanceof LockedException) {
            responseBody.setMsg(ErrorCode.USER_LOGIN_ACCOUNT_LOCKED.getName());
            responseBody.setStatus(ErrorCode.USER_LOGIN_ACCOUNT_LOCKED.getStatusCode());
        } else {
            responseBody.setMsg(ErrorCode.USER_LOGIN_FAIL.getName());
            responseBody.setStatus(ErrorCode.USER_LOGIN_FAIL.getStatusCode());
        }

        httpServletResponse.setHeader(Constant.HEADER_CONTENT_TYPE, Constant.HEADER_CHARSET);
        httpServletResponse.setCharacterEncoding(Constant.RESPONSE_BODY_UNICODE);
        httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
    }
}
