<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Trancikk
  Date: 12.07.2017
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>example2</p>
context:
<%
    application.getAttribute("appAttr");
%>
session:
<%
    session.getAttribute("sesAttr");
%>
rq:
<%
    request.getAttribute("reqAttr");
%>
got this ones:
<%
    Enumeration appAttrNames = pageContext.getAttributeNamesInScope(pageContext.APPLICATION_SCOPE);
    while (appAttrNames.hasMoreElements()){
        out.println(appAttrNames.nextElement()+"</br>");
    }
%>
<a href="bug.jsp"> error</a>
</body>
</html>
