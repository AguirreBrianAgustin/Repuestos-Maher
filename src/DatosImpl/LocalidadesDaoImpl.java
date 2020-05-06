package DatosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.LocalidadesDao;
import Entidad.Localidades;



public class LocalidadesDaoImpl implements LocalidadesDao{
	
	private Conexion cn;

	public LocalidadesDaoImpl() 
	{
		
	}
	
	@Override
	public List<Localidades> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Localidades> list = new ArrayList<Localidades>();
		 try
		 {
			 ResultSet rs= cn.query("select localidades.idLocalidades, localidades.Nombre, localidades.provincias_idProvincias from localidades;");
			 while(rs.next())
			 {
				 Localidades loc = new Localidades();
				 loc.setId(rs.getInt("localidades.idLocalidades"));
				 loc.setNombre(rs.getString("localidades.Nombre"));
				 loc.setIdprov(rs.getString("localidades.provincias_idProvincias"));
				 list.add(loc);
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
	public Localidades obtenerUno(int id) {
		cn = new Conexion();
		cn.Open();
		Localidades mar = new Localidades();
		 try
		 {
			 ResultSet rs= cn.query("Select * from marcas");
			 rs.next();
			 mar.setId(rs.getInt("marcas.idmarcas"));
			 mar.setNombre(rs.getString("marcas.nombre"));
			 
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
	public boolean insertar(Localidades mar) {
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
	public boolean editar(Localidades mar) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE marcas SET nombre='"+mar.getNombre()+"', estado="+" WHERE idmarcas="+mar.getId();
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

}
