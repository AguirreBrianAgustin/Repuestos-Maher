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

import Entidad.Categorias;
import Entidad.Proveedores;
import Entidad.Repuestos;
import Entidad.Marcas;
import Negocio.CategoriasNeg;
import Negocio.MarcasNeg;
import Negocio.ProveedoresNeg;
import Negocio.RepuestosNeg;
import negocioImlp.CategoriasNegImpl;
import negocioImlp.MarcasNegImpl;
import negocioImlp.ProveedoresNegImpl;
import negocioImlp.RepuestosNegImpl;


@WebServlet("/ServletProductos")
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MarcasNeg negMarc = new MarcasNegImpl();
	private int pagina = 1;
	ProveedoresNeg negProv = new ProveedoresNegImpl();
	CategoriasNeg negCat = new CategoriasNegImpl();
	RepuestosNeg negRep = new RepuestosNegImpl();
	 private int idrepuestosCat=0;
	 private int idMarca=0;
	 private float precio1=0;
	 private float precio2=0;
    public ServletProductos() {
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
			
			request.setAttribute("listaRep", negRep.ListarRepuestos(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductosListar.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("Param").toString().equals("ListarCompra")==true)
		{
			
			request.setAttribute("listaRep", negRep.ListarRepuestos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Compra.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("Agregar")==true)
		{
				
			request.setAttribute("listaMarc", negMarc.ListarMarcas());
			request.setAttribute("listaProv", negProv.ListarProveedores());
			request.setAttribute("listaCat", negCat.obtenerTodos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductosAgregar.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("Param").toString().equals("Eliminar")==true)
		{
			
			request.setAttribute("listaRep", negRep.ListarRepuestos(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductosEliminar.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("Param").toString().equals("Modificar")==true)
		{
			request.setAttribute("listaMarc", negMarc.ListarMarcas());
			request.setAttribute("listaProv", negProv.ListarProveedores());
			request.setAttribute("listaCat", negCat.obtenerTodos());
			request.setAttribute("listaRep", negRep.ListarRepuestosMOD(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductosModificar.jsp");
			dispatcher.forward(request, response);
		}
		
		
		if(request.getParameter("Param").toString().equals("catpro")==true)
		{
			request.setAttribute("listaRep", negRep.CategoriaProd(idrepuestosCat,idMarca, pagina));
			request.setAttribute("pagina", pagina);
			request.setAttribute("muestaPag", 1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CatxPro.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("Param").toString().equals("btnProductosXCategoriaFiltroPrecio")==true)
		{
			request.setAttribute("listaRep", negRep.CategoriaProdPrcio(idrepuestosCat,idMarca, pagina, precio1, precio2));
			request.setAttribute("pagina", pagina);
			request.setAttribute("muestaPag", 2);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CatxPro.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("prev".equals(request.getParameter("pag"))&&pagina>1) {
			pagina --;
		} else if ("next".equals(request.getParameter("pag"))) {
			pagina ++;
		}
		if(request.getParameter("btnAceptar")!=null)
	    {
	    	
	    	Repuestos r = new Repuestos();
	    	r.setNombre(request.getParameter("nombreProducto"));
	    	r.setDescripcion(request.getParameter("descripcionProducto"));
	    	r.setPrecio(Float.parseFloat(request.getParameter("precioProducto")));
	    	r.setStock(Integer.parseInt(request.getParameter("stockProducto")));
	    	r.setEstado("1");
	    	r.setMarca(new Marcas(Integer.parseInt(request.getParameter("comboMar"))));
	    	r.setCategoria(new Categorias(Integer.parseInt(request.getParameter("comboCat"))));
	    	r.setProveedor(new Proveedores(Integer.parseInt(request.getParameter("comboPro"))));
	    	   
	    	   int mark=Integer.parseInt(request.getParameter("comboMar"));
	    	boolean estado=false,estado2=true;
	    	estado2=negRep.ExisteRepuesto(request.getParameter("nombreProducto"));
	    	int resu= negRep.obtenerRepuestoidMODELO(request.getParameter("nombreProducto"),(Integer.parseInt(request.getParameter("comboMar"))));
	    	if(estado2==false || resu!=mark){
	    	estado = negRep.insertar(r);}
	    	request.setAttribute("estadoRepuestos", estado);
	    	request.setAttribute("listaMarc", negMarc.ListarMarcas());
			request.setAttribute("listaProv", negProv.ListarProveedores());
			request.setAttribute("listaCat", negCat.obtenerTodos());
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductosAgregar.jsp");
			dispatcher.forward(request, response);
	    }
		if(request.getParameter("btnEliminarRepuestos")!=null)
		{
						
			int idrepuestos = Integer.parseInt(request.getParameter("Param").toString());
			negRep.borrar(idrepuestos);
			
			List<Repuestos> repuestos = new ArrayList<Repuestos>();
			repuestos = negRep.ListarRepuestos();
			request.setAttribute("listaRep", negRep.ListarRepuestos(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductosEliminar.jsp");
			dispatcher.forward(request, response);
			
		}
		if(request.getParameter("btnModificarProductos")!=null)
		{
			
			int idrepuestos = Integer.parseInt(request.getParameter("Param").toString());
			
	    	Repuestos r = new Repuestos();
	    	r.setId(idrepuestos);
	    	r.setNombre(request.getParameter("Nombretxt"));
	    	String nom=request.getParameter("Nombretxt");
	    	r.setDescripcion(request.getParameter("Descripciontxt"));
	    	r.setPrecio(Float.parseFloat(request.getParameter("Precioetxt")));
	    	r.setStock(Integer.parseInt(request.getParameter("Stocktxt")));
	    	r.setEstado(request.getParameter("estado"));
	    	r.setMarca(new Marcas(Integer.parseInt(request.getParameter("comboMar"))));
	    	   int mark=Integer.parseInt(request.getParameter("comboMar"));
	    	r.setCategoria(new Categorias(Integer.parseInt(request.getParameter("comboCat"))));
	    	r.setProveedor(new Proveedores(Integer.parseInt(request.getParameter("comboPro"))));
	    	boolean estado=false,estado2=true;
	    	int resu=0;
	    	estado2=negRep.ExisteRepuesto(nom);
	    	resu=negRep.obteneRepuestoid(request.getParameter("Nombretxt"),mark);
	    
	    	int resuu= negRep.obtenerRepuestoidMODELO(request.getParameter("Nombretxt"),(Integer.parseInt(request.getParameter("comboMar"))));
	    	
	    	if(estado2==false) {
	    		
			estado=negRep.editar(r);}
	    	if(resu==idrepuestos) {estado=negRep.editar(r);}
	    	if(resuu==mark) {estado=negRep.editar(r);}
	    	if(resuu!=mark) {estado=negRep.editar(r);}
			//if(resu==0 && resuu==0) {estado=negRep.editar(r);}
			List<Repuestos> repuestos = new ArrayList<Repuestos>();
			repuestos = negRep.ListarRepuestos();
			
			request.setAttribute("listaMarc", negMarc.ListarMarcas());
			request.setAttribute("listaProv", negProv.ListarProveedores());
			request.setAttribute("listaCat", negCat.obtenerTodos());
			request.setAttribute("listaRep", negRep.ListarRepuestosMOD(pagina));
			request.setAttribute("estadoproducto", estado);
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductosModificar.jsp");
			dispatcher.forward(request, response);
			
		
		}
		
		if(request.getParameter("venta")!=null)
		{
			idrepuestosCat =Integer.parseInt(request.getParameter("comboCat"));
			idMarca=Integer.parseInt(request.getParameter("comboMar"));
			//request.setAttribute("listaRep", negRep.CategoriaProd(idrepuestosCat));
			request.setAttribute("listaRep", negRep.CategoriaProd(idrepuestosCat,idMarca, pagina));
			request.setAttribute("pagina", pagina);
			
			request.setAttribute("muestaPag", 1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CatxPro.jsp");
			dispatcher.forward(request, response);
		}
		
		
		if(request.getParameter("btnProductosXCategoriaQUITARFiltroPrecio")!=null)
		{
			
			//request.setAttribute("listaRep", negRep.CategoriaProd(idrepuestosCat));
			request.setAttribute("listaRep", negRep.CategoriaProd(idrepuestosCat,idMarca, pagina));
			request.setAttribute("pagina", pagina);
			request.setAttribute("idCategoria", idrepuestosCat );
			request.setAttribute("muestaPag", 1);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CatxPro.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnProductosXCategoriaFiltroPrecio")!=null)
		{
			
			precio1=(Float.parseFloat(request.getParameter("precioMin")));
			precio2=(Float.parseFloat(request.getParameter("precioMax")));
			//request.setAttribute("listaRep", negRep.CategoriaProd(idrepuestosCat));
			request.setAttribute("listaRep", negRep.CategoriaProdPrcio(idrepuestosCat,idMarca, pagina, precio1, precio2));
			request.setAttribute("pagina", pagina);
			request.setAttribute("muestaPag", 2);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CatxPro.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnSelectedProductoid")!=null)
		{
			int idrepuestos = Integer.parseInt(request.getParameter("idProductoSelected").toString());
			System.out.println("SERVLET PRODUCTO"+ idrepuestos);
			request.setAttribute("listaRep", negRep.obtenerUno(idrepuestos));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/categoriaProd2A.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
