package Presentacion.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.DetalleFacturaNeg;
import negocioImlp.DetalleFacturaNegImpl;


/**
 * Servlet implementation class ServeltdetalleFactura
 */
@WebServlet("/ServeltdetalleFactura")
public class ServeltdetalleFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pagina = 1;
	DetalleFacturaNeg negLocal = new DetalleFacturaNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltdetalleFactura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("prev".equals(request.getParameter("pag"))&&pagina>1) {
			pagina --;
		} else if ("next".equals(request.getParameter("pag"))) {
			pagina ++;
		}
		
		if(request.getParameter("Param").toString().equals("Listar")==true)
		{
		
			request.setAttribute("listaDetallefac", negLocal.ListarDetalleFactura(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DetalleFacturaListar.jsp");
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
