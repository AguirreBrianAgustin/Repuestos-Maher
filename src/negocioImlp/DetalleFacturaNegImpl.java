package negocioImlp;

import java.util.ArrayList;
import java.util.List;


import Datos.DetalleFacturaDao;

import DatosImpl.DetalleFacturaDaoImpl;
import Entidad.Clientes;
import Entidad.DetalleFactura;
import Negocio.DetalleFacturaNeg;

public class DetalleFacturaNegImpl implements DetalleFacturaNeg {

	private DetalleFacturaDao detalleDao =   new DetalleFacturaDaoImpl();
	
public	DetalleFacturaNegImpl() {
	
	
}
public  DetalleFacturaNegImpl(DetalleFacturaDao catDao) {
	
	this.detalleDao =  catDao;
}

@Override
public List<DetalleFactura> obtenerTodos() {
	// TODO Auto-generated method stub
	return (ArrayList<DetalleFactura>) detalleDao.obtenerTodos();
	
}
@Override
public List<DetalleFactura>  ListarDetalleFactura(int pagina) {
	// TODO Auto-generated method stub
	return (ArrayList<DetalleFactura>) detalleDao.obtenerPagina(pagina);
}
}
