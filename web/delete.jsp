<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-4
  Time: 上午11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<table border="1px solide" >
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td colspan="2" >操作</td>

    </tr>
    <c:forEach items="${list}" var="u">

        <tr>
            <td>${u.id }</td>
            <td>${u.name }</td>
            <!-- a表签是超链接标签 默认使用get方式提交 -->
            <td><a href="deleteReceiver?id=${u.id }">删除</a></td>
            <td><a href="deleteReceiver?id=${u.id}&&update=true">修改</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
