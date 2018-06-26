package clases;

import java.io.Serializable;

public class Registro implements Serializable{
	private int numeroHabitacion;
	private Fecha fechas;
	
	public Registro(int numeroHabitacion, Fecha fechas) {
		super();
		this.numeroHabitacion = numeroHabitacion;
		this.fechas = fechas;
	}

	public int getnumeroHabitacion() {
		return numeroHabitacion;
	}
	

	public String toString() {
		return "\nNumero de habitacion:" + numeroHabitacion + "\nFechas: " + fechas.toString() + "\n---";	
		}
	

}
