package Entidad;

public class Usuarios {
	private int idUsuario;
	private String nombre;
	private String permiso;
	private String contrasena;
	private String estado;
	

	
	public Usuarios() {}
	
	public Usuarios(int idUsuario,String nombre, String permiso,String estado,String contrasena) {
		
		this.idUsuario=idUsuario;
		this.contrasena=contrasena;
		this.nombre=nombre;
		this.permiso=permiso;
		this.estado=estado;
	}

	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", nombre=" + nombre + ", permiso=" + permiso + ", contrasena="
				+ contrasena + ", estado=" + estado + "]";
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
