<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>登录页面</title>
  <link href="/css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
  <form action="/user/login" method="post" id="form">
    <h1 id="loginMsg">用户登录</h1>
    <div style="color: red;">${login_msg}</div>
    <div id="errorMsg" style="color: #00ff0d">${register_msg}</div>
    <p>用户名:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>
    <p>密码:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
    <%--<p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>--%>
    <div id="subDiv">
      <input type="submit" class="button" value="登录">
      <input type="reset" class="button" value="重置">&nbsp;&nbsp;&nbsp;
      <a href="/register">没有账号？</a>
    </div>
  </form>
</div>

</body>
</html>
