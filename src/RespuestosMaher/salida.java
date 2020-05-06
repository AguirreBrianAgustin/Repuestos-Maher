package RespuestosMaher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 * Servlet implementation class salida
 */
@WebServlet("/salida")
public class salida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public salida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		if(request.getParameter("btnEntrar")!=null)
		{
		if(request.getSession().getAttribute("Session_email")!=null) {
		//	request.getSession().removeAttribute("Session_email");
			//request.getSession().invalidate();
		
			request.getSession().setAttribute("Session_email", null );
			
		
			
		}
		
		if(request.getSession().getAttribute("Session_contra")!=null) {
			request.getSession().setAttribute("Session_contra",null);
		}
		
		if(request.getSession().getAttribute("Session_permiso")!=null) {
			request.getSession().setAttribute("Session_permiso",null);
		}
		}
		
		if(request.getSession().getAttribute("Session_idusuario")!=null) {
			request.getSession().setAttribute("Session_idusuario",null);
		
		}
		
		RequestDispatcher miDispacher = request.getRequestDispatcher("/Home.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
	    miDispacher.forward(request, response);
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
