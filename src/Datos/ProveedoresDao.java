package Datos;

import java.util.List;


import Entidad.Proveedores;

public interface ProveedoresDao {
	
	public List<Proveedores> obtenerTodos();
	public List<Proveedores>obtenerPagina(int pagina);
	public List<Proveedores>obtenerPaginaMOD(int pagina);
	public Proveedores obtenerUno(int id);
	public boolean insertar(Proveedores proveedore);
	public boolean editar(Proveedores proveedore);
	public boolean borrar(int id);
	public Boolean ExisteProveedor(String nombre);
	public int obtenerProveedorid(String nombre);

}
