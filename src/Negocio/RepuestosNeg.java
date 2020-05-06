package Negocio;

import java.util.ArrayList;
import java.util.List;

import Entidad.Repuestos;

public interface RepuestosNeg {
	public ArrayList<Repuestos> ListarRepuestos();
	public ArrayList<Repuestos> obtenerUno(int id);
	public List<Repuestos>CategoriaProd(int id,int idm,int pagina);
	public List<Repuestos>CategoriaProdPrcio(int id,int idm,int pagina, float prec1,float prec2);
	public boolean insertar(Repuestos rep);
	public boolean editar(Repuestos rep);
	public boolean borrar(int id);
	public Repuestos obtenerUnRepuesto(int id);
	public Object ListarRepuestos(int pagina);
	public Object ListarRepuestosMOD(int pagina);
	 public boolean venta(List<Repuestos>venta,int id,int idusu,String red);
	 public Boolean ExisteRepuesto(String nombre);
	 public int obteneRepuestoid(String nombre, int model);
	
	 public int obtenerRepuestoidMODELO(String nombre,int model);
}