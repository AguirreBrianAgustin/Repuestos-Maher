package negocioImlp;

import java.util.ArrayList;
import java.util.List;

import Datos.RepuestosDao;
import DatosImpl.RepuestosDaoImpl;
import Entidad.Categorias;
import Entidad.Repuestos;
import Negocio.RepuestosNeg;


public class RepuestosNegImpl implements RepuestosNeg {

private RepuestosDao repDao = new RepuestosDaoImpl();
	
	public RepuestosNegImpl() {

	}

	@Override
	public ArrayList<Repuestos> ListarRepuestos() {
		return (ArrayList<Repuestos>) repDao.obtenerTodos();
	}
	
	@Override
	public  ArrayList<Repuestos> obtenerUno(int id) {
		return (ArrayList<Repuestos>)  repDao.obtenerUno(id);
	}
	
	public  ArrayList<Repuestos> CategoriaProd(int id,int idm,int pagina) {
		return (ArrayList<Repuestos>)  repDao.CategoriaProd(id,idm,pagina);
	}

	@Override
	public boolean insertar(Repuestos rep) {
		return repDao.insertar(rep);
	}
	
	
	@Override
	public boolean venta(List<Repuestos>venta,int id,int idusu, String rad) {
		return repDao.venta(venta,id,idusu,rad);
	}
	
	
	@Override
	public boolean editar(Repuestos rep) {
		return repDao.editar(rep);
	}

	@Override
	public boolean borrar(int id) {
		return repDao.borrar(id);
	}
	
	public Repuestos obtenerUnRepuesto(int id)
	{
		return repDao.obtenerUnRepuesto(id);
	}

	@Override
	public ArrayList<Repuestos>  ListarRepuestos(int pagina) {
		return (ArrayList<Repuestos>) repDao.obtenerPagina(pagina);
	}

	@Override
	public List<Repuestos> CategoriaProdPrcio(int id,int idm, int pagina, float prec1, float prec2) {
		// TODO Auto-generated method stub
		return (ArrayList<Repuestos>) repDao.CategoriaProdPrcio(id,idm, pagina, prec1, prec2);
	}

	@Override
	public Boolean ExisteRepuesto(String nombre) {
		// TODO Auto-generated method stub
		return repDao.ExisteRepuesto(nombre);
	}

	@Override
	public int obteneRepuestoid(String nombre,int model) {
		// TODO Auto-generated method stub
		return repDao.obtenerRepuestoid(nombre,model);
	}

	@Override
	public Object ListarRepuestosMOD(int pagina) {
		// TODO Auto-generated method stub
		return (ArrayList<Repuestos>) repDao.obtenerPaginaMOD(pagina);
	}

	@Override
	public int obtenerRepuestoidMODELO(String nombre,int model) {
		// TODO Auto-generated method stub
		return repDao.obtenerRepuestoidMODELO(nombre,model);
	}
}
