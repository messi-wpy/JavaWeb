<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-4
  Time: 上午2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="receiver">
    ${receiver.id } --- ${receiver.name } --- ${receiver.province} --- ${receiver.city} --- ${receiver.country} --- ${receiver.address} --- ${receiver.phone} --- ${receiver.postcode} --- ${receiver.street} --- ${receiver.userId}<br/>
</c:forEach>
</body>
</html>
