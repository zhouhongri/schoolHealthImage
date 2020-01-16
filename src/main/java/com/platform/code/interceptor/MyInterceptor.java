package com.platform.code.interceptor;


import com.platform.code.util.Constant;
import com.platform.code.util.ErrorCode;
import com.platform.code.util.ResponseResultUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Component
public class MyInterceptor implements HandlerInterceptor {

    private List<String> allowUri;

    public List<String> getAllowUri() {
        return allowUri;
    }

    public void setAllowUri(List<String> allowUri) {
        this.allowUri = allowUri;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }


    /**
     * 拦截器最终调用的方法
     *
     * @param request
     * @param response
     * @param obj
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {
        String requestURI = request.getRequestURI();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        if (Constant.PROJECT_CONTEXT_PATH.equals(requestURI)) {
            return true;
        }
        for (String allowPattern : allowUri) {
            if (antPathMatcher.match(Constant.PROJECT_CONTEXT_PATH + allowPattern, requestURI)) {
                return true;
            }
        }
        if (request.getSession().getAttribute("user") == null) {
            ResponseResultUtil.result(ErrorCode.LOGIN_NOT_LOGGER_IN.getName(), ErrorCode.LOGIN_NOT_LOGGER_IN.getStatusCode(), Constant.LOGIN_PAGE_URL);
            return false;
        }
        return true;
    }
}