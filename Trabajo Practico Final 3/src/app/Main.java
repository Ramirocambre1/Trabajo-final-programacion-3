package app;

import java.util.Date;

import clases.Habitacion;
import clases.Hotel;

public class Main {

	public static void main(String[] args) {
		
		Habitacion uno = new Habitacion(1, 200, 99987, true, "Con vista al volcan");
		Habitacion dos = new Habitacion(2, 1, 522, false, "Con vista y acceso directo al olimpo");
		Hotel hotelazo = new Hotel("la estrella de la muerte", "a 12 cuadras de mar del plata");
		hotelazo.agregarHabitacion(uno);
		hotelazo.agregarHabitacion(dos);
		hotelazo.mostrarHotel();
		hotelazo.listarHabitaciones();
		Habitacion tres = new Habitacion(3, 1000000, 66, true, "Suite imperial");
		hotelazo.agregarHabitacion(tres);
		hotelazo.listarHabitaciones();
	
	}
}
