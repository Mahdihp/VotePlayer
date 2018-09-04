<%@ page import="com.mahdi.service.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 8/12/18
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="resource/Style.css">
</head>
<body>
<%


%>
<div >
    <form method="post" action="/LoginServlet">
        <table id="LoginForm">
            <tr>
                <td><label for="username"> UserName: </label></td>
                <td><input id="username" type="text" name="username"></td>
            </tr>
            <tr>
                <td><label for="password"> Password: </label></td>
                <td><input id="password" type="password" name="password"></td>
            </tr>
            <tr >
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>

    </form>

</div>
</body>
</html>
