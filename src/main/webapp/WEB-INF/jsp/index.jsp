<%--
  Created by IntelliJ IDEA.
  User: asu
  Date: 2019/7/13
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
网站功能:<br/>
<a href="${pageContext.request.contextPath}/product/add">商品添加</a><br/>
<a href="${pageContext.request.contextPath}/product/update">商品修改</a><br/>
<a href="${pageContext.request.contextPath}/product/list">商品查询</a><br/>
<a href="${pageContext.request.contextPath}/product/delete">商品删除</a><br/>

</body>
</html>
