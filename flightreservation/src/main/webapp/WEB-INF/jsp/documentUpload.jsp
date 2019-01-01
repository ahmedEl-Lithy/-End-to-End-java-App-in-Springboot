<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Document Upload</title>
</head>
<body>
<h2>Upload Document</h2>
<form action="upload" method="post" enctype="multipart/form-data">
<pre>
Document: <input type="file" name="document">
<input type="submit" name="submit" value="upload">
</pre>
</form>
<table>
	<tr>
		<td>name</td>
		<td>link</td>
	</tr>
	<c:forEach items="${documents}" var="document">
		<tr>
			<td>${document.name}</td>
			<td><a href="download?id=${document.id}">Download</a></td>
		</tr>
	</c:forEach>

</table>
</body>
</html>