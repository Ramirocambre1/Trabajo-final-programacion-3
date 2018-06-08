package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.sound.midi.Soundbank;

public class Hotel {

	private String nombre;
	private String direccion;
	// private Recepcionista recepcionista; // Se agregara si es necesario
	HashMap<Integer, Habitacion> habitaciones;
	HashMap<Integer, Reserva> reservas;
        HashMap<String, Pasajero> pasajeros;  // base de datos de pasajeros


	public Hotel(String nombre, String direccion) {
		habitaciones = new HashMap<Integer, Habitacion>();
		reservas = new HashMap<Integer, Reserva>();
                pasajeros = new HashMap<String, Pasajero>();
		this.nombre = nombre;
		this.direccion = direccion;
		// this.recepcionista = recepcionista; // por ahora se descarta
	}

	public void agregarHabitacion(Habitacion e) {
		habitaciones.put(e.getNumero(), e);
	}

	/**
	 * Mostrar info del hotel
	 */
	public void mostrarHotel() {
		System.out.println("----------- HOTEL ------------");
		System.out.println("Nombre: " + nombre + "\nDireccion: " + direccion);
		System.out.println("-----------------------------");
	}

	/**
	 * Mostrar habitaciones disponibles
	 */
	public void mostrarDisponible() {
		for (Habitacion hab : habitaciones.values()) { // para recorrer solo los
														// valores
			if (hab.getDisponible() == true) {
				System.out.println("--------------- Habitacion ----------------");
				System.out.println(hab.toString());
			}
		}
		/*
		 * for (Map.Entry<Integer, Habitacion> hab : habitaciones.entrySet()) {
		 * // para recorrer clave y valor
		 * System.out.println(hab.getValue().toString()); }
		 */
	}

	/**
	 * Mostrar habitaciones ocupadas
	 */
	public void mostrarOcupadas() {
		for (Habitacion hab : habitaciones.values()) { // para recorrer solo los
														// valores
			if (hab.getDisponible() == false) {
				System.out.println("--------------- Habitacion ----------------");
				System.out.println(hab.toString());
			}
		}

	}

	/**
	 * Mostrar todas las habitaciones
	 */
	public void listarHabitaciones() {
		mostrarDisponible();
		mostrarOcupadas();
	}
	
	public void cambiarCostos(int numeroHabitacion, int tarifaNueva) {
		for (Habitacion hab : habitaciones.values()) { // para recorrer solo los
														// valores
			// hacer en while para cortar la busqueda cuando se encuentra la habitacion con un flag
			if (hab.getNumero() == numeroHabitacion) {
				hab.setTarifa(tarifaNueva); 
			}
		}
	}
	
	public void getCosto() {
		
	}
        /**
         * Consultar una reserva.
         * @param numeroReserva
         * numero de la reserva que se quiere consultar
         */
	public void consultarReserva(int numeroReserva) {

	}
        public void listarReservas (){
            
        }
	public void nuevaReserva() {
            
	}
        /**
	 * Consultar habitaciones entre 2 fecha y segun la capacidad.
         * Los muestra por pantalla.
	 * @param fechaInicio
	 * fecha a partir de la que se quiere buscar una habitacion.
	 * @param fechaFin
	 * hasta que fecha se quiere buscar una habitacion.
         * @param 
         * capacidad de la habitacion
	 */
	public void consultarHabitaciones (Date fechaInicio, Date fechaFin,int capacidad) { 
            
	}
    public void registrarPasajero() 
	{
		
	}
    	public void checkIn(Reserva r)
	{
		
	}
	
	public void checkOut(Reserva r)
	{
		
	}
        // ?
        public void desplegarMenu (Usuario us){
		
	}
        // ver si es necesario o no 
        public void revisarDisponibilidad (int numeroHabitacion) {
		
		
	}
}
