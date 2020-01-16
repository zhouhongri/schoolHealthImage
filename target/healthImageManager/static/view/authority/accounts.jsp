<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <div class="panel-head">
        <strong class="icon-reorder">账户信息</strong>
    </div>

    <table class="table table-hover text-center">
        <tr>
            <th>账号ID</th>
            <th>登录名</th>
            <th>登录密码</th>
            <th>手机号</th>
            <th>Email</th>
            <th>注册时间</th>
            <th>状态</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${list}" var="c">
            <tr id="tr${c.accountId}">
                <td>${c.accountId}</td>
                <td>${c.loginName}</td>
                <td>${c.loginPwd}</td>
                <td>${c.phone}</td>
                <td>${c.email}</td>
                <td>
                    <fmt:formatDate value="${c.registerTime}" type="date" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
                </td>
                <c:if test="${c.state=='0'}">
                    <td style="color: red;">失效</td>
                </c:if>
                <c:if test="${c.state=='1'}">
                    <td style="color: green;">正常</td>
                </c:if>
                <td>
                    <div class="button-group">
                        <a class="button border-main"
                           onclick="del('${c.accountId}');"><span
                                class="icon-edit"></span>删除</a>
                    </div>
                </td>
                <td>
                    <a class="button border-main"
                       href="<%=path %>/admin/base/baseAccount/selectByPrimaryKey?accountId=${c.accountId}">
                        <span class="icon-edit"></span>修改</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="10">
                <div class="pagelist">
                    <c:if test="${pageNum > 1}">
                        <a href="<%=path %>/admin/base/baseAccount/selectByPage?state=1&pageNum=${pageNum-1}">上一页</a>
                    </c:if>
                    <c:if test="${pageNum < totalPage}">|当前${pageNum}页/总${totalPage}页|
                        <a href="<%=path %>/admin/base/baseAccount/selectByPage?state=1&pageNum=${pageNum+1}">下一页</a>
                    </c:if>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
<script>
    function del(accountId) {
        $.get("<%=path %>/admin/base/baseAccount/deleteByPrimaryKey?accountId=" + accountId,
            function (result) {
                if (result != null) {
                    layer.msg(result.msg);
                    if (result.status == "0") {
                        $("#tr" + accountId).css("display", "none");
                    }
                }
            });
    }
</script>
</html>