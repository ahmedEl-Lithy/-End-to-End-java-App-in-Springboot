<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>User Login</title>
</head>
<body>
	<form action="login" method="post">
	<h2>User Login</h2>
		<pre>
			Email: <input type="text" name="email">
			Password: <input type="password" name="password">
			<input type="submit" value="login">
			${msg}
		</pre>
	</form>
</body>
</html>