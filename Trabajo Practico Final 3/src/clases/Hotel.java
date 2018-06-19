package clases;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.sound.midi.Soundbank;

import excepciones.NoHayHabitacionesException;
import excepciones.PasajeroYaExisteException;

public class Hotel {

	private String nombre;
	private String direccion;
	// private Recepcionista recepcionista; // Se agregara si es necesario
	private HashMap<Integer, Habitacion> habitaciones;
	private HashMap<Integer, Reserva> reservas;
	private HashMap<Integer, Pasajero> pasajeros; // base de datos de pasajeros

	public Hotel(String nombre, String direccion) {
		habitaciones = new HashMap<Integer, Habitacion>();
		reservas = new HashMap<Integer, Reserva>();
		pasajeros = new HashMap<Integer, Pasajero>();
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
		 * for (Map.Entry<Integer, Habitacion> hab : habitaciones.entrySet()) { // para
		 * recorrer clave y valor System.out.println(hab.getValue().toString()); }
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
			// hacer en while para cortar la busqueda cuando se encuentra la habitacion con
			// un flag
			if (hab.getNumero() == numeroHabitacion) {
				hab.setTarifa(tarifaNueva);
			}
		}
	}

	public void getCosto() {

	}

	/**
	 * Consultar una reserva.
	 * 
	 * @param numeroReserva
	 *            numero de la reserva que se quiere consultar
	 */
	public void consultarReserva(int numeroReserva) {

	}

	public void listarReservas() {

	}

	public void nuevaReserva() throws NoHayHabitacionesException {
		Scanner scanner = new Scanner(System.in); // Scanner para ingreso por teclado
		Pasajero pasajero;
		System.out.println("Ingrese DNI: ");
		int dni = scanner.nextInt();
		if (pasajeros.containsKey(dni)) {
			pasajero = pasajeros.get(dni);
		} else {
			try {
				registrarPasajero();
			} catch (PasajeroYaExisteException e) {
				e.printStackTrace();
			}
			pasajero = pasajeros.get(dni);
		}
		System.out.println("Ingrese la cantidad de pasajeros");
		int cantidadPasajeros = scanner.nextInt();
		System.out.println("Ingrese año de entrada: ");
		int anio = scanner.nextInt();
		System.out.println("Ingrese mes de entrada: ");
		int mes = scanner.nextInt();
		System.out.println("Ingrese dia de entrada: ");
		int dia = scanner.nextInt();
		Date fechaIn = new Date(anio, mes, dia);
		System.out.println("Ingrese año de salida: ");
		anio = scanner.nextInt();
		System.out.println("Ingrese mes de salida: ");
		mes = scanner.nextInt();
		System.out.println("Ingrese dia de salida: ");
		dia = scanner.nextInt();
		Date fechaOut = new Date(anio, mes, dia);
		Fecha fechas = new Fecha(fechaIn, fechaOut);
		int numeroHabitacion = obtenerNumeroHabitacion(fechaIn, fechaOut, cantidadPasajeros);
		reservarHabitacion (numeroHabitacion,fechas);
		Reserva reserva = new Reserva(pasajero, cantidadPasajeros, fechas, numeroHabitacion);
		reservas.put(pasajero.getDni(), reserva); // la identificacion de las reservas es el dni de los pasajeros

	}
	/**
	 * Reservar una habitacion
	 * (Agrega las fechas al arreglo de fechas reservadas dentro de la habitacion)
	 */
	public void reservarHabitacion (int numeroHabitacion,Fecha fechas) {
		// obtener la habitacion de la base de datos y pasarle por parametro la fecha
	}

	/**
	 * Consultar habitaciones entre 2 fecha y segun la capacidad. Los muestra por
	 * pantalla.
	 * 
	 * @param fechaInicio
	 *            fecha a partir de la que se quiere buscar una habitacion.
	 * @param fechaFin
	 *            hasta que fecha se quiere buscar una habitacion.
	 * @param capacidad
	 *            de la habitacion
	 */
	public void consultarHabitaciones(Date fechaInicio, Date fechaFin, int capacidad) {

	}

	/**
	 * Busca una habitacion disponible en base a las fechas y la capacidad
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @param capacidad
	 * @return el numero de la habitacion disponible
	 * @throws NoHayHabitacionesException
	 */
	public int obtenerNumeroHabitacion(Date fechaInicio, Date fechaFin, int capacidad)
			throws NoHayHabitacionesException {
		int numeroHabitacion = 0;
		if (habitaciones.isEmpty()) {
			throw new NoHayHabitacionesException("No hay habitaciones en la base de datos");
		} else {
			for (Habitacion hab : habitaciones.values()) {
				if (hab.getCapacidad() >= capacidad) { // buscar una habitacion q cumpla con la capacidad
					if (hab.comprobarFechas(fechaInicio, fechaFin) == true) { // comprobar si se puede ocupar en esas
																				// fechas
						return hab.getNumero();
					}
				}
			}
		}
		return numeroHabitacion;
	}

	/**
	 * registrar un nuevo pasajero en la base de datos de pasajeros
	 * 
	 * @throws PasajeroYaExisteException
	 */
	public void registrarPasajero() throws PasajeroYaExisteException {
		Scanner scanner = new Scanner(System.in); // Scanner para ingreso por teclado
		System.out.println("------------- Nuevo Pasajero --------------");
		System.out.println("Ingrese DNI: ");
		int dni = scanner.nextInt();
		comprobarPasajero(dni);
		System.out.println("Ingrese Nombre: ");
		String nombre = scanner.next();
		System.out.println("Ingrese Apellido: ");
		String apellido = scanner.next();
		System.out.println("Origen: ");
		String origen = scanner.next();
		System.out.println("Ingrese Domicilio: ");
		String domicilio = scanner.next();
		System.out.println("Ingrese telefono: ");
		int telefono = scanner.nextInt();
		Pasajero pas = new Pasajero(nombre, apellido, dni, origen, domicilio, telefono);
		pasajeros.put(dni, pas);
	}

	/**
	 * Comprobamos en la base de datos de pasajeros si el pasajero existe o no
	 * 
	 * @return
	 * @throws PasajeroYaExisteException
	 */
	public void comprobarPasajero(int dni) throws PasajeroYaExisteException {
		for (Pasajero pas : pasajeros.values()) {
			if (pas.getDni() == dni) {
				throw new PasajeroYaExisteException("El Pasajero Ya existe!");
				// return false; // no se puede crear el nuevo pasajero
			}
		}

	}

	public void checkIn() { // hacer comprobaciones con reserva inexistente (excepcion)
		int dni;
		Scanner scanner = new Scanner(System.in); // Scanner para ingreso por teclado
		System.out.println("Ingrese DNI de la reserva");
		dni = scanner.nextInt();
		if (reservas.containsKey(dni)) { // comprobar q exista en la base de datos sino retorna null
			Reserva reserva = reservas.get(dni);
			Habitacion hab = habitaciones.get(reserva.getNumeroHabitacion());
			hab.ocupar(reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getPasajero());
		} else {
			System.out.println("NO HAY RESERVAS");
		}

		// borrar reserva de la base de datos
		// incompleto claramente
	}

	public void checkOut(Reserva r) {

	}

	// ?
	public void desplegarMenu(Usuario us) {

	}

	// ver si es necesario o no
	public void revisarDisponibilidad(int numeroHabitacion) {

	}
}
