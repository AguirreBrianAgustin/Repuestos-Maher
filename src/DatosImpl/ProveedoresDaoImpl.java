package DatosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datos.ProveedoresDao;
import Entidad.Marcas;
import Entidad.Proveedores;


public class ProveedoresDaoImpl implements ProveedoresDao{
	private int tamanioPagina = 10;
	private Conexion cn;
	 String host = "jdbc:mysql://localhost:3306/";
     String user = "root";
	 String pass = "Admin369";
	 String dbName = "repuestosmaher??profileSQL=true&useSSL=false";


	public ProveedoresDaoImpl() 
	{
		
	}
	
	@Override
	public List<Proveedores> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Proveedores> list = new ArrayList<Proveedores>();
		 try
		 {
			 ResultSet rs= cn.query("Select proveedores.idProveedores, proveedores.Nombre, proveedores.Telefono, proveedores.Estado from proveedores where estado = 1");
			 while(rs.next())
			 {
				 Proveedores pro = new Proveedores();
				 pro.setIdProveedores(rs.getInt("proveedores.idProveedores"));
				 pro.setNombre(rs.getString("proveedores.Nombre"));
				 pro.setTelefono(rs.getString("proveedores.Telefono"));
				 pro.setEstado(rs.getString("proveedores.Estado"));
				 list.add(pro);
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
	public Proveedores obtenerUno(int id) {
		cn = new Conexion();
		cn.Open();
		 Proveedores pro = new Proveedores();
		 try
		 {
			 ResultSet rs= cn.query("Select * from proveedores");
			 rs.next();
			 pro.setIdProveedores(rs.getInt("proveedores.idProveedores"));
			 pro.setNombre(rs.getString("proveedores.Nombre"));
			 pro.setTelefono(rs.getString("proveedores.Telefono"));
			 pro.setEstado(rs.getString("proveedores.Estado"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return pro;
	}

	@Override
	public boolean insertar(Proveedores pro) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO proveedores (Nombre, Telefono, Estado) VALUES ('"+pro.getNombre()+"', '"+pro.getTelefono()+"', '"+1+"')";
		///String query = "INSERT INTO proveedores (Nombre, Telefono, Estado) VALUES ('"+pro.getNombre()+"', '"+1+"')";
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
	public boolean editar(Proveedores pro) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE proveedores SET Nombre='"+pro.getNombre()+"', Telefono='"+pro.getTelefono()+"', estado='"+pro.getEstado()+"' WHERE idProveedores="+pro.getIdProveedores();

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
		 
		String query = "UPDATE proveedores SET Estado=0 WHERE idProveedores="+id;
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
	public List<Proveedores> obtenerPagina(int pagina) {
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Proveedores> list = new ArrayList<Proveedores>();
		 try
		 {
			 ResultSet rs= cn.query("Select proveedores.idProveedores, proveedores.Nombre, proveedores.Telefono, proveedores.Estado "
			 		+ " from proveedores where estado = 1 LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Proveedores pro = new Proveedores();
				 pro.setIdProveedores(rs.getInt("proveedores.idProveedores"));
				 pro.setNombre(rs.getString("proveedores.Nombre"));
				 pro.setTelefono(rs.getString("proveedores.Telefono"));
				 pro.setEstado(rs.getString("proveedores.Estado"));
				 list.add(pro);
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
	public Boolean ExisteProveedor(String nombre) {
		Connection cn = null;
		CallableStatement cst = null;
		  try
		  {
			  
			 Class.forName("com.mysql.jdbc.Driver");
			 cn = DriverManager.getConnection(host + dbName , user , pass);
			 cst = cn.prepareCall("{CALL sp_proveedor_existe(?,?)}");
			 
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
	public int obtenerProveedorid(String nombre) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				{
					int id=0;
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
					Connection con = null;
					try{
						con = DriverManager.getConnection(host + dbName, user, pass);
						PreparedStatement miSentencia = con.prepareStatement("select * from proveedores where nombre=?");
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
	public List<Proveedores> obtenerPaginaMOD(int pagina) {
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Proveedores> list = new ArrayList<Proveedores>();
		 try
		 {
			 ResultSet rs= cn.query("Select proveedores.idProveedores, proveedores.Nombre, proveedores.Telefono, proveedores.Estado "
			 		+ " from proveedores  LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Proveedores pro = new Proveedores();
				 pro.setIdProveedores(rs.getInt("proveedores.idProveedores"));
				 pro.setNombre(rs.getString("proveedores.Nombre"));
				 pro.setTelefono(rs.getString("proveedores.Telefono"));
				 pro.setEstado(rs.getString("proveedores.Estado"));
				 list.add(pro);
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
