package clases;

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

	/*
	 * public void setFechaEntrada() {
	 * 
	 * }
	 * 
	 * public void setFechaSalida() {
	 * 
	 * }
	 * 
	 * public void getFechaEntrada() {
	 * 
	 * }
	 * 
	 * public void getFechaSalida() {
	 * 
	 * }
	 * 
	 * public void calcularCostos(int cantidadDias) { calcular cantidad de dias q
	 * estuvo en la habitacion }
	 */
}
