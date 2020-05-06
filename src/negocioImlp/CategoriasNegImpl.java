package negocioImlp;

import java.util.ArrayList;
import java.util.List;

import Datos.CategoriasDao;
import DatosImpl.CategoriasDaoIml;
import Entidad.Categorias;
import Entidad.DetalleFactura;
import Negocio.CategoriasNeg;



public class CategoriasNegImpl implements CategoriasNeg {

private CategoriasDao catDao =  new CategoriasDaoIml();


public CategoriasNegImpl() {

}

public  CategoriasNegImpl(CategoriasDao marDao) {
	
	this.catDao = marDao;
}

@Override
public ArrayList<Categorias> ListarCategorias(int pagina) {
	return (ArrayList<Categorias>) catDao.obtenerPagina(pagina);
}


@Override
public Categorias obtenerUno(int id) {
	return catDao.obtenerUno(id);
}

@Override
public boolean insertar(Categorias mar) {
	return catDao.insertar(mar);
}

@Override
public boolean editar(Categorias mar) {
	return catDao.editar(mar);
}

@Override
public boolean borrar(int id) {
	return catDao.borrar(id);
}

@Override
public List<Categorias> obtenerTodos() {
	// TODO Auto-generated method stub
	return (ArrayList<Categorias>) catDao.obtenerTodos();
}

@Override
public Boolean ExisteCategoria(String nombre) {
	// TODO Auto-generated method stub
	return catDao.ExisteCategoria(nombre);
}

@Override
public int obtenerCategoriaid(String nombre) {
	// TODO Auto-generated method stub
	return catDao.obtenerCategoriaid(nombre);
}

@Override
public Object ListarCategoriasMOD(int pagina) {
	// TODO Auto-generated method stub
	return (ArrayList<Categorias>) catDao.obtenerPaginaMOD(pagina);
}




}
