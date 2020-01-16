package com.platform.main.common;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Component
@RequestMapping("common")
public class CommonDispatch {

    @RequestMapping("{path}/{view}")
    public String dispatch(@PathVariable String path, @PathVariable String view, HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getSession().getAttribute("user") == null) {
            return "login/login";
        }
        return path + "/" + view;
    }

}
