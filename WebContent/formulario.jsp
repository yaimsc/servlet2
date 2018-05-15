<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fromularo</title>
</head>
<body>
	<a href"/listaUsuarios?nombre=Juan">Prueba Get</a>
	<form action="/listaUsuarios" methos="post">
		<input tupe="text" name="nombre">
		<input type="sumbit" value="Enviar">
	</form>
</body>
</html>