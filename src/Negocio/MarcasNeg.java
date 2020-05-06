package Negocio;

import java.util.ArrayList;

import Entidad.Marcas;

public interface MarcasNeg {
	public ArrayList<Marcas> ListarMarcas();
	public Marcas obtenerUno(int id);
	public boolean insertar(Marcas mar);
	public boolean editar(Marcas mar);
	public boolean borrar(int id);
	public boolean validar(String nombre);
	public Object ListarMarcas(int pagina);
	public Object ListarMarcasMOD(int pagina);
	public Boolean ExisteMarca(String nombre);
	public int obteneMarcaid(String nombre);
}