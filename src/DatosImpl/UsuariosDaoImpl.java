package DatosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datos.UsuariosDao;
import Entidad.Clientes;
import Entidad.Usuarios;

public class UsuariosDaoImpl implements UsuariosDao{
	private Conexion cn;
	private int tamanioPagina = 10;
	 String host = "jdbc:mysql://localhost:3306/";
     String user = "root";
	 String pass = "Admin369";
	 String dbName = "repuestosmaher??profileSQL=true&useSSL=false";

	@Override
	public List<Usuarios> obtenerUno(String usuario, String contraseña) {
		cn = new Conexion();
		cn.Open();
		 List<Usuarios> list = new ArrayList<Usuarios>();
		 try
		 {
			 ResultSet rs= cn.query("select usuarios.idusuarios,usuarios.nombre,usuarios.contraseña,usuarios.permiso,usuarios.estado" + 
			 		" from usuarios where nombre= '"+ usuario +"' and contraseña='"+ contraseña +"' AND  estado ='1' ; ");
			 String consulta="select usuarios.idusuarios,usuarios.nombre,usuarios.contraseña,usuarios.permiso,usuarios.estado" + 
				 		" from usuarios where nombre= '"+ usuario +"' and contraseña='"+ contraseña +"' AND  estado ='1'; ";
				 		System.out.print(consulta);
			 while(rs.next())
			 {
				 Usuarios clie = new Usuarios();
				 clie.setIdUsuario(rs.getInt("usuarios.idusuarios"));
				 clie.setNombre(rs.getString("usuarios.nombre"));
				 clie.setContrasena(rs.getString("usuarios.contraseña"));
				 clie.setEstado(rs.getString("usuarios.estado"));
				 clie.setPermiso(rs.getString("usuarios.permiso"));
				 list.add(clie);
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
	public List<Usuarios> obtenerTodosXPermiso0(int pagina) {
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Usuarios> list = new ArrayList<Usuarios>();
		 try
		 {
			 ResultSet rs= cn.query("select usuarios.idusuarios,usuarios.nombre,usuarios.contraseña,usuarios.permiso,usuarios.estado" + 
			 		" from usuarios where permiso=0  LIMIT " + tamanioPagina + " OFFSET " + offset + ";");
			
			 while(rs.next())
			 {
				 Usuarios clie = new Usuarios();
				 clie.setIdUsuario(rs.getInt("usuarios.idusuarios"));
				 clie.setNombre(rs.getString("usuarios.nombre"));
				 clie.setContrasena(rs.getString("usuarios.contraseña"));
				 clie.setEstado(rs.getString("usuarios.estado"));
				 clie.setPermiso(rs.getString("usuarios.permiso"));
				 list.add(clie);
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
	public boolean editarElim(int id, String dato) {
		// TODO Auto-generated method stub
		boolean estado=true;
		cn = new Conexion();
		cn.Open();
		 
		String query = "UPDATE usuarios SET estado='"+dato+"' WHERE idusuarios="+id;
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
	public boolean editarUsuario(int id, String contraseña) {
	
				boolean estado=true;
				cn = new Conexion();
				cn.Open();
				 
				String query = "UPDATE usuarios SET usuarios.contraseña='"+contraseña+"' WHERE idusuarios="+id;
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
	public boolean insertar(Usuarios usuarios) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		
		String query = "insert into usuarios(nombre,contraseña,permiso,estado)  value('"+usuarios.getNombre()+"', '"+usuarios.getContrasena()+"', '"+usuarios.getPermiso()+"', '"+usuarios.getEstado()+"')";
		
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
	public Boolean ExisteUsuario(String nombre) {
		Connection cn = null;
		CallableStatement cst = null;
		  try
		  {
			  
			 Class.forName("com.mysql.jdbc.Driver");
			 cn = DriverManager.getConnection(host + dbName , user , pass);
			 cst = cn.prepareCall("{CALL sp_usuario_existe(?,?)}");
			 
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

}
