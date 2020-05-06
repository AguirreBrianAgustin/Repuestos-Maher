package Entidad;

public class Proveedores {

	private int idProveedores;
	private String Nombre;
	private String Telefono;
	private String Estado;
	
	public Proveedores() {}

	public Proveedores(int idProveedores, String nombre, String telefono, String estado) {
		super();
		this.idProveedores = idProveedores;
		this.Nombre = nombre;
		this.Telefono = telefono;
		this.Estado = estado;
	}
	
	public Proveedores(int idProveedores) {
		super();
		this.idProveedores = idProveedores;
	}

	public int getIdProveedores() {
		return idProveedores;
	}

	public void setIdProveedores(int idProveedores) {
		this.idProveedores = idProveedores;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		this.Estado = estado;
	}

	@Override
	public String toString() {
		return "Proveedores [idProveedores=" + idProveedores + ", Nombre=" + Nombre + ", Telefono=" + Telefono
				+ ", Estado=" + Estado + "]";
	}
	
}