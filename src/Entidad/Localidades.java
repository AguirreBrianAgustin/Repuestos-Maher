package Entidad;

public class Localidades {

	private int id;
	private String nombre;
	private String idprov;
	

	
	public Localidades() {}

	public Localidades(int id, String nombre,String idprov){
		super();
		this.id=id;
		this.nombre=nombre;
		this.idprov=idprov;
	
	}

	@Override
	public String toString() {
		return "Localidades [id=" + id + ", nombre=" + nombre + ", idprov=" + idprov + "]";
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

	public String getIdprov() {
		return idprov;
	}

	public void setIdprov(String idprov) {
		this.idprov = idprov;
	}
	

	
}
