package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.LibroModelo;

/**
 * Servlet implementation class EditarLibroServlet
 */

@WebServlet("/EditarLibroServlet")
public class EditarLibroServlet extends HttpServlet {

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo"); 
		String autor = request.getParameter("autor"); 
		
		// llamamos modelo
		
		LibroModelo libroModelo = new LibroModelo(); 
		
		Libro libro = libroModelo.select(id); 
		
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		
		libroModelo.update(libro);
		

//		RequestDispatcher rd = request.getRequestDispatcher("listarLibros.jsp"); 
//		rd.forward(request, response);
		
//tener que volver a inicioar todo para poder sacar de nuevo la lista de libros
		
ArrayList<Libro> libros = libroModelo.selectAll();

request.setAttribute("libros", libros);

if (libros != null){
	RequestDispatcher rd = request.getRequestDispatcher("listarLibros.jsp");  
	rd.forward(request, response); 
}else{
	RequestDispatcher rd = request.getRequestDispatcher("adios.jsp"); 
	rd.forward(request, response); 
}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
