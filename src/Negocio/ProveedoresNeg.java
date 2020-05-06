package Negocio;

import java.util.ArrayList;

import Entidad.Proveedores;

public interface ProveedoresNeg {
	public ArrayList<Proveedores> ListarProveedores();
	public Proveedores obtenerUno(int id);
	public boolean insertar(Proveedores pro);
	public boolean editar(Proveedores pro);
	public boolean borrar(int id);
	public Object ListarProveedores(int pagina);
	public Object ListarProveedoresMOD(int pagina);
	public Boolean ExisteProv(String nombre);
	public int obteneprovid(String nombre);

}
