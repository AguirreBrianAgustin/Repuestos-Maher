package Datos;

import java.util.ArrayList;
import java.util.List;


import Entidad.Repuestos;

public interface RepuestosDao {
	public List<Repuestos> obtenerTodos();
	
	public List<Repuestos>obtenerUno(int id);
	public List<Repuestos>obtenerPagina(int pagina);
	public List<Repuestos>obtenerPaginaMOD(int pagina);
	public List<Repuestos>CategoriaProd(int id,int idm,int pagina);
	public List<Repuestos>CategoriaProdPrcio(int id,int idmar,int pagina, float prec1,float prec2);
	public boolean insertar(Repuestos rep);
	public boolean editar(Repuestos rep);
	public boolean borrar(int id);
    public Repuestos obtenerUnRepuesto(int id);
    public  Boolean venta(List<Repuestos>venta,int id,int idusu, String rad);
    public boolean detalleventa(List<Repuestos>venta,int idventa);
    public Boolean restarStock(Repuestos _producto);
    public Boolean ExisteRepuesto(String nombre);
	public int obtenerRepuestoid(String nombre, int model);
	public int obtenerRepuestoidMODELO(String nombre, int model);
}
