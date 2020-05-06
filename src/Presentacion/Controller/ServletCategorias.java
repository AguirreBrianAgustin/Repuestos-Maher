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

import DatosImpl.CategoriasDaoIml;
import Entidad.Categorias;
import Negocio.CategoriasNeg;
import Negocio.MarcasNeg;
import negocioImlp.CategoriasNegImpl;
import negocioImlp.MarcasNegImpl;



@WebServlet("/ServletCategorias")
public class ServletCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int pagina = 1;
		CategoriasNeg negCat =  new CategoriasNegImpl();
		MarcasNeg negMarc = new MarcasNegImpl();
	    
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public ServletCategorias() {
        super();
        // TODO Auto-generated constructor stub
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
		
		if(request.getParameter("Param").toString().equals("Listar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaCat", negCat.ListarCategorias(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CategoriasListar.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("Param").toString().equals("Listarx2")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaCat", negCat.obtenerTodos());
			request.setAttribute("listaMarc", negMarc.ListarMarcas());
			//request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Venta.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Eliminar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaCat", negCat.ListarCategorias(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CategoriasEliminar.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
		
		if(request.getParameter("Param").toString().equals("Modificar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaCat", negCat.ListarCategoriasMOD(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CategoriasModificar.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   if(request.getParameter("btnAceptar")!=null)
		    {
		    	Categorias x = new Categorias();
		    	x.setNombre(request.getParameter("txtNombre"));
		    	x.setEstado("1"); 
		    	boolean estado=false,estado2=true;
		    	estado2=negCat.ExisteCategoria(request.getParameter("txtNombre"));
		    	if(estado2==false) {
		    		estado = negCat.insertar(x);
		    		
		    	}
		    	
		    	
		    	
		    	request.setAttribute("estadoCategorias", estado);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/CategoriasAgregar.jsp");
				dispatcher.forward(request, response);
		    }
		   
		   if(request.getParameter("btnEliminarListarcategorias")!=null)
			{
				//Agarro el parametro que esta viajando en la URL
				
				int idcatgorias = Integer.parseInt(request.getParameter("Param").toString());
				
				negCat.borrar(idcatgorias);
				
				
				request.setAttribute("listaCat", negCat.ListarCategorias(pagina));
				request.setAttribute("pagina", pagina);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/CategoriasEliminar.jsp");
				dispatcher.forward(request, response);
			}
		   if(request.getParameter("btnActualizarcategorias")!=null)
		    {
		    	Categorias x = new Categorias();
		    	x.setNombre(request.getParameter("nombre"));
		    	int resu= negCat.obtenerCategoriaid(request.getParameter("nombre"));
		    	
		    	
		    	x.setEstado(request.getParameter("estado")); 
		    	int idcatgorias = Integer.parseInt(request.getParameter("Param").toString());
		    	x.setId(idcatgorias);
		    	
		    	boolean estado=false,estado2=true;
		    	estado2=negCat.ExisteCategoria(request.getParameter("nombre"));
		    	if(estado2==false || resu==idcatgorias) {
		    	estado=negCat.editar(x);
		    	}
				request.setAttribute("listaCat", negCat.ListarCategoriasMOD(idcatgorias));
				request.setAttribute("estadocategoria", estado);
				request.setAttribute("pagina", pagina);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/CategoriasModificar.jsp");
				dispatcher.forward(request, response);
		    }
		   
	}

}
