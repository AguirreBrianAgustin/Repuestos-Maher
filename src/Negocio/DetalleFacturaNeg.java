package Negocio;

import java.util.List;

import Entidad.DetalleFactura;

public interface DetalleFacturaNeg {
	public List<DetalleFactura> obtenerTodos();
	public Object ListarDetalleFactura(int pagina);
}
