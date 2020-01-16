package com.platform.main.service.impl;

import com.platform.main.service.UserService;

import javax.annotation.Resource;

public class BaseService {

    @Resource
    protected UserService userService;
}
