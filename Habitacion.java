package clases;

import java.util.ArrayList;

import javax.sound.midi.Soundbank;

public class Habitacion {
	private int numero;
	private int capacidad;
	private Disponible disponible;
	private ArrayList<Fecha> fechasOcupadas;
	private double tarifa;

	public Habitacion(int numero, int capacidad, double tarifa) {
		this.numero = numero;
		this.capacidad = capacidad;
		this.tarifa = tarifa;
		fechasOcupadas = new ArrayList<Fecha>();
		disponible = new Disponible();
	}
	
	public void mostrar () {
		System.out.println("------------ Habitacion --------------");
		System.out.println("Numero:" + numero + "\nCapacidad: " + capacidad);
		System.out.println("Disponibilidad: "+ disponible.toString());
		System.out.println("Fechas Ocupadas: "+ fechasOcupadas.toString());
		System.out.println("Tarifa: " + tarifa);
	}
	
	public void ocupar () {
		
	}
	
	public void comprobarFechas (Date fecha) {
		
	}
}
