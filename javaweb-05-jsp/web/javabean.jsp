<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2020/3/13
  Time: 下午7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
%>
<jsp:useBean id="people" class="com.zyq.pojo.People" scope="page"></jsp:useBean>
<jsp:setProperty name="people" property="address" value="北京"></jsp:setProperty>
<jsp:setProperty name="people" property="id" value="1"></jsp:setProperty>
<jsp:setProperty name="people" property="name" value="小明"></jsp:setProperty>
<jsp:setProperty name="people" property="age" value="5"></jsp:setProperty>

姓名: <jsp:getProperty name="people" property="name"/>
id: <jsp:getProperty name="people" property="id"/>
年龄: <jsp:getProperty name="people" property="age"/>
地址: <jsp:getProperty name="people" property="address"/>
</body>
</html>
