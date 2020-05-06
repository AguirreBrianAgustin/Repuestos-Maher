package Presentacion.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.LocalidadesNeg;
import negocioImlp.LocalidadesNegImpl;

/**
 * Servlet implementation class ServeltLocalidades
 */
@WebServlet("/ServeltLocalidades")
public class ServeltLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LocalidadesNeg negLocal = new LocalidadesNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltLocalidades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("Param").toString().equals("Listar")==true)
		{
		
			request.setAttribute("listaLocal", negLocal.ListarLocalidades());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientesAgregar.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
