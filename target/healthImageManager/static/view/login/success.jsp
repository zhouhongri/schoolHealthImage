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
    <title>管理系统</title>
    <script src="<%=path %>/static/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div>
    欢迎 <span id="loginName"></span> 登录！！！
</div>
</body>
<script type="text/javascript">
    $(function () {
        $("#loginName").text(localStorage.getItem("loginName"));
    });
</script>
</html>