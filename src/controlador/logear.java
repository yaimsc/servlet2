package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

public class logear extends HttpServlet{

	
		public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String nombre = request.getParameter("nombre"); 
			String password = request.getParameter("password"); 
			
			if(nombre.equals("zubiri") && password.equals("manteo")){
				//enviar lista de usuarios
					Usuario usuarioLogueado = new Usuario(); 
					usuarioLogueado.setNombre("zubiri");
					
					HttpSession session = request.getSession(); 		//login
					session.setAttribute("usuarioLogueado", usuarioLogueado);
					
					response.sendRedirect("listarUsuariosServlet");
			}else{
				
				RequestDispatcher rd = request.getRequestDispatcher("adios.html"); 
				rd.forward(request, response);
			}
		}
}
