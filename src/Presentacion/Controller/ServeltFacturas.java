package Presentacion.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.FacturasNeg;
import negocioImlp.FacturasNegImpl;



/**
 * Servlet implementation class ServeltFacturas
 */
@WebServlet("/ServeltFacturas")
public class ServeltFacturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pagina = 1;
	private float precio1=0;
	private float precio2=0;
	private String fecha1="";
	private String fecha2="";
	FacturasNeg negLocal = new FacturasNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltFacturas() {
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
		
			request.setAttribute("listafac", negLocal.ListarFactura(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FacturaListar.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Precio")==true)
		{
		
			request.setAttribute("listafac", negLocal.obtenerTodosXprecio(precio1, precio2,pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FacturaListarXpre.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Fecha")==true)
		{
		
			
			request.setAttribute("listafac", negLocal.obtenerTodosXFecha(fecha1, fecha2,pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FacturaListarXfecha.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnprecio")!=null)
		{
			 precio1=(Float.parseFloat(request.getParameter("precio1")));
			 precio2=(Float.parseFloat(request.getParameter("precio2")));
			
			request.setAttribute("listafac", negLocal.obtenerTodosXprecio(precio1, precio2,pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FacturaListarXpre.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnfecha")!=null)
		{
			 fecha1=request.getParameter("fecha1").toString();
			fecha2=request.getParameter("fecha2").toString();
			
			request.setAttribute("listafac", negLocal.obtenerTodosXFecha(fecha1, fecha2,pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FacturaListarXfecha.jsp");
			dispatcher.forward(request, response);
		}
	}

}
