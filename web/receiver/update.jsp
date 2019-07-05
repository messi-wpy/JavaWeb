<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-6
  Time: 上午1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${msg}</h1>
<h1>Receiver update</h1>
<form action="../receiverServlet?action=update&id=${info.id}" method="post">
    <table>
        <tr>
            <td>Name</td><td><input type="text" name="name" value="${info.name}"/></td>
            <td>Province</td><td><input type="text" name="province"value="${info.province}"/></td>
            <td>City</td><td><input type="text" name="city" value="${info.province}"/></td>
            <td>Country</td><td><input type="text" name="country" value="${info.country}"/></td>
            <td>Address</td><td><input type="text" name="address"value="${info.address}"/></td>
            <td>Phone</td><td><input type="text" name="phone"value="${info.phone}"/></td>
            <td>Postcode</td><td><input type="text" name="postcode"value="${info.postcode}"/></td>
            <td>Street</td><td><input type="text" name="street"value="${info.street}"/></td>
            <td>UserID</td><td><input type="text" name="userId"value="${info.userId}"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" /><input type="reset" /></td>
        </tr>
    </table>



</form>
</body>
</html>
