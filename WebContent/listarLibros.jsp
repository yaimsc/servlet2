<%@page import="modelo.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
ArrayList <Libro> libros = (ArrayList) request.getAttribute("libros"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>listar libros</title>
</head>
<body>
	<div class="conrtainer">
		<div class="row">
			<div class="col" align="center">
			<h1>La lista de Libros</h1><hr><br>
	
			<%
				for(Libro libro : libros){
					out.print(libro.getTitulo());
					out.print(" por "); 
					out.println(libro.getAutor());
					%>
					<br><a href='editarLoginForm.jsp?id=<%=libro.getId() %>'><button>Editar</button></a><hr><br>
			<%
				}
			%>
			</div>
		</div>
	</div>
</body>
</html>