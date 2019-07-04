<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-4
  Time: 上午4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="u">
    ${u.id }--${u.productId }--${u.userId}--${u.number}<br>
</c:forEach>
</body>
</html>
