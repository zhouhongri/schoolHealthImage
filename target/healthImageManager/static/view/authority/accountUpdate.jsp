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
    <script src="<%=path %>/static/js/jquery.js"></script>
    <script src="<%=path %>/static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>申请用车</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=path %>/admin/base/baseAccount/updateByPrimaryKey">
            <input name="accountId" value="${account.accountId}" style="display: none;"/>
            <div class="form-group">
                <div class="label">
                    <label>登录名：</label>
                </div>
                <div class="field">
                    <input type="text" name="loginName" class="input" readonly="readonly" value="${account.loginName}"
                           style="width:25%; float:left"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>登录密码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="loginPwd" value="${account.loginPwd}"
                           style="width:25%; float:left"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>手机号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="phone" value="${account.phone}"
                           style="width:25%; float:left"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>Email：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="email" value="${account.email}"
                           style="width:25%; float:left"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>状态：</label>
                </div>
                <div class="field">
                    <select name="state" id="state" class="input w50">
                        <c:choose>
                            <c:when test="${account.state == 1}">
                                <option value='1' selected>正常</option>
                                <option value='0'>失效</option>
                            </c:when>
                            <c:otherwise>
                                <option value='1'>正常</option>
                                <option value='0' selected>失效</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>