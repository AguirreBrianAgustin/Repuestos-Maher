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

import DatosImpl.MarcasDaoImpl;
import Entidad.Marcas;
import Negocio.MarcasNeg;
import negocioImlp.MarcasNegImpl;

@WebServlet("/ServletMarcas")
public class ServletMarcas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pagina = 1;
	MarcasNeg negMarc = new MarcasNegImpl();
	
    public ServletMarcas() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("prev".equals(request.getParameter("pag"))&&pagina>1) {
			pagina --;
		} else if ("next".equals(request.getParameter("pag"))) {
			pagina ++;
		}
		
		
		if(request.getParameter("Param").toString().equals("Listar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaMarc", negMarc.ListarMarcas(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MarcasListar.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Agregar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaMarc", negMarc.ListarMarcas());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MarcasAgregar.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Eliminar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaMarc", negMarc.ListarMarcas(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MarcasEliminar.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Modificar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaMarc", negMarc.ListarMarcasMOD(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MarcasModificar.jsp");
			dispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if(request.getParameter("btnAceptar")!=null)
	    {
	    	Marcas x = new Marcas();
	    	boolean estado=false,estado2=true;
	    	estado2=negMarc.ExisteMarca(request.getParameter("nombre"));
	    	if(estado2==false) {
	    		//estado=true;
	    		x.setNombre(request.getParameter("nombre"));
		     	 estado = negMarc.insertar(x);
	    	}
	     
				request.setAttribute("estadoMarca", estado);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/MarcasAgregar.jsp");
			dispatcher.forward(request, response);
	    }
	    
		if(request.getParameter("btnEliminarMarcas")!=null)
		{
						
			int idmarcas = Integer.parseInt(request.getParameter("Param").toString());
			negMarc.borrar(idmarcas);
			
			List<Marcas> marcas = new ArrayList<Marcas>();
			marcas = negMarc.ListarMarcas();
			request.setAttribute("listaMarc", negMarc.ListarMarcas(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MarcasEliminar.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(request.getParameter("btnModicarMarcas")!=null)
		{
			
			int idmarcas = Integer.parseInt(request.getParameter("Param").toString());
			int resu= negMarc.obteneMarcaid(request.getParameter("Nombretxt"));
			Marcas a = new Marcas();
			a.setId(idmarcas);
			///a.setNombre(request.getParameter("Nombretxt"));
			a.setNombre(request.getParameter("Nombretxt")); /// no manda el parametro
			a.setEstado(request.getParameter("estado"));
			boolean estado=false,estado2=true;
	    	estado2=negMarc.ExisteMarca(request.getParameter("Nombretxt"));
	    	if(estado2==false || idmarcas==resu) {
	    		
	    		estado=negMarc.editar(a);
	    	}

			List<Marcas> marcas = new ArrayList<Marcas>();
			marcas = negMarc.ListarMarcas();
			request.setAttribute("listaMarc", negMarc.ListarMarcasMOD(pagina));
			request.setAttribute("pagina", pagina);
			request.setAttribute("estadomarca", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MarcasModificar.jsp");
			dispatcher.forward(request, response);
			
		
		}
	}
}
