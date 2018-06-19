package clases;

import java.util.ArrayList;

import java.sql.Date;

import javax.sound.midi.Soundbank;

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
		ocupante = null;

	}

	public void mostrar() {
		System.out.println("------------ Habitacion --------------");
		System.out.println("Numero:" + numero + "\nCapacidad: " + capacidad);
		System.out.println("Disponibilidad: " + disponible);
		System.out.println("Fechas Ocupadas: " + fechasOcupadas.toString());
		System.out.println("Tarifa: " + tarifa);
	}

	public void ocupar(Date fechaEntrada, Date fechaSalida, Pasajero ocupante) {
		if (disponible == true) {
			boolean flag = comprobarFechas(fechaEntrada, fechaSalida);
			if (flag == true) { // si es ocupable
				disponible = false; // ya no se puede ocupar
				this.ocupante = ocupante;
				System.out.println("Habitacion ocupada exitosamente");
			} else {
				System.out.println("NO se puede ocupar,la habitacion esta reservada");
			}
		} else {
			System.out.println("La habitacion ya esta ocupada");
		}
		// aca hacer registro en ocupante
	}

	public void desocupar() {
		if (disponible == false) {
			disponible=false;
			ocupante = null;
		} else {
			System.out.println("LA HABITACION YA ESTA DESOCUPADA");
		}
	}

	/**
	 * Eliminar del registro de las fechas ocupadas del hotel
	 * 
	 */
	public void eliminarFechasOcupadas() {
		// ver si esto es necesario
	}
	
	public void agregarReserva () {
		// no creo que este sea necesario
	}
	public void agregarFechaReservada () {
		
	}

	/**
	 * Comprueba si se puede ocupar la habitacion en base a un rango de fechas
	 * 
	 * @param fechaEntrada
	 *            La fecha en que entra
	 * @param fechaSalida
	 *            La fecha en que sale
	 * @return True si es ocupable, False si no se puede ocupar
	 */
	public boolean comprobarFechas(Date fechaEntrada, Date fechaSalida) {
		boolean flag = true;
		for (Fecha fe : fechasOcupadas) {
			if (fechaEntrada.before(fe.getFechaIn()) && fechaSalida.after(fe.getFechaIn())) {
				flag = false; // la habitacion no se puede ocupar ya q esta reservada
			}
			if (fechaEntrada.after(fe.getFechaIn()) && fechaSalida.before(fe.getFechaOut())) {
				flag = false;
			}
			if (fechaEntrada.before(fe.getFechaOut()) && fechaSalida.after(fe.getFechaOut())) {
				flag = false;
			}
			if (!fechaEntrada.before(fe.getFechaIn()) && !fechaSalida.after(fe.getFechaOut())) { // si ambas fechas de
																									// entrada y salida
																									// son iguales
				flag = false;
			}
		}
		return flag;

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

	public int getCapacidad() {
		return capacidad;
	}

}
