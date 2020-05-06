package Entidad;

public class Categorias {
	private int id;
	private String nombre;
	private String estado;
	
	public Categorias() {}

	public Categorias(int id, String nombre, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}
	public Categorias(int id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
