package com.platform.code.util;

/**
 * 返回错误编码
 *
 * @author zhouhr3
 * @date 2019-12-06
 **/
public enum ErrorCode {
    SUCCESS("操作成功", "0"),
    INSUFFICIENT_PERMISSIONS_EXCEPTION("（禁止）权限不足，服务器拒绝请求", "403"),
    UNAUTHORIZED_EXCEPTION("（未授权） 请求要求身份验证", "401"),
    USER_LOGIN_USERNAME_PASSWORD_ERROR("账户名或密码错误", "410"),
    USER_LOGIN_ACCOUNT_NOT_ACTIVATED("账号未启用！请联系管理员", "411"),
    USER_LOGIN_ACCOUNT_LOCKED("账号已锁定！请联系管理员解锁", "412"),
    USER_LOGIN_FAIL("登录失败", "400"),
    USER_LOGIN_SUCCESS("登录成功", "200"),
    USER_LOGOUT_SUCCESS("登出成功", "100"),

    SYSTEM_ERROR("系统错误", "1000"),
    NETWORK_ERROR("网络连接错误", "1001"),
    DATABASE_ERROR("数据库错误", "1002"),
    PARAM_NUM_ERROR("参数数量错误", "1003"),
    PARAM_TYPE_ERROR("参数类型错误", "1004"),
    PARAM_NULL_ERROR("参数为空", "1005"),
    USER_LOGIN_NULL_ERROR("登录人信息获取失败", "1006"),
    USER_NAME_EXCEPTION("账号异常", "1007"),
    LOGIN_OVER_TIME_EXCEPTION("登录超时，请重新登录", "1008"),
    LOGIN_REFRESH_TOKEN_EXCEPTION("请刷新token", "1009"),

    LOGIN_TOKEN_IS_NULL("token为空(token is empty)", "1010"),
    LOGIN_NOT_LOGGER_IN("未登录(Not Logged In)", "1011");


    private String name;
    private String statusCode;

    ErrorCode(String name, String statusCode) {
        this.statusCode = statusCode;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
