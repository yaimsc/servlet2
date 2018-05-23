package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.LibroModelo;

public class listarLibrosServlet extends HttpServlet {
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// llamamos modelo
		
		LibroModelo libroModelo = new LibroModelo(); 
		
		//lamamamos a todo el array de libros 
		
		ArrayList<Libro> libros = libroModelo.selectAll();
		
		//le adjudicamos los atributos 
		
		request.setAttribute("libros", libros);
		
		//redirigimos a la pagina donde se listan
		
		if (libros != null){
			RequestDispatcher rd = request.getRequestDispatcher("listarLibros.jsp");  
			rd.forward(request, response); 
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("adios.jsp"); 
			rd.forward(request, response); 
		}
		
		
		
		
	}

}
