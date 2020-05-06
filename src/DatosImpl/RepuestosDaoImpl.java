package DatosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import Datos.RepuestosDao;
import Entidad.Marcas;
import Entidad.Proveedores;
import Entidad.Repuestos;

import Entidad.Categorias;

public class RepuestosDaoImpl implements RepuestosDao {
	private int tamanioPagina = 10;
	private Conexion cn;
	 String host = "jdbc:mysql://localhost:3306/";
     String user = "root";
	 String pass = "Admin369";
	 String dbName = "repuestosmaher??profileSQL=true&useSSL=false";


	public RepuestosDaoImpl() 
	{
			
	}

	@Override
	public List<Repuestos> obtenerTodos() 
	{
		cn = new Conexion();
		cn.Open();
		 List<Repuestos> list = new ArrayList<Repuestos>();
		 try 
		 {
			 ResultSet rs= cn.query("Select repuestos.idRepuestos, repuestos.Nombre, repuestos.Descripcion, repuestos.Precio, repuestos.Stock, repuestos.Estado, marcas.idmarcas, marcas.nombre, categorias.idCategorias, categorias.Nombre, proveedores.idProveedores, proveedores.Nombre from repuestos inner join marcas on repuestos.marcas_idmarcas = marcas.idmarcas inner join categorias on repuestos.Categorias_idCategorias = categorias.idCategorias inner join proveedores on repuestos.Proveedores_idProveedores = proveedores.idProveedores where repuestos.Estado = 1");
			 while(rs.next())
			 {
				 Repuestos rep = new Repuestos();
				 rep.setId(rs.getInt("repuestos.idRepuestos"));
				 rep.setNombre(rs.getString("repuestos.Nombre"));
				 rep.setDescripcion(rs.getString("repuestos.Descripcion"));
				 rep.setPrecio(rs.getInt("repuestos.Precio"));
				 rep.setStock(rs.getInt("repuestos.Stock"));
				 rep.setEstado(rs.getString("repuestos.Estado"));
				 
				 Marcas mar = new Marcas();
				 mar.setId(rs.getInt("marcas.idmarcas"));
				 mar.setNombre(rs.getString("marcas.nombre"));
				 rep.setMarca(mar);
				 
				 Categorias cat = new Categorias();
				 cat.setId(rs.getInt("categorias.idCategorias"));
				 cat.setNombre(rs.getString("categorias.Nombre"));
				 rep.setCategoria(cat);
				 
				 Proveedores prov = new Proveedores();
				 prov.setIdProveedores(rs.getInt("proveedores.idProveedores"));
				 prov.setNombre(rs.getString("proveedores.Nombre"));
				 rep.setProveedor(prov);
				 
				 
				 list.add(rep);
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

	public List<Repuestos>obtenerUno(int id) 
	{
		
		cn = new Conexion();
		cn.Open();
		 List<Repuestos> list = new ArrayList<Repuestos>();
		 try 
		 {
			 ResultSet rs= cn.query("Select * from repuestos where idRepuestos="+id);
	
		
			 while(rs.next())
			 {
				 Repuestos rep = new Repuestos();
				 rep.setId(rs.getInt("repuestos.idRepuestos"));
				 rep.setNombre(rs.getString("repuestos.Nombre"));
				 rep.setDescripcion(rs.getString("repuestos.Descripcion"));
				 rep.setPrecio(rs.getInt("repuestos.Precio"));
				 rep.setStock(rs.getInt("repuestos.Stock"));
				 rep.setEstado(rs.getString("repuestos.Estado"));
				 
			
				 
				 
				 list.add(rep);
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
	
	public Repuestos obtenerUnRepuesto(int id)
	{
		String host = "jdbc:mysql://localhost:3306/";
		 String user = "root";
		 String pass = "Admin369";
		String dbName = "test??profileSQL=true&useSSL=false";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Repuestos rep = new Repuestos();
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("Select * from repuestos where idRepuestos = ?");
			miSentencia.setInt(1, id); //Cargo el ID recibido
			ResultSet rs= miSentencia.executeQuery();
			rs.next();
		
			 rep.setId(rs.getInt(1));
			 rep.setNombre(rs.getString(2));
			 rep.setDescripcion(rs.getString(3));
			 rep.setPrecio(rs.getInt(4));
			 rep.setStock(rs.getInt(5));
			 rep.setEstado(rs.getString(6));
		    
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
		return  rep;
	}
	
	
	
	public List<Repuestos>CategoriaProd(int id,int idm, int pagina) 
	{
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<Repuestos> list = new ArrayList<Repuestos>();
		 try 
		 {
			 ResultSet rs= cn.query("Select * from repuestos where Categorias_idCategorias="+id+" and marcas_idmarcas="+idm+" LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
	
		
			 while(rs.next())
			 {
				 Repuestos rep = new Repuestos();
				 rep.setId(rs.getInt("repuestos.idRepuestos"));
				 rep.setNombre(rs.getString("repuestos.Nombre"));
				 rep.setDescripcion(rs.getString("repuestos.Descripcion"));
				 rep.setPrecio(rs.getInt("repuestos.Precio"));
				 rep.setStock(rs.getInt("repuestos.Stock"));
				 rep.setEstado(rs.getString("repuestos.Estado"));
				 
			
				 
				 
				 list.add(rep);
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
	
	public boolean insertar(Repuestos rep) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO repuestos (Nombre,Descripcion,Precio,Stock,Estado,marcas_idmarcas,Categorias_idCategorias,Proveedores_idProveedores) VALUES ('"+rep.getNombre()+"','"+rep.getDescripcion()+"',"+rep.getPrecio()+",'"+rep.getStock()+"','"+rep.getEstado()+"','"+rep.getMarca().getId()+"','"+rep.getCategoria().getId()+"', "+rep.getProveedor().getIdProveedores()+")";
																																							  
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
	public boolean editar(Repuestos rep) {
		boolean estado=true;


		cn = new Conexion();
		cn.Open();	
		//String query = "update repuestos  set Nombre ='"+rep.getNombre()+"',descripcion='"+rep.getDescripcion()+"',precio='"+rep.getPrecio()+"',stock='"+rep.getStock()+"',estado='"+rep.getEstado()+"',marcas_idmarcas='"+rep.getMarca().getId()+"',Categorias_idCategorias='"+rep.getCategoria().getId()+"',Proveedores_idProveedores='"+rep.getProveedor().getIdProveedores()+"' where idRepuestos=1;";
		String query = "update repuestos  set Nombre ='"+rep.getNombre()+"',descripcion='"+rep.getDescripcion()+"',precio='"+rep.getPrecio()+"',stock='"+rep.getStock()+"',estado='"+rep.getEstado()+"',marcas_idmarcas='"+rep.getMarca().getId()+"',Categorias_idCategorias='"+rep.getCategoria().getId()+"',Proveedores_idProveedores='"+rep.getProveedor().getIdProveedores()+"' where idRepuestos="+rep.getId()+";";
		

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
		
		 
		String query = "UPDATE repuestos SET Estado=0 WHERE idRepuestos="+id;
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
	public  Boolean venta(List<Repuestos>_venta,int idd,int idusu, String red) 
	{ String query2="";
	RepuestosDaoImpl reg = new RepuestosDaoImpl();
		 String host = "jdbc:mysql://localhost:3306/";
	     String user = "root";
		 String pass = "Admin369";
		 String dbName = "repuestosmaher??profileSQL=true&useSSL=false";

		 boolean estado=true;
		
		Connection cn = null;
		CallableStatement cst1 = null;
	//	CallableStatement cst2 = null;
		 float total=0;
		System.out.println("estoy por cargar");
		  try
		  {
			 Class.forName("com.mysql.jdbc.Driver");
			 cn = DriverManager.getConnection(host + dbName , user , pass);
			 
			 cst1 = cn.prepareCall("{CALL sp_facturas_insert2(?,?,?,?)}");
		
			
			 for(Repuestos producto : _venta) {
				 total += producto.getPrecio() * producto.getCantidad();
			 }
			 cst1.setInt(1,  idd);
			 cst1.setInt(2,  idusu);
			 cst1.setString(3, red);
			 cst1.setFloat(4,total);
			
			 ResultSet rs = cst1.executeQuery();
			 int id=0;
			 while (rs.next()){
				 id = rs.getInt(1);
				 System.out.println("retorne de id: " + id);
			 }
			 estado=reg.detalleventa(_venta, id);
			 System.out.println("Estadoooo: " + estado);
			 return estado;
		  }
		  catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	  finally{
		  try {
			cst1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		  /*
		  try {
			cst2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	  }
	  }
	
public boolean detalleventa(List<Repuestos>venta,int idventa) {
	RepuestosDaoImpl reg = new RepuestosDaoImpl();
		boolean estado=true;
		String query="";
		cn = new Conexion();
		cn.Open();	
		 for(Repuestos producto  : venta) {
			 reg.restarStock(producto);
			 
			 query = "insert into detalle_facturas(cantidad,precio,repuestos_idRepuestos,facturas_idfacturas)  values('"+producto.getCantidad()+"','"+producto.getPrecio()+"','"+producto.getId()+"','"+idventa+"')";
			
			 
			 
			 
			 estado = cn.execute(query);
			 if(!estado) {
				 cn.close();
				 break;
			 }
		}
		
																																							  
		System.out.println(query);
		return estado;
	}



public Boolean restarStock(Repuestos _producto) 
{
	
	 String host = "jdbc:mysql://localhost:3306/";
     String user = "root";
	 String pass = "Admin369";
	 String dbName = "repuestosmaher??profileSQL=true&useSSL=false";
	Connection cn = null;
	CallableStatement cst = null;
	  try
	  {
		 Class.forName("com.mysql.jdbc.Driver");
		 cn = DriverManager.getConnection(host + dbName , user , pass);
		 cst = cn.prepareCall("{CALL sp_productos_update_stock(?, ?)}");
		 
		 cst.setInt(1, _producto.getId());
		 cst.setInt(2, _producto.getCantidad());
		 int count = cst.executeUpdate();
		 
		 if(count>0)
			 return true;
		 return false;
	  }
	  catch (Exception e) {
		e.printStackTrace();
		return false;
	}
  finally{
	  try {
		cst.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
public List<Repuestos> obtenerPagina(int pagina) {
	cn = new Conexion();
	int offset = (pagina - 1) * tamanioPagina;
	cn.Open();
	 List<Repuestos> list = new ArrayList<Repuestos>();
	 try 
	 {
		 ResultSet rs= cn.query("Select repuestos.idRepuestos, repuestos.Nombre, repuestos.Descripcion, repuestos.Precio, repuestos.Stock, repuestos.Estado, marcas.idmarcas, marcas.nombre, categorias.idCategorias, categorias.Nombre, proveedores.idProveedores, proveedores.Nombre from repuestos inner join marcas on repuestos.marcas_idmarcas = marcas.idmarcas inner join categorias on repuestos.Categorias_idCategorias = categorias.idCategorias inner join proveedores on repuestos.Proveedores_idProveedores = proveedores.idProveedores "
		 		+ " where repuestos.Estado = 1 LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
		 while(rs.next())
		 {
			 Repuestos rep = new Repuestos();
			 rep.setId(rs.getInt("repuestos.idRepuestos"));
			 rep.setNombre(rs.getString("repuestos.Nombre"));
			 rep.setDescripcion(rs.getString("repuestos.Descripcion"));
			 rep.setPrecio(rs.getFloat("repuestos.Precio"));
			 rep.setStock(rs.getInt("repuestos.Stock"));
			 rep.setEstado(rs.getString("repuestos.Estado"));
			 
			 Marcas mar = new Marcas();
			 mar.setId(rs.getInt("marcas.idmarcas"));
			 mar.setNombre(rs.getString("marcas.nombre"));
			 rep.setMarca(mar);
			 
			 Categorias cat = new Categorias();
			 cat.setId(rs.getInt("categorias.idCategorias"));
			 cat.setNombre(rs.getString("categorias.Nombre"));
			 rep.setCategoria(cat);
			 
			 Proveedores prov = new Proveedores();
			 prov.setIdProveedores(rs.getInt("proveedores.idProveedores"));
			 prov.setNombre(rs.getString("proveedores.Nombre"));
			 rep.setProveedor(prov);
			 
			 
			 list.add(rep);
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
public List<Repuestos> CategoriaProdPrcio(int id,int idm, int pagina, float prec1, float prec2) {
	int offset = (pagina - 1) * tamanioPagina;
	float precio2=prec2 +1;
	float precio1=0;
	if(prec1!=0) {precio1=prec1+1;}
	cn = new Conexion();
	cn.Open();
	 List<Repuestos> list = new ArrayList<Repuestos>(); 
	 try 
	 {
		 ResultSet rs= cn.query("Select * from repuestos where Categorias_idCategorias="+id+ " and marcas_idmarcas="+idm+" "
		 		+ " and  precio Between  "+ prec1 +"  And "+ prec2 +"  LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
String q="Select * from repuestos where Categorias_idCategorias="+id+ " and marcas_idmarcas="+idm+" "
 		+ " and  precio Between  "+ prec1 +"  And "+ prec2 +" or precio= "+ prec1 +" or precio= "+ prec2 +"  LIMIT " + tamanioPagina + " OFFSET " + offset + "; ";

	System.out.print(q);
		 while(rs.next())
		 {
			 Repuestos rep = new Repuestos();
			 rep.setId(rs.getInt("repuestos.idRepuestos"));
			 rep.setNombre(rs.getString("repuestos.Nombre"));
			 rep.setDescripcion(rs.getString("repuestos.Descripcion"));
			 rep.setPrecio(rs.getInt("repuestos.Precio"));
			 rep.setStock(rs.getInt("repuestos.Stock"));
			 rep.setEstado(rs.getString("repuestos.Estado"));
			 
		
			 
			 
			 list.add(rep);
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
public Boolean ExisteRepuesto(String nombre) {
	Connection cn = null;
	CallableStatement cst = null;
	  try
	  {
		  
		 Class.forName("com.mysql.jdbc.Driver");
		 cn = DriverManager.getConnection(host + dbName , user , pass);
		 cst = cn.prepareCall("{CALL sp_producto_existe(?,?)}");
		 
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
public int obtenerRepuestoid(String nombre,int model) {
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
							PreparedStatement miSentencia = con.prepareStatement("select * from repuestos where nombre=? and marcas_idmarcas=?");
							miSentencia.setString(1, nombre);
							miSentencia.setInt(1, model); //Cargo el ID recibido
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
public List<Repuestos> obtenerPaginaMOD(int pagina) {
	// TODO Auto-generated method stub
	cn = new Conexion();
	int offset = (pagina - 1) * tamanioPagina;
	cn.Open();
	 List<Repuestos> list = new ArrayList<Repuestos>();
	 try 
	 {
		 ResultSet rs= cn.query("Select repuestos.idRepuestos, repuestos.Nombre, repuestos.Descripcion, repuestos.Precio, repuestos.Stock, repuestos.Estado, marcas.idmarcas, marcas.nombre, categorias.idCategorias, categorias.Nombre, proveedores.idProveedores, proveedores.Nombre from repuestos inner join marcas on repuestos.marcas_idmarcas = marcas.idmarcas inner join categorias on repuestos.Categorias_idCategorias = categorias.idCategorias inner join proveedores on repuestos.Proveedores_idProveedores = proveedores.idProveedores "
		 		+ "  LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
		 while(rs.next())
		 {
			 Repuestos rep = new Repuestos();
			 rep.setId(rs.getInt("repuestos.idRepuestos"));
			 rep.setNombre(rs.getString("repuestos.Nombre"));
			 rep.setDescripcion(rs.getString("repuestos.Descripcion"));
			 rep.setPrecio(rs.getFloat("repuestos.Precio"));
			 rep.setStock(rs.getInt("repuestos.Stock"));
			 rep.setEstado(rs.getString("repuestos.Estado"));
			 
			 Marcas mar = new Marcas();
			 mar.setId(rs.getInt("marcas.idmarcas"));
			 mar.setNombre(rs.getString("marcas.nombre"));
			 rep.setMarca(mar);
			 
			 Categorias cat = new Categorias();
			 cat.setId(rs.getInt("categorias.idCategorias"));
			 cat.setNombre(rs.getString("categorias.Nombre"));
			 rep.setCategoria(cat);
			 
			 Proveedores prov = new Proveedores();
			 prov.setIdProveedores(rs.getInt("proveedores.idProveedores"));
			 prov.setNombre(rs.getString("proveedores.Nombre"));
			 rep.setProveedor(prov);
			 
			 
			 list.add(rep);
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
public int obtenerRepuestoidMODELO(String nombre, int model) {
	// TODO Auto-generated method stub
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
								PreparedStatement miSentencia = con.prepareStatement("select repuestos.marcas_idmarcas from repuestos where nombre=? and marcas_idmarcas=?");
								miSentencia.setString(1, nombre);
								miSentencia.setInt(2, model); //Cargo el ID recibido
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

	}
	


