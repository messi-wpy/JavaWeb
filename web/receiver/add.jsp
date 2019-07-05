<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-6
  Time: 上午1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<h1>${msg}</h1>
<h1>Receiver add</h1>
<form action="../receiverServlet?action=add" method="post">
    <table>
        <tr>
            <td>Name</td><td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Province</td><td><input type="text" name="province"/></td>
        </tr>
        <tr>
            <td>City</td><td><input type="text" name="city"/></td>
        </tr>
        <tr>
            <td>Country</td><td><input type="text" name="country"/></td>
        </tr>
        <tr>
            <td>Address</td><td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>Phone</td><td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>Postcode</td><td><input type="text" name="postcode"/></td>
        </tr>
        <tr>
            <td>Street</td><td><input type="text" name="street"/></td>
        </tr>
        <tr>
            <td>UserID</td><td><input type="text" name="userId"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" /><input type="reset" /></td>
        </tr>
    </table>



</form>
</body>
</html>
