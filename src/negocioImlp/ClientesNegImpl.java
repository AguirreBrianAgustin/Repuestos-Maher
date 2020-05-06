package negocioImlp;


import java.util.ArrayList;

import Datos.ClientesDao;
import DatosImpl.ClientesDaoImpl;
import Entidad.Clientes;
import Negocio.ClientesNeg;

public class ClientesNegImpl implements ClientesNeg{

	 
private ClientesDao clienDao =   new ClientesDaoImpl();


public ClientesNegImpl() {

}

public  ClientesNegImpl(ClientesDao catDao) {
	
	this.clienDao =  catDao;
}

@Override
public ArrayList<Clientes>ListarClientes(int pagina) {
	return (ArrayList<Clientes>) clienDao.obtenerPagina(pagina);
}

@Override
public ArrayList<Clientes>obtenerUno(int dni) {
	return (ArrayList<Clientes>) clienDao.obtenerUno(dni);
}

@Override
public boolean insertar(Clientes mar) {
	return clienDao.insertar(mar);
}

@Override
public boolean editar(Clientes mar) {
	return clienDao.editar(mar);
}

@Override
public boolean borrar(int id) {
	return clienDao.borrar(id);
}

@Override
public Boolean ExisteCliente(int dni) {
	// TODO Auto-generated method stub
	return clienDao.ExisteCliente(dni);
}

@Override
public Object ListarClientesMOD(int pagina) {
	// TODO Auto-generated method stub
	return (ArrayList<Clientes>) clienDao.obtenerPaginaMOD(pagina);
}
}