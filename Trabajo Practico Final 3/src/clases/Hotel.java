package clases;

import java.util.ArrayList;
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
	

	public Hotel(String nombre, String direccion) {
		habitaciones = new HashMap<Integer, Habitacion>();
		reservas = new HashMap<Integer, Reserva>();
		
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
		for (Habitacion hab : habitaciones.values()) { // para recorrer solo los valores
			if (hab.getDisponible() == true) {
				System.out.println("--------------- Habitacion ----------------");
				System.out.println(hab.toString());
			}
		}
		/*
		 * for (Map.Entry<Integer, Habitacion> hab : habitaciones.entrySet()) { // para recorrer clave y valor
		 * System.out.println(hab.getValue().toString()); }
		 */
	}

	/**
	 * Mostrar habitaciones ocupadas
	 */
	public void mostrarOcupadas() {
		for (Habitacion hab : habitaciones.values()) { // para recorrer solo los valores
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

	public void cambiarCostos() {

	}

	public void getCosto() {

	}

	public void verReserva() {

	}

	public void nuevaReserva() {

	}

}
