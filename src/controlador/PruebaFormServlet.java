package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PruebaFormServlet
 */
@WebServlet("/PruebaFormServlet")
public class PruebaFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter(); //PrintWriter para sacar por pantalla
		out.println(request.getParameter("provincia") + "<br>");
		String deacuerdo = request.getParameter("deacuerdo");
	
		if(deacuerdo == null ){
			out.println("No estoy de acuerdo"); 
		}else{
			out.println("Estoy de acuerdo"); 
		}
		
		out.println("<br>"); 
		
		String[] ingredientes = request.getParameterValues("ingredientes"); 
		if(ingredientes != null){
			for(int i= 0; i < ingredientes.length; i++){
				out.println(ingredientes[i] + "<br>"); 
			}
		}
		
		out.println("Sexo: "  + (request.getParameter("sexo")));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
