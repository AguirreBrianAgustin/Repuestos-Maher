package DatosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datos.ClientesDao;
import Entidad.Clientes;
import Entidad.Repuestos;

public class ClientesDaoImpl implements ClientesDao  {

	private int tamanioPagina = 10;
	
	private Conexion cn;
	 String host = "jdbc:mysql://localhost:3306/";
     String user = "root";
	 String pass = "Admin369";
	 String dbName = "repuestosmaher??profileSQL=true&useSSL=false";

	public ClientesDaoImpl() 
	{
		
	}
	
	@Override
	public List<Clientes> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Clientes> list = new ArrayList<Clientes>();
		 try
		 {
			 ResultSet rs= cn.query("Select clientes.idclientes, clientes.nombre, clientes.telefono, clientes.direccion, clientes.mail, clientes.dni, clientes.estado, clientes.localidades_idLocalidades from clientes where estado =0 OR estado =1; ");
			 while(rs.next())
			 {
				 Clientes clie = new Clientes();
				 clie.setId(rs.getInt("clientes.idclientes"));
				 clie.setNombre(rs.getString("clientes.nombre"));
				 clie.setTelefono(rs.getString("clientes.telefono"));
				 clie.setDireccion(rs.getString("clientes.direccion"));
				 clie.setMail(rs.getString("clientes.mail"));
				 clie.setDni(rs.getInt("clientes.dni"));
				 clie.setEstado(rs.getString("clientes.estado"));
				 clie.setIdLocalidades(rs.getInt("clientes.localidades_idLocalidades"));
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
	public boolean insertar(Clientes cat) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	
		String query = "INSERT INTO clientes(Nombre, Telefono, Direccion, Mail, DNI, Estado, localidades_idLocalidades) VALUES"
				+ " ('"+cat.getNombre()+"','"+cat.getTelefono()+"','"+cat.getDireccion()+"','"+cat.getMail()+
				"','"+cat.getDni()+"','"+"1"+"','"+cat.getIdLocalidades()+"')";
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
	
	public List<Clientes>obtenerUno(int dni) 
	{
		
		cn = new Conexion();
		cn.Open();
		 List<Clientes> list = new ArrayList<Clientes>();
		 try 
		 {
			 ResultSet rs= cn.query("select * from clientes where dni="+dni);
	
		
			 while(rs.next())
			 {
				 Clientes clie = new Clientes();
				 clie.setId(rs.getInt("clientes.idclientes"));
				 clie.setNombre(rs.getString("clientes.nombre"));
				 clie.setTelefono(rs.getString("clientes.telefono"));
				 clie.setDireccion(rs.getString("clientes.direccion"));
				 clie.setMail(rs.getString("clientes.mail"));
				 clie.setDni(rs.getInt("clientes.dni"));
				 clie.setEstado(rs.getString("clientes.estado"));
				 clie.setIdLocalidades(rs.getInt("clientes.localidades_idLocalidades"));
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
	public boolean editar(Clientes cli) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE clientes SET Nombre='"+cli.getNombre()+"', Telefono='"+cli.getTelefono()+"', Direccion='"+cli.getDireccion()+"', Mail='"+cli.getMail()+"', DNI='"+cli.getDni()+"', Estado='"+cli.getEstado()+"', localidades_idLocalidades='"+cli.getIdLocalidades()+"' WHERE idclientes="+cli.getId();
				
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
		 
		String query = "UPDATE clientes SET estado=0 WHERE idclientes="+id;
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
	public List<Clientes> obtenerPagina(int pagina) {
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Clientes> list = new ArrayList<Clientes>();
		 try
		 {
			 ResultSet rs= cn.query("Select clientes.idclientes, clientes.nombre, clientes.telefono, clientes.direccion, clientes.mail, clientes.dni, clientes.estado, " + 
					 				"clientes.localidades_idLocalidades from clientes where estado =1 LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Clientes clie = new Clientes();
				 clie.setId(rs.getInt("clientes.idclientes"));
				 clie.setNombre(rs.getString("clientes.nombre"));
				 clie.setTelefono(rs.getString("clientes.telefono"));
				 clie.setDireccion(rs.getString("clientes.direccion"));
				 clie.setMail(rs.getString("clientes.mail"));
				 clie.setDni(rs.getInt("clientes.dni"));
				 clie.setEstado(rs.getString("clientes.estado"));
				 clie.setIdLocalidades(rs.getInt("clientes.localidades_idLocalidades"));
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
	public Boolean ExisteCliente(int dni) {
		Connection cn = null;
		CallableStatement cst = null;
		  try
		  {
			  
			 Class.forName("com.mysql.jdbc.Driver");
			 cn = DriverManager.getConnection(host + dbName , user , pass);
			 cst = cn.prepareCall("{CALL sp_cliente_existe(?,?)}");
			 
			 cst.setInt(1, dni);
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
	public List<Clientes> obtenerPaginaMOD(int pagina) {
		// TODO Auto-generated method stub
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Clientes> list = new ArrayList<Clientes>();
		 try
		 {
			 ResultSet rs= cn.query("Select clientes.idclientes, clientes.nombre, clientes.telefono, clientes.direccion, clientes.mail, clientes.dni, clientes.estado, " + 
					 				"clientes.localidades_idLocalidades from clientes where estado =0 OR estado =1 LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Clientes clie = new Clientes();
				 clie.setId(rs.getInt("clientes.idclientes"));
				 clie.setNombre(rs.getString("clientes.nombre"));
				 clie.setTelefono(rs.getString("clientes.telefono"));
				 clie.setDireccion(rs.getString("clientes.direccion"));
				 clie.setMail(rs.getString("clientes.mail"));
				 clie.setDni(rs.getInt("clientes.dni"));
				 clie.setEstado(rs.getString("clientes.estado"));
				 clie.setIdLocalidades(rs.getInt("clientes.localidades_idLocalidades"));
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

	

}
