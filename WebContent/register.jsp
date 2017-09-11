<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册页面</title>
<h2>注册页面</h2>
<form action="user_register.action" method="post" namespace="/">
	账号:<input type="text" name="login"></br>
	姓名:<input type="text" name="name"></br>
	密码:<input type="password" name="pass"></br>
	性别:<input type="radio" name="sex" value="男"/>男&nbsp&nbsp<input type="radio" name="sex" value="女"/>女</br>
	电话号码:<input type="text" name="phone"></br>
	电子邮件:<input type="text" name="email"></br>
	<input type="submit" value="注册">
</form>
</head>
<body>

</body>
</html>