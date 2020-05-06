package DatosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.FacturasDao;
import Entidad.Factura;
import Entidad.Localidades;

public class FacturasDaoImpl  implements FacturasDao {
	private Conexion cn;
	private int tamanioPagina = 10;
	public FacturasDaoImpl() {}

	@Override
	public List<Factura> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Factura> list = new ArrayList<Factura>();
		 try
		 {
			 ResultSet rs= cn.query("select facturas.idfacturas,facturas.fecha,facturas.pago,facturas.Total,facturas.clientes_idclientes,facturas.usuario_idusuario from facturas;");
			 while(rs.next())
			 {
				 Factura fac = new Factura();
				 fac.setId(rs.getInt("facturas.idfacturas"));
				 fac.setFecha(rs.getTimestamp("facturas.fecha"));
				 fac.setPago(rs.getString("facturas.pago"));
				 fac.setTotal(rs.getFloat("facturas.Total"));
				 fac.setIdCliente(rs.getInt("facturas.clientes_idclientes"));
				 fac.setIdusuario(rs.getInt("facturas.usuario_idusuario"));
				 list.add(fac);
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
	public List<Factura> obtenerTodosXprecio(float num1, float num2,int pagina) {
		cn = new Conexion();
		int offset = (pagina - 1) * tamanioPagina;
		cn.Open();
		 List<Factura> list = new ArrayList<Factura>();
		 try
		 {
			 ResultSet rs= cn.query("select facturas.idfacturas,facturas.fecha,facturas.pago,facturas.Total,facturas.clientes_idclientes,facturas.usuario_idusuario" + 
			 		" from facturas WHERE total Between "+ num1 +"  And "+ num2 +" or total= "+ num1 +" or total= "+ num2 +" LIMIT " + tamanioPagina + " OFFSET " + offset + ";");
			 String consu="select facturas.idfacturas,facturas.fecha,facturas.pago,facturas.Total,facturas.clientes_idclientes,facturas.usuario_idusuario" + 
				 		" from facturas WHERE total Between "+ num1 +"  And "+ num2 +" or "+ num1 +" or "+ num2 +" LIMIT " + tamanioPagina + " OFFSET " + offset + ";";
			 System.out.print(consu);
			 while(rs.next())
			 {
				 Factura fac = new Factura();
				 fac.setId(rs.getInt("facturas.idfacturas"));
				 fac.setFecha(rs.getTimestamp("facturas.fecha"));
				 fac.setPago(rs.getString("facturas.pago"));
				 fac.setTotal(rs.getFloat("facturas.Total"));
				 fac.setIdCliente(rs.getInt("facturas.clientes_idclientes"));
				 fac.setIdusuario(rs.getInt("facturas.usuario_idusuario"));
				 list.add(fac);
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
	public List<Factura> obtenerTodosXFecha(String num1, String num2,int pagina) {
		// TODO Auto-generated method stub
		
		String[] parts = num2.split("-");
		String part1 = parts[0]; // 123
		String part2 = parts[1]; // 654321
		String part3 = parts[1]; // 654321
		int sum= Integer.parseInt(part3)+ 1;
		String num22= part1+"-"+part2+"-"+sum;
		
		String[] partss = num1.split("-");
		String part11 = partss[0]; // 123
		String part22 = partss[1]; // 654321
		String part33 = partss[1]; // 654321
		int summ= Integer.parseInt(part33)- 1;
		String num11= part11+"-"+part22+"-"+summ;
		cn = new Conexion();
		int offset = (pagina - 1) * tamanioPagina;
		cn.Open();
		 List<Factura> list = new ArrayList<Factura>();
		 try
		 {
			 ResultSet rs= cn.query("select facturas.idfacturas,facturas.fecha,facturas.pago,facturas.Total,facturas.clientes_idclientes,facturas.usuario_idusuario" + 
			 		" from facturas WHERE fecha Between '"+ num1+"'  And '"+ num2 +"'  LIMIT " + tamanioPagina + " OFFSET " + offset + ";");
			 String consu= "select facturas.idfacturas,facturas.fecha,facturas.pago,facturas.Total,facturas.clientes_idclientes,facturas.usuario_idusuario" + 
				 		" from facturas WHERE fecha Between '"+ num1+"'  And '"+ num22 +"'  or  fecha='"+ num1 +"'  or  fecha='"+ num22 +"' LIMIT " + tamanioPagina + " OFFSET " + offset + ";";
			 System.out.print(consu);
			 while(rs.next())
			 {
				 Factura fac = new Factura();
				 fac.setId(rs.getInt("facturas.idfacturas"));
				 fac.setFecha(rs.getTimestamp("facturas.fecha"));
				 fac.setPago(rs.getString("facturas.pago"));
				 fac.setTotal(rs.getFloat("facturas.Total"));
				 fac.setIdCliente(rs.getInt("facturas.clientes_idclientes"));
				 fac.setIdusuario(rs.getInt("facturas.usuario_idusuario"));
				 list.add(fac);
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
	public List<Factura> obtenerPagina(int pagina) {
		cn = new Conexion();
		int offset = (pagina - 1) * tamanioPagina;
		cn.Open();
		 List<Factura> list = new ArrayList<Factura>();
		 try
		 {
			 ResultSet rs= cn.query("select facturas.idfacturas,facturas.fecha,facturas.pago,facturas.Total,facturas.clientes_idclientes,facturas.usuario_idusuario"
			 		+ " from facturas LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 Factura fac = new Factura();
				 fac.setId(rs.getInt("facturas.idfacturas"));
				 fac.setFecha(rs.getTimestamp("facturas.fecha"));
				 fac.setPago(rs.getString("facturas.pago"));
				 fac.setTotal(rs.getFloat("facturas.Total"));
				 fac.setIdCliente(rs.getInt("facturas.clientes_idclientes"));
				 fac.setIdusuario(rs.getInt("facturas.usuario_idusuario"));
				 list.add(fac);
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
