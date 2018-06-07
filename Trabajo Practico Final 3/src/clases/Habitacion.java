package clases;

import java.util.ArrayList;

import java.sql.Date; // sacar

import javax.sound.midi.Soundbank; // sacar

public class Habitacion {
	private int numero;
	private int capacidad;
	private boolean disponible;
	private ArrayList<Fecha> fechasOcupadas; // fechas ocupadas por reserva
	private double tarifa;
	private Pasajero ocupante;
	private String detalle;

	public Habitacion(int numero, int capacidad, double tarifa, boolean disponible, String detalle) {
		this.numero = numero;
		this.capacidad = capacidad;
		this.tarifa = tarifa;
		fechasOcupadas = new ArrayList<Fecha>();
		this.disponible = disponible;
		this.detalle = detalle;

	}

	public void mostrar() {
		System.out.println("------------ Habitacion --------------");
		System.out.println("Numero:" + numero + "\nCapacidad: " + capacidad);
		System.out.println("Disponibilidad: " + disponible);
		System.out.println("Fechas Ocupadas: " + fechasOcupadas.toString());
		System.out.println("Tarifa: " + tarifa);
	}

	public void ocupar(Date fechaEntrada, Date fechaSalida, Pasajero ocupante) {
		// todo aca es prueba
		Date fechaEn;
		fechaEn = new Date(2000,8,1);
		
		Date fechaSal = new Date(2000, 9, 20);
		Fecha fech = new Fecha(fechaEn, fechaSal);
		
		fechasOcupadas.add(fech);
		
		if (disponible == true) {
			boolean flag = true;
				System.out.println("hola");
				for (Fecha fe : fechasOcupadas) {
					while (flag == true) {
					System.out.println("hola");
					if (!fechaEntrada.before(fe.getFechaIn()) && !fechaSalida.before(fe.getFechaOut())) {
						flag = false; // la habitacion no es ocupable
					} else if (!fechaEntrada.after(fe.getFechaOut()) && !fechaSalida.before(fe.getFechaIn())) {
						flag = false; // la habitacion no es ocupable
					}
				}
			}
			if (flag == true) { // si es ocupable
				disponible = false; // ya no se puede ocupar
				this.ocupante = ocupante;
				System.out.println("HABITACION disponible y ocupada!");
			} else {
				System.out.println("La habitacion esta reservada");

			}
		} else {
			System.out.println("OCUPADA");
		}

	}

	public void comprobarFechas(Date fecha) {

	}

	@Override
	public String toString() {
		return "Numero:" + numero + "\nCapacidad: " + capacidad + "\nDisponibilidad: " + disponible
				+ "\nFechas Ocupadas: " + fechasOcupadas.toString() + "\nTarifa: " + tarifa + "\nDetalle: " + detalle;
	}

	public int getNumero() {
		return numero;
	}

	public boolean getDisponible() {

		return disponible;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

}
