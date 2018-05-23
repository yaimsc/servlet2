<%@page import="modelo.Libro"%>
<%@page import="modelo.LibroModelo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Login Form</title>
<%
	//pedir parametro
	String titulo = request.getParameter("titulo"); 
	String autor = request.getParameter("autor");
	int id = Integer.parseInt(request.getParameter("id")); 
	//contactar con el modelo para pillar los datos de los libros
	LibroModelo libroModelo = new LibroModelo(); 
	Libro libro = libroModelo.select(id); 
%>
</head>
<body>
	<form action="./EditarLibroServlet" method="get">
		Titulo: <input type="text" value="<%= libro.getTitulo() %>" name="titulo"><br><br>
		Autor: <input type="text" value="<%= libro.getAutor() %>" name="autor"><br><br>
		<input type="hidden" value="<%= libro.getId() %>" name="id">
		<input type="submit" value="Guardar">
	</form>
</body>
</html>