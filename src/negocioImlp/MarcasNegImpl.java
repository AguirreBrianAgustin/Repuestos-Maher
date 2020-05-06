package negocioImlp;

import java.util.ArrayList;

import Datos.MarcasDao;
import DatosImpl.MarcasDaoImpl;
import Entidad.Categorias;
import Entidad.Marcas;
import Negocio.MarcasNeg;


public class MarcasNegImpl implements MarcasNeg {

private MarcasDao marDao = new MarcasDaoImpl();


public MarcasNegImpl() {

}

public MarcasNegImpl(MarcasDao marDao) {
	
	this.marDao = marDao;
}

@Override
public ArrayList<Marcas> ListarMarcas() {
	return (ArrayList<Marcas>) marDao.obtenerTodos();
}

@Override
public Marcas obtenerUno(int id) {
	return marDao.obtenerUno(id);
}

@Override
public boolean insertar(Marcas mar) {
	return marDao.insertar(mar);
}

@Override
public boolean editar(Marcas mar) {
	return marDao.editar(mar);
}

@Override
public boolean borrar(int id) {
	return marDao.borrar(id);
}

public boolean validar(String nombre) {
	return marDao.validar(nombre);
}

@Override
public ArrayList<Marcas> ListarMarcas(int pagina) {
	// TODO Auto-generated method stub
	return (ArrayList<Marcas>) marDao.obtenerPagina(pagina);
}

@Override
public Boolean ExisteMarca(String nombre) {
	// TODO Auto-generated method stub
	return marDao.ExisteMarca(nombre);
}

@Override
public int obteneMarcaid(String nombre) {
	// TODO Auto-generated method stub
	return marDao.obtenerMarcaid(nombre);
}

@Override
public Object ListarMarcasMOD(int pagina) {
	// TODO Auto-generated method stub
	return (ArrayList<Marcas>) marDao.obtenerPaginaMOD(pagina);
}


	
}
