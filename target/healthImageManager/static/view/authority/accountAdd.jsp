<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理系统</title>
    <link rel="stylesheet" href="<%=path %>/static/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/static/css/admin.css">
    <link rel="stylesheet" href="<%=path %>/static/resource/layui/css/layui.css">
    <script src="<%=path %>/static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=path %>/static/js/pintuer.js"></script>
    <script src="<%=path %>/static/resource/layui/layui.all.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>添加账户</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=path %>/admin/base/baseAccount/insert">
            <div class="form-group">
                <div class="label">
                    <label>登录名：</label>
                </div>
                <div class="field">
                    <input type="text" id="loginName" class="input" name="loginName" value="" style="width:25%; float:left"
                           placeholder="请输入用户名" data-validate="required:请输入用户名"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>登录密码：</label>
                </div>
                <div class="field">
                    <input type="text" id="loginPwd" class="input" name="loginPwd" value="" style="width:25%; float:left"
                           placeholder="请输入登录密码" data-validate="required:请输入登录密码"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>手机号：</label>
                </div>
                <div class="field">
                    <input type="text" id="phone" class="input" name="phone" value="" style="width:25%; float:left"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>Email：</label>
                </div>
                <div class="field">
                    <input type="text" id="email" class="input" name="email" value="" style="width:25%; float:left"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>状态：</label>
                </div>
                <div class="field">
                    <select name="state" id="state" class="input w50">
                        <option value='1' selected="selected">正常</option>
                        <option value='0'>失效</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <input id="submit" type="submit" style="display: none;">
        </form>
        <div>
            <div>
                <button style="margin-left: 115px;" class="button bg-main icon-check-square-o" onclick="post();"> 提交
                </button>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function post() {
        if ($("#loginName").val() == null || $("#loginName").val().length <= 0) {
            layer.msg("请输入登录名");
        } else if ($("#loginPwd").val() == null || $("#loginPwd").val().length <= 0) {
            layer.msg("请输入登录名密码");
        } else {
            $("#submit").click();
        }
    }
</script>
</html>