package clases;

import java.sql.Date;
import java.util.ArrayList;

public class Reserva {

	private Pasajero pasajero;
	private int cantidadPasajeros;
	private Fecha fechas;
	private int numeroHabitacion;

	public Reserva(Pasajero pasajero, int cantidadPasajeros, Fecha fechas, int numeroHabitacion) {
		this.pasajero = pasajero;
		this.cantidadPasajeros = cantidadPasajeros;
		this.fechas = fechas;
		this.numeroHabitacion = numeroHabitacion;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public Date getFechaEntrada() {
		return fechas.getFechaIn();
	}

	public Date getFechaSalida() {
		return fechas.getFechaOut();
	}
	/*
	 * public void calcularCostos(int cantidadDias) { calcular cantidad de dias q
	 * estuvo en la habitacion }
	 */

	public Pasajero getPasajero() {
		return pasajero;
	}
}
