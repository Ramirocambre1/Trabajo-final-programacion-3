package app;

import java.io.Console;
import java.sql.Date;
import java.util.Scanner;

import clases.Habitacion;
import clases.Hash;
import clases.Hotel;
import clases.Login;
import clases.Pasajero;

public class Main {

	public static void main(String[] args) {
	
		/*Login login=new Login();
		login.nuevoUsuario();
		login.nuevoUsuario();
		login.mostrarUsuarios();
		usuario = login.Loguear(); // que devuelva el usuario que se logueo*/
		
		Hotel hotelin = new Hotel ("bola", "rusia");
		Habitacion hab1 = new Habitacion(1, 234, 10000, true, "con vista al volcan");
		hotelin.agregarHabitacion(hab1);
		hotelin.listarHabitaciones();
		
		Date fechaEn  = new Date(2000,10,20); // año,mes,dia
                Date fechaSal = new Date(2000, 10, 25);
		
		Pasajero pas = new Pasajero("pedrito", "fds", 1112, "fgdsg", "gdsgds", 12544);
		
		hab1.ocupar(fechaEn, fechaSal, pas);
                hotelin.listarHabitaciones();

	}
}
