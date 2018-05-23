<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<!-- inlcuir librerias de jslt -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

ArrayList<Usuario> usuarios = (ArrayList) request.getAttribute("usuarios"); 

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>listaUsuarios</title>
</head>
<body>
	<div class="conrtainer">
		<div class="row">
			<div class="col" align="center">
			<h1>Bienvenido ${sessionScope.usuarioLogueado.getNombre()}</h1>
			<br><hr><br>
			<h1>La lista de Usuarios</h1><hr><br>
		
	
			<%
				for(Usuario usuario1 : usuarios){
					out.println(usuario1.getNombre() + "<hr><br>"); 
				}
			%>
			</div>
		</div>
	</div>
		<div class="conrtainer">
		<div class="row">
			<div class="col" align="center">
			<h1>La lista de Usuarios con jstl</h1><hr><br>
	
			<c:forEach items="${usuarios}" var="usuario">
				${usuario.nombre} <br>
			</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>