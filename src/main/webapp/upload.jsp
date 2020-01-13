<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/1/13
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="file" name="file"/>
    <input type="submit" name="登录">
</form>
</body>
</html>
