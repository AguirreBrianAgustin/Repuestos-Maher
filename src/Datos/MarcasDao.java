package Datos;

import java.util.List;

import Entidad.Marcas;

public interface MarcasDao {

	public List<Marcas> obtenerTodos();
	public List<Marcas>obtenerPagina(int pagina);
	public List<Marcas>obtenerPaginaMOD(int pagina);
	public Marcas obtenerUno(int id);
	public boolean insertar(Marcas marca);
	public boolean editar(Marcas marca);
	public boolean borrar(int id);
	public boolean validar(String nombre);
	public boolean validarx2(String nombre);
	public Boolean ExisteMarca(String nombre);
	public int obtenerMarcaid(String nombre);
	
}
