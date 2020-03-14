<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>


<%--JSP表达式
    作用: 用来将程序的输出, 输出到客户端
<%= 变量或者表达式%>
--%>
<%= new Date()%>
  <hr>
<%--    jsp脚本片断--%>
  <%
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
  %>

  <%
    for (int i = 0; i < 5; i ++) {
  %>
  <h1>hellow <%=i%></h1>
  <%
    }
  %>

  <hr>
  <%!
    static {
      System.out.println("loading servlet!");
    }
    private int globalVar = 0;
    public void kuang() {
      System.out.println("进入了方法");
    }
  %>
  </body>
</html>
