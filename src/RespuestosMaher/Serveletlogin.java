package RespuestosMaher;
 import Entidad.Marcas;
import Entidad.Usuarios;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Negocio.UsuariosNeg;
import negocioImlp.UsuariosNegImpl;

/**
 * Servlet implementation class Serveletlogin
 */
@WebServlet("/Serveletlogin")
public class Serveletlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosNeg negLocal = new UsuariosNegImpl();
	private int pagina = 1;
	Usuarios usu = new Usuarios();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serveletlogin() {
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
			request.setAttribute("listaLogin",  negLocal.obtenerTodosXPermiso0(pagina));
			request.setAttribute("pagina", pagina);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminModEstado.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("btnEntrarbd")!=null)
		{
	
			
			boolean estado=true;
			String emailSTR="";
			String contraStr="";
			String Permiso="";
			int idusuario=0;
			//String contraStr="";
			if(request.getParameter("email")!=null)
			{
				emailSTR=request.getParameter("email");
			}
			
			if(request.getParameter("pw")!=null)
			{
				contraStr=request.getParameter("pw");
			}
			
			request.setAttribute("listaUsuario", negLocal.obtenerUno(emailSTR, contraStr));
			
			////
			//HttpSession obj_session_login= request.getSession(false);
			ArrayList<Usuarios> listaA = new ArrayList<Usuarios>();
			
			if (request.getAttribute("listaUsuario") != null) {
				listaA = (ArrayList<Usuarios>) request.getAttribute("listaUsuario");
			}
		
			System.out.print("holaaaa1");
			
		

			if(listaA == null || listaA.size() == 0)
			{
				System.out.print("no existe en la base de datos");
				estado= false;
				RequestDispatcher miDispacher = request.getRequestDispatcher("/Home.jsp"); 
			}
			else{
				System.out.print(" existe en la base de datos");
				
				for (Usuarios a : listaA ) {
					idusuario=a.getIdUsuario();
					emailSTR=a.getNombre();
					 contraStr=a.getContrasena();
					 Permiso=a.getPermiso();
					/*
					if (obj_session_login.getAttribute("Session_login") == null || obj_session_login.getAttribute("Session_login").equals("")) {
						System.out.println("el carro esta vacio");
						
						obj_session_login.setAttribute("Session_login", listaA);
					}*/
					 session.setAttribute("Session_login", listaA);
						}
				session.setAttribute("Session_idusuario", idusuario);
				session.setAttribute("Session_email", emailSTR);
				session.setAttribute("Session_contra", 	contraStr);
				session.setAttribute("Session_permiso", Permiso);
				
			}
		
			request.setAttribute("estadologin",  estado);
			RequestDispatcher miDispacher = request.getRequestDispatcher("/login.jsp"); 
			// Es el archivo JSP al que le vamos a enviar la informacion
			
		    miDispacher.forward(request, response);
		}
		
		
		if(request.getParameter("btnActualizarusuarios")!=null)
		{
			int id=Integer.parseInt(request.getParameter("Param").toString());
			String dato=request.getParameter("estado");
			
			request.setAttribute("listaLogin",  negLocal.editarElim(id, dato));
			request.setAttribute("listaLogin",  negLocal.obtenerTodosXPermiso0(pagina));
			request.setAttribute("pagina", pagina);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminModEstado.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnActualizarContra")!=null)
		{
			boolean estado=true;
			String actual=request.getParameter("contraseñaAnt");
			int id=(int) session.getAttribute("Session_idusuario");
			String nueva=request.getParameter("contraseñaNue");
			     if(session.getAttribute("Session_contra").equals(actual)) {
			    	 
			    	 request.setAttribute("listaLogin",  negLocal.editarUsuario(id, nueva));
			    	 session.setAttribute("Session_contra", nueva);;
			     }
			     else {
			    	 estado=false;
			     }
			
			
			     request.setAttribute("actualizar", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizarContra.jsp");
			dispatcher.forward(request, response);
		}
		
		 if(request.getParameter("btnAgregarUsuario")!=null)
		    {
			
		    	boolean estado=false,estado2=true;
		    	estado2=negLocal.ExisteUsuario(request.getParameter("nombre"));
		     	usu.setNombre(request.getParameter("nombre"));
		     	usu.setContrasena(request.getParameter("pw"));
		     	usu.setEstado(request.getParameter("estado").toString());
		     	usu.setPermiso(request.getParameter("permiso").toString());
		    //	estado=negMarc.validar(request.getParameter("nombre"));
		     	if(estado2==false) {
	       estado = negLocal.insertar(usu);}
				
				
					request.setAttribute("estadoUsuario", estado);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Agregar.jsp");
				dispatcher.forward(request, response);
		    }
		
	}

}
