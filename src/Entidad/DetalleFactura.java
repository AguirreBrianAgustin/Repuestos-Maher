package Entidad;

public class DetalleFactura {
private int iddetalle;
private int cantidad;
private float precio;
private int idrepuestos;
private int idfacturas;

public DetalleFactura(int iddetalle,int cantidad,float precio,int idrepuestos,int idfacturas) {
	
this.iddetalle=iddetalle;
this.cantidad=cantidad;
this.precio=precio;
this.idrepuestos=idrepuestos;
this.idfacturas=idfacturas;
	
}

public int getIddetalle() {
	return iddetalle;
}

public void setIddetalle(int iddetalle) {
	this.iddetalle = iddetalle;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public float getPrecio() {
	return precio;
}

public void setPrecio(float precio) {
	this.precio = precio;
}

public int getIdrepuestos() {
	return idrepuestos;
}

public void setIdrepuestos(int idrepuestos) {
	this.idrepuestos = idrepuestos;
}

public int getIdfacturas() {
	return idfacturas;
}

public void setIdfacturas(int idfacturas) {
	this.idfacturas = idfacturas;
}

@Override
public String toString() {
	return "DetalleFactura [iddetalle=" + iddetalle + ", cantidad=" + cantidad + ", precio=" + precio + ", idrepuestos="
			+ idrepuestos + ", idfacturas=" + idfacturas + "]";
}

public DetalleFactura() {}
}
