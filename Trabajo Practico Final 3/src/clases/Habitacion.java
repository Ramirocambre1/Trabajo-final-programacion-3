package clases;

import java.util.ArrayList;
import java.util.Date;

import javax.sound.midi.Soundbank;

public class Habitacion {
	private int numero;
	private int capacidad;
	private Disponible disponible;
	private ArrayList<Fecha> fechasOcupadas;
	private double tarifa;

	public Habitacion(int numero, int capacidad, double tarifa,boolean disponibilidad, String detalle) {
		this.numero = numero;
		this.capacidad = capacidad;
		this.tarifa = tarifa;
		fechasOcupadas = new ArrayList<Fecha>();
		disponible = new Disponible( disponibilidad, detalle);
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
	@Override
	public String toString () {
		return "Numero:" + numero + "\nCapacidad: " + capacidad +
				"\nDisponibilidad: "+ disponible.toString() + "\nFechas Ocupadas: "
				+ fechasOcupadas.toString() + "\nTarifa: " + tarifa;
	}

	public int getNumero() {
		return numero;
	}
	public boolean getDisponible () {
		
		return disponible.getDisponibilidad();
	}
}
