package Datos;

import java.util.List;

import Entidad.Localidades;



public interface LocalidadesDao {

	public List<Localidades> obtenerTodos();
	public Localidades obtenerUno(int id);
	public boolean insertar(Localidades localidades);
	public boolean editar(Localidades localidades);
	public boolean borrar(int id);	
	
}
