package clases;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Reserva implements Serializable {

	private int numeroReserva;
	private Pasajero pasajero;
	private int cantidadPasajeros;
	private Fecha fechas;
	private int numeroHabitacion;

	public Reserva(int numeroReserva, Pasajero pasajero, int cantidadPasajeros, Fecha fechas, int numeroHabitacion) {
		this.numeroReserva = numeroReserva;
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
	 * estuvo en la habitacion } // ya fue resuelto
	 */

	public Pasajero getPasajero() {
		return pasajero;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	@Override
	public String toString() {
		return "Numero de reserva: " + numeroReserva + "\nPasajero: " + pasajero.toString() + "\nCantidad Pasajeros: "
				+ cantidadPasajeros + "\nFechas: " + fechas.toString() + "\nNumero de habitacion: " + numeroHabitacion;
	}
}
