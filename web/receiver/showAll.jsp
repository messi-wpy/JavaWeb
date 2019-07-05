<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-6
  Time: 上午1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>showAll</title>
</head>
<body>
<h1>Receiver showAll</h1>
<h1><a href="/receiver/add.jsp">添加货运信息</a></h1>
<table border="1px solid">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Province</td>
        <td>City</td>
        <td>Country</td>
        <td>Address</td>
        <td>Phone</td>
        <td>Postcode</td>
        <td>Street</td>
        <td>UserID</td>
    </tr>

    <c:forEach items="${list}" var="receiver">
        <tr>
            <td>${receiver.id}</td>
            <td>${receiver.name }</td>
            <td>${receiver.province}</td>
            <td>${receiver.city}</td>
            <td>${receiver.country}</td>
            <td>${receiver.address}</td>
            <td>${receiver.phone}</td>
            <td>${receiver.postcode}</td>
            <td>${receiver.street}</td>
            <td>${receiver.userId}</td>
            <td><a href="receiverServlet?id=${receiver.id }&action=delete">删除</a></td>
            <td><a href="receiverServlet?id=${receiver.id}&action=showOne">修改</a></td>
        </tr>


    </c:forEach>
</table>
</body>
</html>
