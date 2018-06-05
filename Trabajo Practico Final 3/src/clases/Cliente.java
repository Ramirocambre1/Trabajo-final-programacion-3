package clases;

import java.util.Date;

public class Cliente extends Usuario {
	private Pasajero pasajero;
	
	public Cliente (Pasajero pasajero,String nombre,String password) {
		super(nombre, password);
		this.pasajero = pasajero;
	}
	/**
	 * Consultar habitaciones entre 2 fechas
	 * @param fechaInicio
	 * fecha a partir de la que se quiere buscar una habitacion.
	 * @param fechaFin
	 * hasta que fecha se quiere buscar una habitacion.
	 */
	public void consultarHabitaciones (Date fechaInicio, Date fechaFin) { 
	}
}
