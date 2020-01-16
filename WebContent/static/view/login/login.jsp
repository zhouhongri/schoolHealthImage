<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="<%=path %>/static/css/pintuer.css">
    <link rel="stylesheet" href="<%=path %>/static/css/admin.css">
    <link rel="stylesheet" href="<%=path %>/static/resource/layui/css/layui.css">
    <script src="<%=path %>/static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=path %>/static/js/pintuer.js"></script>
    <script src="<%=path %>/static/resource/layui/layui.all.js"></script>
</head>
<body style="background-image: url(<%=path %>/images/blue.jpg)">
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height: 150px;"></div>
            <div class="media media-y margin-big-bottom"></div>
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top">
                    <h1>管理系统</h1>
                </div>
                <div class="panel-body"
                     style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" id="username"
                                   placeholder="登录账号" data-validate="required:请填写账号"/> <span
                                class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" id="password"
                                   placeholder="登录密码" data-validate="required:请填写密码"/> <span
                                class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field"></div>
                    </div>
                </div>
                <div style="padding: 30px;">
                    <input type="submit"
                           class="button button-block bg-main text-big input-big"
                           value="登录" onclick="toLogin();">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function toLogin() {
        var username = $("#username").val();
        var password = $("#password").val();

        if(username == null || username.length <= 0){
            return;
        }

        if(password == null || password.length <= 0){
            return;
        }

        $.post("<%=path %>/login", {
            "username": username,
            "password": password
        }, function (result) {
            try {
                if (result != null) {
                    var jsonObj = JSON.parse(result);
                    console.info(jsonObj);
                    if (jsonObj.status == "200") {
                        localStorage.setItem("loginName", jsonObj.result);
                        layer.msg(jsonObj.msg, {icon: 6});
                        window.location.href = "<%=path %>/common/authority/index";
                    }else{
                        layer.msg(jsonObj.msg, {icon: 5});
                    }
                }
            } catch (e) {
                layer.msg('操作失败', {icon: 5});
            }
        });
    }

    function keyLogin(e) {
        var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code == 13) {
            toLogin();
        }
    }

</script>
</html>