package RespuestosMaher;

import Entidad.Repuestos;
import Negocio.CategoriasNeg;
import Negocio.MarcasNeg;
import Negocio.ProveedoresNeg;
import Negocio.RepuestosNeg;

import negocioImlp.CategoriasNegImpl;
import negocioImlp.MarcasNegImpl;
import negocioImlp.ProveedoresNegImpl;
import negocioImlp.RepuestosNegImpl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ServletCarro")
public class ServletCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private int count=0;
	MarcasNeg negMarc = new MarcasNegImpl();
	ProveedoresNeg negProv = new ProveedoresNegImpl();
	CategoriasNeg negCat = new CategoriasNegImpl();
	RepuestosNeg negRep = new RepuestosNegImpl();
    public ServletCarro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnCarroAgregar")!=null)
		{
			ArrayList<Repuestos> lProductosCarro = new ArrayList<Repuestos>();
			Repuestos producto = new Repuestos();
		
			
			try {
				boolean estadostock=false;
				int idrepuestos = Integer.parseInt(request.getParameter("Param").toString());
				int stock=Integer.parseInt(request.getParameter("stst").toString());
				producto.setId(idrepuestos);
				//producto = datos.obtenerUnRepuesto(Integer.parseInt((request.getParameter("idProducto"))));
				producto.setCantidad(Integer.parseInt(request.getParameter("cant")));
				producto.setNombre(request.getParameter("nombre"));
				producto.setStock(Integer.parseInt(request.getParameter("cant")));
			//	System.out.println("carro stock" + (request.getParameter("stock")));
				//producto.setStock(Integer.parseInt(request.getParameter("stock")));
			
				
				producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
				HttpSession obj_session_carro= request.getSession(false);
				System.out.println("voy a chequear el carro");
				//no creado aun
				if (obj_session_carro.getAttribute("Session_carro") == null || obj_session_carro.getAttribute("Session_carro").equals("")) {
					System.out.println("el carro esta vacio");
					System.out.println(producto.getNombre());
					lProductosCarro.add(producto);
					obj_session_carro.setAttribute("Session_carro", lProductosCarro);
				}else {
					lProductosCarro = (ArrayList<Repuestos>)obj_session_carro.getAttribute("Session_carro");
					
					for(Repuestos r :  lProductosCarro )
					{ if(r.getId()==idrepuestos) {
						count+=1;
						int sum=r.getCantidad()+Integer.parseInt(request.getParameter("cant"));
						if(sum <= stock) {
							System.out.print("dsdsdsds");
							
							r.setCantidad(sum);
						}
						else {estadostock=true;}
						
					}
					}
					if(count==0) {lProductosCarro.add(producto);}
					
					count=0;
					//creado
					
					System.out.println("el carro tiene cosas");
					System.out.println(producto.getNombre());
					
					
					//lProductosCarro.add(producto);
					request.setAttribute("estadostock", estadostock);
					obj_session_carro.setAttribute("Session_carro", lProductosCarro);
				}
			
				RequestDispatcher miDispacher = request.getRequestDispatcher("Carro2.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
				miDispacher.forward(request, response);
			}
			catch (Exception e) {
				e.printStackTrace();
				
				RequestDispatcher miDispacher = request.getRequestDispatcher("Carro2.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
				miDispacher.forward(request, response);
			}
		}
		
		if(request.getParameter("btnCarroEliminar")!=null)
		{
			ArrayList<Repuestos> lProductosCarro = new ArrayList<Repuestos>();
			
			try {
				HttpSession obj_session_carro= request.getSession(false);
				
				if (obj_session_carro.getAttribute("Session_carro") == null || obj_session_carro.getAttribute("Session_carro").equals("")) {
					System.out.println("el carro esta vacio");
				}else {
					System.out.println("el carro tiene cosas");
					if(request.getParameter("numero")!=null) {
						int numero = Integer.parseInt(request.getParameter("numero"));
						lProductosCarro = (ArrayList<Repuestos>)obj_session_carro.getAttribute("Session_carro");
						lProductosCarro.remove(numero-1);
					}
				}
				RequestDispatcher miDispacher = request.getRequestDispatcher("Carro2.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
				miDispacher.forward(request, response);
			}
			catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("compro", null);
				RequestDispatcher miDispacher = request.getRequestDispatcher("Carro2.jsp"); 
				miDispacher.forward(request, response);
			}
		}
		

		if(request.getParameter("btnCarroComprar")!=null) {
			ArrayList<Repuestos> lProductosCarro = new ArrayList<Repuestos>();
		Repuestos producto = new Repuestos();
		int idd=0;
		int usuarioid=0;
		String valorRadio="";
		valorRadio=request.getParameter("radio").toString();
		RepuestosNeg datos = new RepuestosNegImpl();
		try {
			HttpSession obj_session_carro= request.getSession(false);
			
			
			if (obj_session_carro.getAttribute("Session_carro") == null || obj_session_carro.getAttribute("Session_carro").equals("")) {
				System.out.println("el carro esta vacio");
				request.setAttribute("compro", false);
			}else {
			System.out.println("el carro tiene cosas");
			lProductosCarro = (ArrayList<Repuestos>)obj_session_carro.getAttribute("Session_carro");
			
		 idd= Integer.parseInt(request.getParameter("id").trim());
		System.out.println("lo que tienen el id"+ idd);
	
		 usuarioid=Integer.parseInt(request.getParameter("idusu").trim());
		
		if(datos.venta(lProductosCarro,idd,usuarioid,valorRadio)) {
				request.getSession().setAttribute("compro", true);
				System.out.println("compra realizada");
				obj_session_carro.setAttribute("Session_carro",null);
				count=0;
				request.setAttribute("compro", true);
			
			}
			else {
				System.out.println("compra fall.ida");
				request.setAttribute("compro", false);
				}
		
			}
			
			RequestDispatcher miDispacher = request.getRequestDispatcher("Carro2.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
			miDispacher.forward(request, response);
		}
		catch (Exception e) {
		
			e.printStackTrace();
			request.setAttribute("compro", true);
			RequestDispatcher miDispacher = request.getRequestDispatcher("Carro2.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
			miDispacher.forward(request, response);
		}
	}
		
	}
}

