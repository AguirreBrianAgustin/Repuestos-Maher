package Presentacion.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Categorias;
import Entidad.Clientes;
import Entidad.Localidades;
import Negocio.CategoriasNeg;
import Negocio.ClientesNeg;
import Negocio.LocalidadesNeg;

import negocioImlp.CategoriasNegImpl;
import negocioImlp.ClientesNegImpl;
import negocioImlp.LocalidadesNegImpl;

/**
 * Servlet implementation class ServletClientes
 */
@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int pagina = 1;
	
	ClientesNeg negCat =  new ClientesNegImpl();
	LocalidadesNeg negLocal = new LocalidadesNegImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClientes() {
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
		
		if(request.getParameter("Param").toString().equals("Agregar")==true)
		{
		
			//request.setAttribute("Clie", negCat.ListarClientes(pagina));
			request.setAttribute("listaLocal", negLocal.ListarLocalidades());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientesAgregar.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Listar")==true)
		{
			request.setAttribute("listaLocal", negLocal.ListarLocalidades());
			request.setAttribute("Clie", negCat.ListarClientes(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientesListar.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("Param").toString().equals("Eliminar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("listaLocal", negLocal.ListarLocalidades());
			request.setAttribute("Clie", negCat.ListarClientes(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientesEliminar.jsp");
			dispatcher.forward(request, response);
		}
	
		if(request.getParameter("Param").toString().equals("Modificar")==true)
		{
			///request.setAttribute("listaMarc", negMarc.ListarMarcas());	
			request.setAttribute("Clie", negCat.ListarClientesMOD(pagina));
			request.setAttribute("listaLocal", negLocal.ListarLocalidades());
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientesModificar.jsp");
			dispatcher.forward(request, response);
		}
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		if(request.getParameter("btnEliminarclientes")!=null)
			{
				//Agarro el parametro que esta viajando en la URL
				
				int idClientes = Integer.parseInt(request.getParameter("Param").toString());
				negCat.borrar(idClientes);
				
				request.setAttribute("listaLocal", negLocal.ListarLocalidades());
				request.setAttribute("Clie", negCat.ListarClientes(pagina));
				request.setAttribute("pagina", pagina);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientesEliminar.jsp");
				dispatcher.forward(request, response);
			}
		 
		 if(request.getParameter("btnAceptar")!=null)
		    {
		    	Clientes x = new Clientes();
		    	x.setNombre(request.getParameter("txtNombre"));
		    	x.setEstado("1"); 
		    	x.setTelefono(request.getParameter("txtTelefono"));
		    	x.setDireccion(request.getParameter("txtDireccion"));
		    	x.setMail(request.getParameter("txtMail"));
		    	x.setDni(Integer.parseInt(request.getParameter("txtDni")));
		    	x.setIdLocalidades(Integer.parseInt(request.getParameter("comboLoc")));
		    	boolean estado2=true;
		    	boolean estado=false;
		    	estado2=negCat.ExisteCliente(Integer.parseInt(request.getParameter("txtDni")));
		    	if(estado2==false) {
		    		
		    		estado =negCat.insertar(x);
		    	}
		    //	x.setIdLocalidades(new Localidades(Integer.parseInt(request.getParameter("comboCat"));
		    	
		    	
		    	//estado =
		    	
		    	request.setAttribute("listaLocal", negLocal.ListarLocalidades());
		    	request.setAttribute("estadoClientes", estado);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientesAgregar.jsp");
				dispatcher.forward(request, response);
		    }
		   if(request.getParameter("btnModificarClientes")!=null)
		    {
		    	Clientes x = new Clientes();
		    	x.setNombre(request.getParameter("Nombretxt"));
		    	x.setTelefono(request.getParameter("Telefonotxt"));
		    	x.setDireccion(request.getParameter("Direcciontxt"));
		    	x.setDni(Integer.parseInt(request.getParameter("dnitxt")));
		    	x.setMail(request.getParameter("Mailtxt"));
		    	x.setEstado(request.getParameter("estado")); 
		    	
		    	x.setIdLocalidades(Integer.parseInt(request.getParameter("comboLocalidades")));
		    	int idclientes = Integer.parseInt(request.getParameter("Param").toString());
		    	x.setId(idclientes);
		    boolean estado=true;
		    	estado= negCat.editar(x);
		    
		    	request.setAttribute("Clie", negCat.ListarClientesMOD(pagina));
				request.setAttribute("listaLocal", negLocal.ListarLocalidades());
				request.setAttribute("estadocliente", estado);
				request.setAttribute("pagina", pagina);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ClientesModificar.jsp");
				dispatcher.forward(request, response);
		    }
		   
		   
		   
		   if(request.getParameter("btnObtenerDatos")!=null)
		    {
			   request.setAttribute("ClieUno", negCat.obtenerUno(Integer.parseInt(request.getParameter("dnicliente"))));
			   boolean estado=true;
			   estado= negCat.ExisteCliente((Integer.parseInt(request.getParameter("dnicliente"))));
			   request.setAttribute("estadocliente",estado);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Carro2.jsp");
				dispatcher.forward(request, response);
		    }
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

}
