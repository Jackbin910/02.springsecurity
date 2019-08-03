<%--
  Created by IntelliJ IDEA.
  User: asu
  Date: 2019/7/14
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录页面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"/>
</head>
<body>
<h3>登录页面</h3>
<c:if test="${not empty param.error}">
    <font color="red">用户名或密码错误</font>
</c:if>
<form id="loginForm" method="post">
    用户名:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"/><br/>
    验证码:<input type="text" name="imageCode"/><img src="${pageContext.request.contextPath}/imageCode"/><br/>
    <input type="button" id="loginBtn" value="登录"/>

</form>
<script type="text/javascript">
    $(function () {
        $("#loginBtn").click(function () {
            $.post("${pageContext.request.contextPath}/login", $("#loginForm").serialize(), function (data) {
                if (data.success) {
                    window.location.href = "${pageContext.request.contextPath}/product/index"
                } else {
                    alert("登录失败:" + data.errorMsg);
                }
            }, "json");
        });
    });
</script>
</body>
</html>
