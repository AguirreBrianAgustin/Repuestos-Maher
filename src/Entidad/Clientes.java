package Entidad;

public class Clientes {
	private int id;
	private String nombre;
	private String telefono;
	private String direccion;
	private String mail;
	private int dni;
	private String estado;
	private int idLocalidades;
	
	public Clientes() {}

	public Clientes(int id, String nombre,String telefono,String direccion,String mail, int dni, String estado,int idLocalidades) {
		super();
		this.id=id;
		this.nombre=nombre;
		this.direccion=direccion;
		this.mail=mail;
		this.dni=dni;
		this.telefono=telefono;
		this.estado=estado;
		this.idLocalidades=idLocalidades;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", mail=" + mail + ", dni=" + dni + ", estado=" + estado + ", idLocalidades=" + idLocalidades + "]";
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdLocalidades() {
		return idLocalidades;
	}

	public void setIdLocalidades(int idLocalidades) {
		this.idLocalidades = idLocalidades;
	}

	

	
	
	
}