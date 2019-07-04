<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-4
  Time: 上午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="shoppingCart" method="post">

        <table align="center">
            <tr>
                <td>ID</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>ProductID</td>
                <td><input type="text" name="productId"></td>
            </tr>
            <tr>
                <td>UserID</td>
                <td><input type="text" name="userId"></td>
            </tr>
            <tr>
                <td>Number</td>
                <td><input type="text" name="number"></td>
            </tr>
            <tr >
                <td colspan="2"  align="center"> <input type="submit"> </td>
            </tr>
        </table>
    </form>
</body>
</html>
