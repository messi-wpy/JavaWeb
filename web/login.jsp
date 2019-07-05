<%--
  Created by IntelliJ IDEA.
  User: messi-lp
  Date: 19-7-1
  Time: 下午10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<div style="border: blue 1px solid ;width :600px">
    <form action="login" method="post" >
        <h1 align="center">实训登录界面</h1>

        <table align="center" >

            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"/><td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"/><td>
            </tr>

            <tr >
                <td colspan="2"  align="center"> <input type="submit"> </td>
            </tr>

        </table>
    </form>
</div>

<script type="text/javascript">

    //取出传回来比较
    var errori ='<%=request.getParameter("error")%>';
    if(errori==="1"){
        alert("密码错误!");
    }else if (errori==="2"){
        alert("用户名不存在");
    }

</script>
</body>
</html>
