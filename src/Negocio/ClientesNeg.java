package Negocio;

import java.util.ArrayList;

import Entidad.Clientes;

public interface ClientesNeg {

	public ArrayList<Clientes> obtenerUno(int id);
	public boolean insertar(Clientes clie);
	public boolean editar(Clientes clie);
	public boolean borrar(int id);
	public Object ListarClientes(int pagina);
	public Object ListarClientesMOD(int pagina);
	public Boolean ExisteCliente(int dni);
	
}
