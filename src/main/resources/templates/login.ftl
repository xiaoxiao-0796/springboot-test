<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example </title>
</head>
<body>
<form action="/dologin" method="post">
    <div><label> 用户名 : <input type="text" name="name"/> </label></div>
    <div><label> 密  码 : <input type="password" name="passwd"/> </label></div>
    <div><input type="submit" value="登录"/></div>
</form>
</body>
</html>