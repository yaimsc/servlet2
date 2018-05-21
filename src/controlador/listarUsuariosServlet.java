package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import modelo.UsuarioModelo;


public class listarUsuariosServlet extends HttpServlet{

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String nombreUsuario = request.getParameter("nombre"); 
		
		HttpSession session = request.getSession(); 
		Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado"); 
		
		if(usuarioLogueado != null){
		
			//llamamos al modelo 
			
			UsuarioModelo usuarioModelo = new UsuarioModelo(); 
			
			
			// creamos un arraylist y seleccionamos todos nuestros usuarios de la BBDD y rellenamos la lista 
			ArrayList<Usuario> usuarios = usuarioModelo.selectAll();  
			Usuario usuario = new Usuario(); 
			//usuario.setNombre("Jon");
			//usuarios.add(usuario); 
			usuario = new Usuario(); 
			usuario.setNombre("Imanol");
			usuarios.add(usuario); 
			usuario = new Usuario(); 
			usuario.setNombre(usuarioLogueado.getNombre());
			usuarios.add(usuario); 
			
			
			//le damos esos atributos a los usuarios
			request.setAttribute("usuarios", usuarios);
			
			//PARA QUE MANDE A ESE JSP QUE NOSOTROS PONEMOS
			RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp"); 
			rd.forward(request, response);
		
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("adios.html"); 
			rd.forward(request, response);
		}
	}
	
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String nombreUsuario = request.getParameter("nombre"); 
		
		// creamos un arraylist y rellenamos la lista 
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); 
		Usuario usuario = new Usuario(); 
		usuario.setNombre("Yaiza");
		usuarios.add(usuario); 
		
		usuario = new Usuario(); 
		usuario.setNombre("Iñaki");
		usuarios.add(usuario); 
		
		usuario = new Usuario(); 
		usuario.setNombre(nombreUsuario);
		usuarios.add(usuario); 
		
		
		//le damos esos atributos a los usuarios
		request.setAttribute("usuarios", usuarios);
		
		//PARA QUE MANDE A ESE JSP QUE NOSOTROS PONEMOS
		RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp"); 
		rd.forward(request, response);
	}
}
