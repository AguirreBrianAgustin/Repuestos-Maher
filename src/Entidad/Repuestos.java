package Entidad;


public class Repuestos {
	
	private int id;
	private String nombre;
	private String descripcion;
	private float precio;
	private int stock;
	private int cantidad;
	private String estado;
	private Marcas marca;
	private Categorias categoria;
	private Proveedores proveedor;
	
	public Repuestos() {}
	
	public Repuestos(int id, String nombre, String descripcion,int cantidad, float precio, int stock, String estado, Marcas marca,
			Categorias categoria, Proveedores proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.estado = estado;
		this.marca = marca;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public Proveedores getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Repuestos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", stock=" + stock + ", cantidad=" + cantidad + ", estado=" + estado + ", marca=" + marca
				+ ", categoria=" + categoria + ", proveedor=" + proveedor + "]";
	}

	

}
