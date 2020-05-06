package DatosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Datos.MarcasDao;
import Entidad.Categorias;
import Entidad.Marcas;



public class MarcasDaoImpl implements MarcasDao {
	private int tamanioPagina = 10;
	private Conexion cn;
	 String host = "jdbc:mysql://localhost:3306/";
     String user = "root";
	 String pass = "Admin369";
	 String dbName = "repuestosmaher??profileSQL=true&useSSL=false";

	public MarcasDaoImpl() 
	{
		
	}
	
	@Override
	public List<Marcas> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Marcas> list = new ArrayList<Marcas>();
		 try
		 {
			 ResultSet rs= cn.query("Select marcas.idmarcas, marcas.nombre, marcas.estado from marcas where estado = 1");
			 while(rs.next())
			 {
				 Marcas mar = new Marcas();
				 mar.setId(rs.getInt("marcas.idmarcas"));
				 mar.setNombre(rs.getString("marcas.nombre"));
				 mar.setEstado(rs.getString("marcas.estado"));
				 list.add(mar);
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
	public Marcas obtenerUno(int id) {
		cn = new Conexion();
		cn.Open();
		 Marcas mar = new Marcas();
		 try
		 {
			 ResultSet rs= cn.query("Select * from marcas");
			 rs.next();
			 mar.setId(rs.getInt("marcas.idmarcas"));
			 mar.setNombre(rs.getString("marcas.nombre"));
			 mar.setEstado(rs.getString("marcas.estado"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return mar;
	}

	@Override
	public boolean insertar(Marcas mar) {
		boolean estado=true;

		cn = new Conexion();
		
		cn.Open();	

		String query = "INSERT INTO marcas (nombre,estado) VALUES ('"+mar.getNombre()+"', '"+1+"')";
		
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
	public boolean editar(Marcas mar) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	


		String query = "UPDATE marcas SET nombre='"+mar.getNombre()+"', estado="+mar.getEstado()+" WHERE idmarcas="+mar.getId();
		///String query = "UPDATE marcas SET nombre='"+mar.getNombre()+" WHERE idmarcas="+mar.getId();

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
		 
		String query = "UPDATE marcas SET estado=0 WHERE idmarcas="+id;
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
	
	
	public boolean validar(String nombre) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();
		
		 	String query = "select * from marcas where marcas.nombre="+nombre;
	
		
		System.out.println(query);
		System.out.println("el estado111  " + estado);
		try
		 {
			
			estado=cn.execute(query);
			System.out.println("el estado  " + estado);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		System.out.println("el estado " + estado);
		return estado;
	}
	
	
	
	public boolean validarx2(String nombre) {
		boolean estado=false;
		cn = new Conexion();
		cn.Open();
		 
		String query = "select * from marcas where marcas.nombre="+nombre;
		
		System.out.println(query);
		
		
		int cantFilas=0;
		Connection con = null;
		try{
			
			
			Statement st = con.createStatement();
			cantFilas = st.executeUpdate(query);
			cn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
		if(cantFilas == 0)
			return false;
		return true;
	/*	try
		 {
			
		 
			 ResultSet rs= cn.query(query);
			 if(rs.next()) estado=true;
				
	
		
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
	}*/

		
		
}

	@Override
	public List<Marcas> obtenerPagina(int pagina) {
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Marcas> list = new ArrayList<Marcas>();
		 try
		 {
			 ResultSet rs= cn.query("Select marcas.idmarcas, marcas.nombre, marcas.estado"
			 		+ " from marcas where estado = 1 LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Marcas mar = new Marcas();
				 mar.setId(rs.getInt("marcas.idmarcas"));
				 mar.setNombre(rs.getString("marcas.nombre"));
				 mar.setEstado(rs.getString("marcas.estado"));
				 list.add(mar);
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
	
	public Boolean ExisteMarca(String nombre)
	{
		Connection cn = null;
		CallableStatement cst = null;
		  try
		  {
			  
			 Class.forName("com.mysql.jdbc.Driver");
			 cn = DriverManager.getConnection(host + dbName , user , pass);
			 cst = cn.prepareCall("{CALL sp_marca_existe(?,?)}");
			 
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

	@Override
	public int obtenerMarcaid(String nombre) {
		// TODO Auto-generated method stub
		{
			int id=0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   Marcas usuario = new Marcas();
			Connection con = null;
			try{
				con = DriverManager.getConnection(host + dbName, user, pass);
				PreparedStatement miSentencia = con.prepareStatement("select * from Marcas where nombre=?");
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
	}

	@Override
	public List<Marcas> obtenerPaginaMOD(int pagina) {
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Marcas> list = new ArrayList<Marcas>();
		 try
		 {
			 ResultSet rs= cn.query("Select marcas.idmarcas, marcas.nombre, marcas.estado"
			 		+ " from marcas  LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Marcas mar = new Marcas();
				 mar.setId(rs.getInt("marcas.idmarcas"));
				 mar.setNombre(rs.getString("marcas.nombre"));
				 mar.setEstado(rs.getString("marcas.estado"));
				 list.add(mar);
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