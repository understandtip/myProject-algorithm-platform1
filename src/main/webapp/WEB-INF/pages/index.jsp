<%--
  Created by IntelliJ IDEA.
  User: LICHEN
  Date: 2020/5/10
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<form action="/blogs/test1" METHOD="post">
    <input type="submit" value="test">
    content<textarea rows="8" name="content"></textarea>
    opt<input type="text" name="opt" value="2">
</form>
<h2>${resp}</h2>
<body>
</body>
</html>
