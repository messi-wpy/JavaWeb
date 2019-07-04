<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-4
  Time: 下午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<h1 style="color: red">${msg}</h1>
<form action="UpdateReceiverServlet" method="post">
    <input type="text" name="id" value="${u.id }" readonly="readonly"/><br>
    <input type="text" name="name" value="${u.name }" /><br>
    <input type="submit"/>
</body>
</html>
