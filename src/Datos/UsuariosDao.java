package Datos;

import java.util.List;

import Entidad.Usuarios;




public interface UsuariosDao {
	public List<Usuarios> obtenerUno(String usuario,String contraseña);
	public List<Usuarios> obtenerTodosXPermiso0(int pagina);
	public boolean editarElim(int id,String dato);
	public boolean editarUsuario(int id,String contraseña);
	public boolean insertar(Usuarios usuarios);
	public Boolean ExisteUsuario(String nombre);
}
