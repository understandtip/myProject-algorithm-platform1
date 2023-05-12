<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<form action="http://localhost:8080/brand-case/JavaProcess.sock" METHOD="post">
    <%--<form action="${pageContext.request.contextPath}/test" METHOD="post">--%>
    <input type="submit" value="test">
    content<textarea rows="30" cols="100" name="content"></textarea>
    action<input type="text" name="action" value="compile">
    name<input type="text" name="name" value="Main">
</form>
<h2>${resp}</h2>
<body>
</body>
</html>
