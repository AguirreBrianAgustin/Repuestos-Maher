package Negocio;

import java.util.ArrayList;
import java.util.List;

import Entidad.Categorias;

public interface CategoriasNeg {

	//public ArrayList<Categorias> ListarCategorias(int pagina);
	public List<Categorias> obtenerTodos();
		public Categorias obtenerUno(int id);
	public boolean insertar(Categorias mar);
	public boolean editar(Categorias mar);
	public boolean borrar(int id);
	public Object ListarCategorias(int pagina);
	public Object ListarCategoriasMOD(int pagina);
	public Boolean ExisteCategoria(String nombre);
	public int obtenerCategoriaid(String nombre);

	
}
