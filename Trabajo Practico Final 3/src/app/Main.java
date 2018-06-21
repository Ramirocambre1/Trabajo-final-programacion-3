
package app;

import java.io.Console;
import java.sql.Date;
import java.util.Scanner;

import clases.Administrador;
import clases.Habitacion;
import clases.Hash;
import clases.Hotel;
import clases.Login;
import clases.Menu;
import clases.Pasajero;
import excepciones.NoHayHabitacionesException;
import excepciones.PasajeroYaExisteException;

public class Main {

	public static void main(String[] args) {

		/*
		 * Login login=new Login(); login.nuevoUsuario(); login.nuevoUsuario();
		 * login.mostrarUsuarios(); usuario = login.Loguear(); // que devuelva el
		 * usuario que se logueo
		 * 
		 * Hotel hotelin = new Hotel ("bola", "rusia"); Habitacion hab1 = new
		 * Habitacion(1, 234, 10000, true, "con vista al volcan");
		 * hotelin.agregarHabitacion(hab1); hotelin.listarHabitaciones();
		 * 
		 * Date fechaEn = new Date(2000,10,20); // año,mes,dia Date fechaSal = new
		 * Date(2000, 10, 25);
		 * 
		 * Pasajero pas = new Pasajero("pedrito", "fds", 1112, "fgdsg", "gdsgds",
		 * 12544);
		 * 
		 * hab1.ocupar(fechaEn, fechaSal, pas); hotelin.listarHabitaciones();
		 */

		Hotel hotel = new Hotel("Pedro", "juan");
		/*
		 * try { hotel.registrarPasajero(); } catch (PasajeroYaExisteException e) { //
		 * TODO Auto-generated catch block System.out.println(e.getMessage()); }
		 * 
		 * hotel.nuevaReserva(); Habitacion habitaciones = new Habitacion(1, 100, 3,
		 * true, "no"); hotel.agregarHabitacion(habitaciones); try {
		 * hotel.nuevaReserva(); } catch (NoHayHabitacionesException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } hotel.listarHabitaciones();
		 * hotel.checkIn(); hotel.listarHabitaciones();
		 */
		Administrador administrado1 = new Administrador("1", "2");
		Menu menu1 = new Menu();

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Administrador admin1 = new Administrador("Jorge", "Tu vieja");

		menu1.menuLogeo();
		menu1.ingresaOpcion();
		opcion = scanner.nextInt();

		switch (opcion) {

		case 1:
			menu1.ingresaOpcionprueba();//Esta funcion esta para probar las opciones,falta todavia el instanceoff
			menu1.ingresaOpcion();
			int opcion2 = 0;

			opcion2 = scanner.nextInt();

			switch (opcion2) {
			case 1:
				menu1.menuAdmin();
				menu1.ingresaOpcion();
				int opcionadmin1 = 0;
				opcionadmin1 = scanner.nextInt();

				switch (opcionadmin1) {

				case 1:
					menu1.menuUsuario();
					menu1.ingresaOpcion();
					int opcion4 = 0;
					opcion4 = scanner.nextInt();
					switch (opcion4) {
					case 1: // Crear un nuevo usuario

					case 2:// Borrar un usuario

					case 3:// Modificar Usuario

					}
				case 2:
					menu1.menuHotel();
					menu1.ingresaOpcion();
					int opcionadmin2 = 0;
					opcionadmin2 = scanner.nextInt();
					switch (opcionadmin2) {
					case 1:// Informacion del hotel

					case 2:// Listar todas las habitaciones

					case 3:// Mostrar habitaciones disponibles

					case 4:// Mostrar habitaciones ocupadas

					case 5:// Reservar una habitacion

					case 6:// Consultar habitacion

					case 7:// Menu de pasajeros
						menu1.menuPasajero();
						menu1.ingresaOpcion();
						int opcionadmin3 = 0;
						opcionadmin3 = scanner.nextInt();
						switch (opcionadmin3) {
						case 1:// Agregar nuevo pasajero

						case 2:// Check in

						case 3:// Check out

						case 4:// Listar Pasajeros

						}

					}

				}

			case 2:
				menu1.menuHotel();
				menu1.ingresaOpcion();
				int opcionrecepcionista1 = 0;
				opcionrecepcionista1 = scanner.nextInt();
				switch (opcionrecepcionista1) {
				case 1:// Informacion del hotel

				case 2:// Listar todas las habitaciones

				case 3:// Mostrar habitaciones disponibles

				case 4:// Mostrar habitaciones ocupadas

				case 5:// Reservar una habitacion

				case 6:// Consultar habitacion

				case 7:// Menu de pasajeros
					menu1.menuPasajero();
					menu1.ingresaOpcion();
					int opcionrecepcionista2 = 0;
					opcionrecepcionista2 = scanner.nextInt();
					switch (opcionrecepcionista2) {
					case 1:// Agregar nuevo pasajero

					case 2:// Check in

					case 3:// Check out

					case 4:// Listar Pasajeros

					}
				}
			case 3:
				menu1.menuCliente();
				menu1.ingresaOpcion();
				int opcioncliente1=0;
				
				opcioncliente1=scanner.nextInt();
				switch(opcioncliente1)
				{
				case 1://Mostrar habitacion
					
				case 2://Ocupar habitacion
					
				case 3://Desocupar habitacion
					
					
				}
			}
			break;
		case 2:
			System.out.println("El programa fue cerrado exitosamente");

		}

	}
}
