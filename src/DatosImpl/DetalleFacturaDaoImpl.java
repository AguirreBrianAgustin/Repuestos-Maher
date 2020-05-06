package DatosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.DetalleFacturaDao;
import Entidad.DetalleFactura;
import Entidad.Factura;

public class DetalleFacturaDaoImpl implements DetalleFacturaDao{
	private int tamanioPagina = 10;
	
	private Conexion cn;
	public DetalleFacturaDaoImpl() {}
	
	@Override
	public List<DetalleFactura> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<DetalleFactura> list = new ArrayList<DetalleFactura>();
		 try
		 {
			 ResultSet rs= cn.query("select detalle_facturas.iddetalle_facturas,detalle_facturas.cantidad,detalle_facturas.precio,detalle_facturas.repuestos_idRepuestos,detalle_facturas.facturas_idfacturas from detalle_facturas;");
			 while(rs.next())
			 {
				 DetalleFactura fac = new DetalleFactura();
				 fac. setIddetalle(rs.getInt("detalle_facturas.iddetalle_facturas"));
				 fac.setCantidad(rs.getInt("detalle_facturas.cantidad"));
				 fac.setPrecio(rs.getFloat("detalle_facturas.precio"));
				 fac.setIdrepuestos(rs.getInt("detalle_facturas.repuestos_idRepuestos"));
				 fac.setIdfacturas(rs.getInt("detalle_facturas.facturas_idfacturas"));
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
	public List<DetalleFactura> obtenerPagina(int pagina) {
		// TODO Auto-generated method stub
		int offset = (pagina - 1) * tamanioPagina;
		cn = new Conexion();
		cn.Open();
		 List<DetalleFactura> list = new ArrayList<DetalleFactura>();
		 try
		 {
			 ResultSet rs= cn.query("select detalle_facturas.iddetalle_facturas,detalle_facturas.cantidad,detalle_facturas.precio,detalle_facturas.repuestos_idRepuestos,detalle_facturas.facturas_idfacturas "
			 		+ " from detalle_facturas LIMIT " + tamanioPagina + " OFFSET " + offset + "; ");
			 while(rs.next())
			 {
				 DetalleFactura fac = new DetalleFactura();
				 fac. setIddetalle(rs.getInt("detalle_facturas.iddetalle_facturas"));
				 fac.setCantidad(rs.getInt("detalle_facturas.cantidad"));
				 fac.setPrecio(rs.getFloat("detalle_facturas.precio"));
				 fac.setIdrepuestos(rs.getInt("detalle_facturas.repuestos_idRepuestos"));
				 fac.setIdfacturas(rs.getInt("detalle_facturas.facturas_idfacturas"));
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
