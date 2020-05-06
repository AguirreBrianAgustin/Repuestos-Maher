package Negocio;

import java.util.ArrayList;

import Entidad.Localidades;


public interface LocalidadesNeg {

	
	public ArrayList<Localidades> ListarLocalidades();
	public Localidades obtenerUno(int id);
	public boolean insertar( Localidades mar);
	public boolean editar( Localidades mar);
	public boolean borrar(int id);

	
	
	
}



