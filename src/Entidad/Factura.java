package Entidad;

import java.sql.Timestamp;

public class Factura {
private int id;
private Timestamp fecha;
private String pago;
private float total;
private int idCliente;
private int idusuario;

public Factura() {}

public Factura(int id,Timestamp fecha, String pago,float total,int idcliente,int idusuario) {
super();
this.id=id;
this.fecha=fecha;
this.pago=pago;
this.total=total;
this.idCliente=idcliente;
this.idusuario=idusuario;
}

@Override
public String toString() {
	return "Factura [id=" + id + ", fecha=" + fecha + ", pago=" + pago + ", total=" + total + ", idCliente=" + idCliente
			+ ", idusuario=" + idusuario + "]";
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Timestamp getFecha() {
	return fecha;
}

public void setFecha(Timestamp fecha) {
	this.fecha = fecha;
}

public String getPago() {
	return pago;
}

public void setPago(String pago) {
	this.pago = pago;
}

public float getTotal() {
	return total;
}

public void setTotal(float total) {
	this.total = total;
}

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

public int getIdusuario() {
	return idusuario;
}

public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}

}
