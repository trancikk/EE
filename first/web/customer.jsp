<%--
  Created by IntelliJ IDEA.
  User: Trancikk
  Date: 12.07.2017
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer"
             class="cool.CustomerBean"
             scope="page">

</jsp:useBean>
<jsp:setProperty name="customer" property="firstName" value="cool"/>
<jsp:setProperty name="customer" property="lastName" value="yep"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:getProperty name="customer" property="firstName"/>
<input type="text" name="firstName" value="<jsp:getProperty name="customer" property="firstName"/>">
<input type="text" name="last" value="<jsp:getProperty name="customer" property="lastName"/>">
</body>
</html>
