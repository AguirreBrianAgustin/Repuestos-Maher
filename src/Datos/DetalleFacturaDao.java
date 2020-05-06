package Datos;

import java.util.List;

import Entidad.DetalleFactura;
import Entidad.Factura;



public interface DetalleFacturaDao {
	public List<DetalleFactura> obtenerTodos();
	public List<DetalleFactura>obtenerPagina(int pagina);
}
