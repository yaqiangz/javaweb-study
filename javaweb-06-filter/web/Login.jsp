<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2020/3/13
  Time: 下午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
<form action="<%=request.getContextPath()%>/servlet/login" method="post">
    <input type="text" name="username">
    <input type="submit">
</form>
</body>
</html>
