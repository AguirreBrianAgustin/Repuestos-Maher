package Datos;

import java.util.List;

import Entidad.Clientes;


public interface ClientesDao {

	public List<Clientes>obtenerTodos();
	public List<Clientes>obtenerPagina(int pagina);
	public List<Clientes>obtenerPaginaMOD(int pagina);
	public List<Clientes> obtenerUno(int id);
	public boolean insertar(Clientes clientes);
	public boolean editar(Clientes clientes);
	public boolean borrar(int id);	
	public Boolean ExisteCliente(int dni);

}
