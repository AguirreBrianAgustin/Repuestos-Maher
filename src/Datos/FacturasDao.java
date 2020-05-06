package Datos;

import java.util.List;

import Entidad.Factura;



public interface FacturasDao {
	public List<Factura> obtenerTodos();
	public List<Factura>obtenerPagina(int pagina);
	public List<Factura> obtenerTodosXprecio(float num1, float num2,int pagina);
	public List<Factura> obtenerTodosXFecha(String num1, String num2,int pagina);
}
