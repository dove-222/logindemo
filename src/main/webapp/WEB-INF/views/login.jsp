<%--
  Created by IntelliJ IDEA.
  User: Aka.Dove
  Date: 2019/2/28
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${error}
<form action="register" method="post">
    Username: <input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="login">
</form>
</body>
</html>
