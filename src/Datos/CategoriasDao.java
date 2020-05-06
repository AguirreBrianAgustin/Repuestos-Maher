package Datos;

import java.util.List;

import Entidad.Categorias;
import Entidad.Clientes;

	public interface  CategoriasDao  {

		public List<Categorias> obtenerTodos();
		public List<Categorias>obtenerPagina(int pagina);
		public List<Categorias>obtenerPaginaMOD(int pagina);
		public Categorias obtenerUno(int id);
		public boolean insertar(Categorias marca);
		public boolean editar(Categorias marca);
		public boolean borrar(int id);
		public Boolean ExisteCategoria(String nombre);
		public int obtenerCategoriaid(String nombre);
		
	}

