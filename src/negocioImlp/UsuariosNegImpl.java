package negocioImlp;

import java.util.ArrayList;
import java.util.List;


import Datos.UsuariosDao;

import DatosImpl.UsuariosDaoImpl;
import Entidad.Usuarios;
import Negocio.UsuariosNeg;

public class UsuariosNegImpl implements UsuariosNeg{

	private UsuariosDao UsuDao =  new UsuariosDaoImpl();


	public UsuariosNegImpl() {

	}
	
	@Override
	public List<Usuarios> obtenerUno(String usuario, String contraseña) {
		return (ArrayList<Usuarios>) UsuDao.obtenerUno(usuario, contraseña);
	}

	@Override
	public List<Usuarios> obtenerTodosXPermiso0(int pagina) {
		// TODO Auto-generated method stub
		return (ArrayList<Usuarios>) UsuDao.obtenerTodosXPermiso0(pagina);
	}

	@Override
	public boolean editarElim(int id, String dato) {
		// TODO Auto-generated method stub
		return UsuDao.editarElim(id, dato);
	}

	@Override
	public boolean editarUsuario(int id, String contraseña) {
		// TODO Auto-generated method stub
		return UsuDao.editarUsuario(id, contraseña);
	}

	@Override
	public boolean insertar(Usuarios usuarios) {
		// TODO Auto-generated method stub
		return UsuDao.insertar(usuarios);
	}

	@Override
	public Boolean ExisteUsuario(String nombre) {
		// TODO Auto-generated method stub
		return UsuDao.ExisteUsuario(nombre);
	}

}
