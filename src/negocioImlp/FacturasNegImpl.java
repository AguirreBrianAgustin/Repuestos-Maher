package negocioImlp;

import java.util.ArrayList;
import java.util.List;

import Datos.FacturasDao;

import DatosImpl.FacturasDaoImpl;
import Entidad.Factura;
import Negocio.FacturasNeg;

public class FacturasNegImpl implements FacturasNeg{
	
	
	
	
	 
	private FacturasDao localDao =   new FacturasDaoImpl();


	public FacturasNegImpl() {

	}

	public FacturasNegImpl(FacturasDao local) {
		
		this.localDao =  local;
	}

	@Override
	public List<Factura> obtenerTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Factura>) localDao.obtenerTodos();
	}

	@Override
	public List<Factura> obtenerTodosXprecio(float num1, float num2,int pagina) {
		// TODO Auto-generated method stub
		return (ArrayList<Factura>) localDao.obtenerTodosXprecio(num1,num2,pagina);
	}

	@Override
	public List<Factura> obtenerTodosXFecha(String num1, String num2,int pagina) {
		return (ArrayList<Factura>) localDao.obtenerTodosXFecha(num1,num2,pagina);
	}

	@Override
	public List<Factura> ListarFactura(int pagina) {
		return (ArrayList<Factura>) localDao.obtenerPagina(pagina);
	}

	
	
	
}
