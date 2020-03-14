<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2020/3/13
  Time: 下午5:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.forward("/index.jsp");
    // request.getRequestDispatcher("/index.jsp").forward(request, response);
%>
</body>
</html>
