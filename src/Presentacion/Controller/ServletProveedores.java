package Presentacion.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatosImpl.ProveedoresDaoImpl;
import Entidad.Proveedores;
import Negocio.ProveedoresNeg;
import negocioImlp.ProveedoresNegImpl;

@WebServlet("/ServletProveedores")
public class ServletProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pagina = 1;
	ProveedoresNeg negProv = new ProveedoresNegImpl();
	
    public ServletProveedores() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if("prev".equals(request.getParameter("pag"))&&pagina>1) {
			pagina --;
		} else if ("next".equals(request.getParameter("pag"))) {
			pagina ++;
		}
		
		if(request.getParameter("Param").toString().equals("Eliminar")==true)
		{
				
			request.setAttribute("listaProv", negProv.ListarProveedores(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProveedoresEliminar.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Modificar")==true)
		{
			
			request.setAttribute("listaProv", negProv.ListarProveedoresMOD(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProveedoresModificar.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Listar")==true)
		{
			
			request.setAttribute("listaProv", negProv.ListarProveedores(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProveedoresListar.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if(request.getParameter("btnAceptar")!=null)
	    { boolean estado2 = true;
	    estado2=negProv.ExisteProv(request.getParameter("txtNombre"));
	    	Proveedores x = new Proveedores();
	    	x.setNombre(request.getParameter("txtNombre"));
	    	x.setTelefono(request.getParameter("txtTelefono"));
	    	x.setEstado("true");
	    	boolean estado=false;
	    	if(estado2==false)	{
	    		estado = negProv.insertar(x);
	    	}
	    	request.setAttribute("estadoProveedor", estado);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/ProveedoresAgregar.jsp");
			dispatcher.forward(request, response);
	    }
	    
		if(request.getParameter("btnEliminarProveedores")!=null)
		{
						
			int idproveedor = Integer.parseInt(request.getParameter("Param").toString());
			negProv.borrar(idproveedor);
			
			List<Proveedores> proveedores = new ArrayList<Proveedores>();
			proveedores = negProv.ListarProveedores();
			request.setAttribute("listaProv", negProv.ListarProveedores());
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProveedoresEliminar.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(request.getParameter("btnModificarProveedores")!=null)
		{
			
			int idproveedor = Integer.parseInt(request.getParameter("Param").toString());
			int resu= negProv.obteneprovid(request.getParameter("Nombretxt"));
			String est=request.getParameter("estado");
			Proveedores p = new Proveedores();
			p.setIdProveedores(idproveedor);
			p.setNombre(request.getParameter("Nombretxt")); 
			p.setTelefono(request.getParameter("Telefonotxt"));
			p.setEstado(est);
			boolean estado=false,estado2=false;
			estado2=negProv.ExisteProv(request.getParameter("Nombretxt"));
			if(estado2==false || idproveedor==resu) {
			estado=negProv.editar(p);}
			
			
			
			List<Proveedores> proveedores = new ArrayList<Proveedores>();
			proveedores = negProv.ListarProveedores();
			request.setAttribute("listaProv", negProv.ListarProveedoresMOD(resu));
			request.setAttribute("estadoproveedor", estado);
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProveedoresModificar.jsp");
			dispatcher.forward(request, response);
			
		
		}
	}

}
