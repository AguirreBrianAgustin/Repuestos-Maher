package DatosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datos.CategoriasDao;

import Entidad.Categorias;



public class CategoriasDaoIml implements CategoriasDao {
	private int tamanioPagina = 10;
	private Conexion cn;
	 String host = "jdbc:mysql://localhost:3306/";
     String user = "root";
	 String pass = "Admin369";
	 String dbName = "repuestosmaher??profileSQL=true&useSSL=false";

	public CategoriasDaoIml() 
	{
		
	}
	
	@Override
	public List<Categorias> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Categorias> list = new ArrayList<Categorias>();
		 try
		 {
			 ResultSet rs= cn.query("  Select categorias.idcategorias, categorias.nombre, categorias.estado from categorias where estado = 0 OR estado =1;");
			 while(rs.next())
			 {
				 Categorias cat = new Categorias();
				 cat.setId(rs.getInt("categorias.idcategorias"));
				 cat.setNombre(rs.getString("categorias.nombre"));
				 cat.setEstado(rs.getString("categorias.estado"));
				 list.add(cat);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}

	@Override
	public Categorias obtenerUno(int id) {
		cn = new Conexion();
		cn.Open();
		 Categorias cat = new Categorias();
		 try
		 {
			 ResultSet rs= cn.query("Select * from marcas");
			 rs.next();
			 cat.setId(rs.getInt("marcas.idmarcas"));
			 cat.setNombre(rs.getString("marcas.nombre"));
			 cat.setEstado(rs.getString("marcas.estado"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return cat;
	}

	@Override
	public boolean insertar(Categorias cat) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	
		String query = "INSERT INTO categorias(nombre,estado) VALUES ('"+cat.getNombre()+"', '"+cat.getEstado()+"')";
		//String query = "INSERT INTO categorias(nombre,estado) VALUES ('"+cat.getNombre()+"', '"+1+"')";
		///String query = "INSERT INTO marcas (nombre,estado) VALUES ('"+mar.getNombre()+"', '"+mar.getEstado()+"')";
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean editar(Categorias cat) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE categorias SET nombre='"+cat.getNombre()+"', estado="+cat.getEstado()+" WHERE idcategorias="+cat.getId();
		System.out.println(query);
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean borrar(int id) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();
		 
		String query = "UPDATE categorias SET estado=0 WHERE idcategorias="+id;
		System.out.println(query);
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public List<Categorias> obtenerPagina(int pagina) {
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Categorias> list = new ArrayList<Categorias>();
		 try
		 {
			 ResultSet rs= cn.query("  Select categorias.idcategorias, categorias.nombre, categorias.estado"
			 		+ " from categorias where estado=1 LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Categorias cat = new Categorias();
				 cat.setId(rs.getInt("categorias.idcategorias"));
				 cat.setNombre(rs.getString("categorias.nombre"));
				 cat.setEstado(rs.getString("categorias.estado"));
				 list.add(cat);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}

	@Override
	public Boolean ExisteCategoria(String nombre) {
		Connection cn = null;
		CallableStatement cst = null;
		  try
		  {
			  
			 Class.forName("com.mysql.jdbc.Driver");
			 cn = DriverManager.getConnection(host + dbName , user , pass);
			cst = cn.prepareCall("{CALL sp_categoria_existe(?,?)}");
			
			// cst = cn.prepareCall("{CALL  sp_categoria_id(?)}");
			 cst.setString(1, nombre);
			 cst.registerOutParameter(2, java.sql.Types.INTEGER);
			 int count = cst.executeUpdate();
			 
			 if(count > 0) {
					 return true;
			 }
			 else {
				 return false;
			 }
		  }
		  catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception en existe");
			return true;
		  }
		  finally{
			  try {
				cst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	}
	
	public int obtenerCategoriaid(String nombre)
	{
		int id=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Categorias usuario = new Categorias();
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("select * from categorias where nombre=?");
			miSentencia.setString(1, nombre); //Cargo el ID recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
				id=(resultado.getInt(1));
		    
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
		return id;
	}

	@Override
	public List<Categorias> obtenerPaginaMOD(int pagina) {
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Categorias> list = new ArrayList<Categorias>();
		 try
		 {
			 ResultSet rs= cn.query("  Select categorias.idcategorias, categorias.nombre, categorias.estado"
			 		+ " from categorias  LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Categorias cat = new Categorias();
				 cat.setId(rs.getInt("categorias.idcategorias"));
				 cat.setNombre(rs.getString("categorias.nombre"));
				 cat.setEstado(rs.getString("categorias.estado"));
				 list.add(cat);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}
	
}

