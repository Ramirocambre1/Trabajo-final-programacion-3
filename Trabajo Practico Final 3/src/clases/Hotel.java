package clases;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.sound.midi.Soundbank;

import excepciones.NoHayHabitacionesException;
import excepciones.NoHayPasajerosException;
import excepciones.NoHayReservasException;
import excepciones.NoSePudoReservarException;
import excepciones.PasajeroYaExisteException;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public class Hotel {

	private String nombre;
	private String direccion;
	private HashMap<Integer, Habitacion> habitaciones;
	private HashMap<Integer, Reserva> reservas;
	private HashMap<Integer, Pasajero> pasajeros; // base de datos de pasajeros

	public Hotel(String nombre, String direccion) {
		habitaciones = new HashMap<Integer, Habitacion>();
		reservas = new HashMap<Integer, Reserva>();
		pasajeros = new HashMap<Integer, Pasajero>();
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public void agregarHabitacion(Habitacion e) {
		if (habitaciones.containsKey(e.getNumero())) {
			System.out.println("EL NUMERO DE HABITACION INGRESADO YA EXISTE");
		} else {
			habitaciones.put(e.getNumero(), e);
			System.out.println("HABITACION AGREGADA CORRECTAMENTE");
			habitacionesToArchivo();
		}
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
				System.out.println("-----------------------------------------");

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
				System.out.println("-------------------------------------");

			}
		}

	}

	/**
	 * Mostrar todas las habitaciones
	 */
	public void listarHabitaciones() {
		if (habitaciones.isEmpty() == true) {
			System.out.println("NO HAY HABITACIONES");
		} else {
			mostrarDisponible();
			mostrarOcupadas();
		}

	}

	public void cambiarCostos(int numeroHabitacion, int tarifaNueva) {
		for (Habitacion hab : habitaciones.values()) { // para recorrer solo los
														// valores
			// hacer en while para cortar la busqueda cuando se encuentra la
			// habitacion con
			// un flag
			if (hab.getNumero() == numeroHabitacion) {
				hab.setTarifa(tarifaNueva);
			}
		}
	}

	/**
	 * Consultar una reserva.
	 * 
	 * @param numeroReserva
	 *            numero de la reserva que se quiere consultar
	 */
	public void consultarReserva(Integer numeroReserva) { // poner integer para
															// comparar con el
															// key del map
		boolean flag = false;
		Iterator iterator = reservas.entrySet().iterator(); // para recorrer un
															// map hay q usar un
															// iterator
		while (iterator.hasNext() && flag == false) {
			Map.Entry me = (Map.Entry) iterator.next();
			if (me.getKey().equals(numeroReserva)) {
				System.out.println(me.getValue().toString()); // obtener la
																// reserva y
																// mostrarla
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("!No existe reserva a ese numero!");
		}
	}
	/**
	 * Muestra todas las reservas que se encuentren en la base de datos del hotel
	 * @throws NoHayReservasException
	 */
	public void listarReservas() throws NoHayReservasException {
		if (reservas.isEmpty() == true) {
			throw new NoHayReservasException("Reservas Vacias");
		}
		System.out.println("------------- RESERVAS ----------------");
		for (Reserva res : reservas.values()) {
			System.out.println(res.toString());
			System.out.println("///////");
		}

	}
	
	public void nuevaReserva() throws NoHayHabitacionesException, NoSePudoReservarException {
		System.out.println("--------------- NUEVA RESERVA ---------------");
		Scanner scanner = new Scanner(System.in); // Scanner para ingreso por
													// teclado
		Pasajero pasajero;
		System.out.println("Ingrese DNI: ");
		int dni = scanner.nextInt();
		if (pasajeros.containsKey(dni)) {
			pasajero = pasajeros.get(dni);
		} else {
			try {
				System.out.println("Pasajero no registrado! Registar pasajero: ");
				registrarPasajero();
			} catch (PasajeroYaExisteException e) {
				e.printStackTrace();
			}
			pasajero = pasajeros.get(dni);
		}

		if (reservas.containsKey(dni)) {
			System.out.println("Ya se encuentra una reserva a ese DNI");
		} else {
			System.out.println("Ingrese la cantidad de pasajeros para la habitacion");
			int cantidadPasajeros = scanner.nextInt();
			System.out.println("Ingrese a�o de entrada: ");
			int anio = scanner.nextInt();
			anio = anio - 1900; // el constructor del date le suma 1900 al a�o
			System.out.println("Ingrese mes de entrada: ");
			int mes = scanner.nextInt();
			mes = mes - 1; // en Date, los meses se ingresan de 0 a 11
			System.out.println("Ingrese dia de entrada: ");
			int dia = scanner.nextInt();
			Date fechaIn = new Date(anio, mes, dia);
			System.out.println("Ingrese a�o de salida: ");
			anio = scanner.nextInt();
			anio = anio - 1900;
			System.out.println("Ingrese mes de salida: ");
			mes = scanner.nextInt();
			mes = mes - 1; // en Date, los meses se ingresan de 0 a 11
			System.out.println("Ingrese dia de salida: ");
			dia = scanner.nextInt();
			Date fechaOut = new Date(anio, mes, dia);
			Fecha fechas = new Fecha(fechaIn, fechaOut);
			int numeroHabitacion = obtenerNumeroHabitacion(fechaIn, fechaOut, cantidadPasajeros);
			if (numeroHabitacion == -1) { // significa q no se pudo encontrar
											// una habitacion para esas fechas
				throw new NoSePudoReservarException("No se pudo encontrar una habitacion para esas fechas!\n");
			}
			reservarHabitacion(numeroHabitacion, fechas);
			Reserva reserva = new Reserva(pasajero, cantidadPasajeros, fechas, numeroHabitacion);
			reservas.put(pasajero.getDni(), reserva); // la identificacion de
														// las reservas es el
														// dni de los pasajeros
			reservasToArchivo(); // actualizamos el archivo de reservas

		}

	}

	/**
	 * Reservar una habitacion (Agrega las fechas al arreglo de fechas
	 * reservadas dentro de la habitacion)
	 */
	public void reservarHabitacion(Integer numeroHabitacion, Fecha fechas) {
		// obtener la habitacion de la base de datos y pasarle por parametro la
		// fecha
		boolean flag = false;
		Iterator iterator = habitaciones.entrySet().iterator(); // para recorrer
																// un map hay q
																// usar un
																// iterator
		while (iterator.hasNext() && flag == false) {

			Map.Entry me = (Map.Entry) iterator.next();
			if (me.getKey().equals(numeroHabitacion)) {
				Habitacion hab = (Habitacion) me.getValue();
				hab.agregarFechaReservada(fechas);
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("!NO EXISTE LA HABITACION!");
		}
	}

	/**
	 * Consultar habitaciones entre 2 fecha y segun la capacidad. Los muestra
	 * por pantalla.
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
		int numeroHabitacion = -1;
		if (habitaciones.isEmpty()) {
			throw new NoHayHabitacionesException("No hay habitaciones en la base de datos");
		} else {
			for (Habitacion hab : habitaciones.values()) {
				if (hab.getCapacidad() >= capacidad) { // buscar una habitacion
														// q cumpla con la
														// capacidad
					if (hab.comprobarFechas(fechaInicio, fechaFin) == true) { // comprobar
																				// si
																				// se
																				// puede
																				// ocupar
																				// en
																				// esas
																				// fechas
						return hab.getNumero();
					} else {
						System.out.println("LA HABITACION ESTA RESERVADA ENTRE ESAS FECHAS");
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
		Scanner scanner = new Scanner(System.in); // Scanner para ingreso por
													// teclado
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
		pasajerosToArchivo(); // actualizamos el archivo pasajeros
		System.out.println("PASAJERO REGISTRADO!");
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

	public void checkIn() { // hacer comprobaciones con reserva inexistente
							// (excepcion)
		int dni;
		Scanner scanner = new Scanner(System.in); // Scanner para ingreso por
													// teclado
		System.out.println("Ingrese DNI de la reserva");
		dni = scanner.nextInt();
		if (reservas.containsKey(dni)) { // comprobar q exista en la base de
											// datos sino retorna null
			Reserva reserva = reservas.get(dni);
			Habitacion hab = habitaciones.get(reserva.getNumeroHabitacion());
			hab.ocupar(reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getPasajero());
			// System.out.println("Habitacion Ocupada Exitosamente!"); // sacar
			// , ya esta en habitacion
		} else {
			System.out.println("NO HAY RESERVAS CON EL DNI INGRESADO");
		}

		// rehacerlo como checkout
	}

	/**
	 * Desocupa la habitacion, registra la estadia en el pasajero y retorna el
	 * costo de la estadia
	 * 
	 * @param numeroReserva,
	 *            equivalente al dni del pasajero
	 * @return El costo de la estadia
	 */
	public double checkOut(int numeroReserva) {
		double costo = 0;
		if (reservas.containsKey(numeroReserva)) {
			Reserva reserva = reservas.get(numeroReserva);
			Habitacion hab = habitaciones.get(reserva.getNumeroHabitacion()); // buscamos
																				// la
																				// habitacion
																				// que
																				// corresponde
																				// a
																				// la
																				// reserva
			costo = hab.calcularCosto(reserva.getFechaEntrada(), reserva.getFechaSalida());
			hab.desocupar();
			// registrar la estadia adentro de pasajero
			Pasajero pasajero = pasajeros.get(reserva.getPasajero().getDni()); // pasamos
																				// el
																				// dni
																				// como
																				// clave
			pasajero.registrarEstadia(reserva.getNumeroHabitacion(), reserva.getFechaEntrada(),
					reserva.getFechaSalida());
			reservas.remove(numeroReserva);
			reservasToArchivo(); // actualizamos el archivo reservas
		} else {
			System.out.println("NO HAY HABITACION OCUPADA CON EL DNI INGRESADO");
		}
		return costo;
	}

	/**
	 * Muestra por pantalla todos los pasajeros registrados en la base de datos
	 * del hotel
	 * 
	 * @throws NoHayPasajerosException
	 */
	public void listarPasajeros() throws NoHayPasajerosException {
		if (pasajeros.isEmpty() == true) {
			throw new NoHayPasajerosException("NO HAY PASAJEROS!");
		}
		System.out.println("------------- PASAJEROS -----------");
		for (Pasajero pas : pasajeros.values()) {
			System.out.println(pas.toString());
			System.out.println("~~~~~~~~~~~~~~~~~~~");
		}
	}

	public void leerArchivoHabitaciones() throws ClassNotFoundException {
		File archivoHabitaciones = new File("habitaciones.dat");
		FileInputStream fileobj = null;
		ObjectInputStream objin = null; // Input para operaciones de lectura de
										// archivo (entrada)
		try {
			fileobj = new FileInputStream(archivoHabitaciones);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objin = new ObjectInputStream(fileobj);
			Habitacion hab;
			while ((hab = (Habitacion) objin.readObject()) != null) {
				habitaciones.put(hab.getNumero(), hab);
			}
		} catch (EOFException e2) {
			// TODO: handle exception
		} catch (IOException io) {
			System.out.println("FIN de la lectura del archivo de habitaciones");
		} finally {
			try {
				if (objin != null) {
					objin.close();
					fileobj.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void habitacionesToArchivo() {
		if (habitaciones.isEmpty() == false) { // si habitaciones esta vacia, se
												// sobreescribira vacio el
												// archivo y
												// podriamos perder datos

			File archivoHabitaciones = new File("habitaciones.dat");
			FileOutputStream fileobj = null;
			ObjectOutputStream objout = null;
			try {
				fileobj = new FileOutputStream(archivoHabitaciones);
				objout = new ObjectOutputStream(fileobj);
				for (Habitacion hab : habitaciones.values()) {
					objout.writeObject(hab);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Habitaciones cargadas correctamente en el archivo");
		} else {
			System.out.println("NO HAY HABITACIONES PARA PASAR AL ARCHIVO!");
		}
	}

	public void leerArchivoPasajeros() throws ClassNotFoundException {
		File archivoPasajeros = new File("pasajeros.dat");
		FileInputStream fileobj = null;
		ObjectInputStream objin = null; // Input para operaciones de lectura de
										// archivo (entrada)
		try {
			fileobj = new FileInputStream(archivoPasajeros);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objin = new ObjectInputStream(fileobj);
			Pasajero pas;
			while ((pas = (Pasajero) objin.readObject()) != null) {
				pasajeros.put(pas.getDni(), pas);
			}
		} catch (EOFException e2) {
			// TODO: handle exception
		} catch (IOException io) {
			System.out.println("FIN de la lectura del archivo de Pasajeros");
		} finally {
			try {
				if (objin != null) { // se tuvo que poner esto sino saltaba null
										// pointer en caso de leer archivo
										// inexistente
					objin.close();
					fileobj.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pasajerosToArchivo() {
		if (pasajeros.isEmpty() == false) { // si pasajeros esta vacia, se
											// sobreescribira vacio el archivo y
											// podriamos
											// perder datos

			File archivoPasajeros = new File("pasajeros.dat");
			FileOutputStream fileobj = null;
			ObjectOutputStream objout = null;
			try {
				fileobj = new FileOutputStream(archivoPasajeros);
				objout = new ObjectOutputStream(fileobj);
				for (Pasajero pas : pasajeros.values()) {
					objout.writeObject(pas);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Pasajeros cargados correctamente en el archivo");
		} else {
			System.out.println("NO HAY PASAJEROS PARA PASAR AL ARCHIVO!");
		}

	}

	public void leerArchivoReservas() throws ClassNotFoundException {
		File archivoReservas = new File("reservas.dat");
		FileInputStream fileobj = null;
		ObjectInputStream objin = null; // Input para operaciones de lectura de
										// archivo (entrada)
		try {
			fileobj = new FileInputStream(archivoReservas);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objin = new ObjectInputStream(fileobj);
			Reserva res;
			while ((res = (Reserva) objin.readObject()) != null) {
				reservas.put(res.getPasajero().getDni(), res);
			}
		} catch (EOFException e2) {
			// TODO: handle exception
		} catch (IOException io) {
			System.out.println("FIN de la lectura del archivo de Reservas");
		} finally {
			try {
				if (objin != null) { // se tuvo que poner esto sino saltaba null
										// pointer en caso de leer archivo
										// inexistente
					objin.close();
					fileobj.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void reservasToArchivo() {
		if (pasajeros.isEmpty() == false) { // si pasajeros esta vacia, se
											// sobreescribira vacio el archivo y
											// podriamos
											// perder datos

			File archivoReservas = new File("reservas.dat");
			FileOutputStream fileobj = null;
			ObjectOutputStream objout = null;
			try {
				fileobj = new FileOutputStream(archivoReservas);
				objout = new ObjectOutputStream(fileobj);
				for (Reserva res : reservas.values()) {
					objout.writeObject(res);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Reservas cargadas correctamente en el archivo");
		} else {
			System.out.println("NO HAY RESERVAS PARA PASAR AL ARCHIVO!");
		}

	}

	/**
	 * Lee los archivos de habitaciones, pasajeros y reservas, y los pasa a sus
	 * respectivas colecciones
	 * 
	 * @throws ClassNotFoundException
	 */
	public void leerArchivos() throws ClassNotFoundException {
		File archivoReservas = new File("reservas.dat");
		File archivoPasajeros = new File("pasajeros.dat");
		File archivoHabitaciones = new File("habitaciones.dat");
		try {
			archivoHabitaciones.createNewFile();
			archivoPasajeros.createNewFile();
			archivoReservas.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		leerArchivoHabitaciones();
		leerArchivoPasajeros();
		leerArchivoReservas();
	}
	// funciones a partir ver si son necesarias
	public void pasarReservasAHabitaciones (){
		// luego de leer las reservas, pasar las fechas reservadas a las habitaciones que correspondan
		
	}
	public void eliminarHabitacion() {
		// determinar si es necesario
	}

	public void eliminarReserva() {

	}

	public void eliminarPasajero() {

	}

	// ver si es necesario o no
	public void verHabitacion(int numeroHabitacion) {

	}
}
