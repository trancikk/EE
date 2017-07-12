
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Trancikk
  Date: 12.07.2017
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>lol</h1>
<%
    application.setAttribute("appAttr", new java.lang.String("just example"));
    session.setAttribute("sesAttr", new java.lang.String("session example"));
    request.setAttribute("reqAttr", new java.lang.String("req example"));
    Enumeration initParamNames = config.getInitParameterNames();
    out.print("params:");
    out.print("</br>");
    while (initParamNames.hasMoreElements()){
        java.lang.String paramName = (java.lang.String) initParamNames.nextElement();
        out.print(paramName + "=");
        out.print(config.getInitParameter((java.lang.String) paramName));
        out.print("</br>");
    }
    out.print("type of object:");
    out.println(page.getClass().getName());
    out.println("buffer size:");
    out.println(response.getBufferSize());

%>
<a href="obj2.jsp">click here</a> click here
</body>
</html>
