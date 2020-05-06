package negocioImlp;

import java.util.ArrayList;

import Datos.ProveedoresDao;
import DatosImpl.ProveedoresDaoImpl;
import Entidad.Categorias;
import Entidad.Proveedores;
import Negocio.ProveedoresNeg;


public class ProveedoresNegImpl implements ProveedoresNeg {
	
	private ProveedoresDao proDao = new ProveedoresDaoImpl();

	public ProveedoresNegImpl(){
		
	}
	
	public ProveedoresNegImpl(ProveedoresDao proDao) {
		this.proDao = proDao;
	}

	@Override
	public ArrayList<Proveedores> ListarProveedores() {
		return (ArrayList<Proveedores>) proDao.obtenerTodos();
	}

	@Override
	public Proveedores obtenerUno(int id) {
		return proDao.obtenerUno(id);
	}

	@Override
	public boolean insertar(Proveedores pro) {
		return proDao.insertar(pro);
	}
	

	@Override
	public boolean editar(Proveedores pro) {
		return proDao.editar(pro);
	}

	@Override
	public boolean borrar(int id) {
		return proDao.borrar(id);
	}

	@Override
	public  ArrayList<Proveedores> ListarProveedores(int pagina) {
		// TODO Auto-generated method stub
		return (ArrayList<Proveedores>)  proDao.obtenerPagina(pagina);
	}

	@Override
	public Boolean ExisteProv(String nombre) {
		// TODO Auto-generated method stub
		return proDao.ExisteProveedor(nombre);
	}

	@Override
	public int obteneprovid(String nombre) {
		// TODO Auto-generated method stub
		return proDao.obtenerProveedorid(nombre);
	}

	@Override
	public Object ListarProveedoresMOD(int pagina) {
		// TODO Auto-generated method stub
		return proDao.obtenerPaginaMOD(pagina);
	}

}
