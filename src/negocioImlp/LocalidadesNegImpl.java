package negocioImlp;

import java.util.ArrayList;

import Datos.ClientesDao;
import Datos.LocalidadesDao;
import DatosImpl.ClientesDaoImpl;
import DatosImpl.LocalidadesDaoImpl;
import Entidad.Clientes;
import Entidad.Localidades;
import Negocio.LocalidadesNeg;


public class LocalidadesNegImpl  implements LocalidadesNeg{

	

		 
		private LocalidadesDao localDao =   new LocalidadesDaoImpl();


		public LocalidadesNegImpl() {

		}

		public  LocalidadesNegImpl(LocalidadesDao local) {
			
			this.localDao =  local;
		}

		@Override
		public ArrayList<Localidades> ListarLocalidades() {
			return (ArrayList<Localidades>) localDao.obtenerTodos();
		}

		@Override
		public Localidades obtenerUno(int id) {
			return localDao.obtenerUno(id);
		}

		@Override
		public boolean insertar(Localidades mar) {
			return localDao.insertar(mar);
		}

		@Override
		public boolean editar(Localidades mar) {
			return localDao.editar(mar);
		}

		@Override
		public boolean borrar(int id) {
			return localDao.borrar(id);
		}
	
}
