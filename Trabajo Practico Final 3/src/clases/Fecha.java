package clases;

import java.io.Serializable;
import java.sql.Date;

public class Fecha implements Serializable {
	private Date fechaIn;
	private Date fechaOut;

	public Fecha(Date fechaIn, Date fechaOut) {
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
	}

	public Date getFechaIn() {
		return fechaIn;
	}

	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}

	public Date getFechaOut() {
		return fechaOut;
	}

	public void setFechaOut(Date fechaOut) {
		this.fechaOut = fechaOut;
	}

	/**
	 * Calcula la cantidad de dias que hay entre las fechas de entrada y salida
	 * 
	 * @return la cantidad de dias entre las 2 fechas
	 */
	public double cantidadDias() { // para calcular el costo en base a los dias en que estuvo
		long fechaInicial = fechaIn.getTime(); // getTime devuelve la cantidad de milisegundos
		long fechaFinal = fechaOut.getTime();
		long diferencia = fechaFinal - fechaInicial;
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24)); // math.floor redondea el numero
		// 1000 milisegundos hay en un segundo, 60 segundos en un minuto, 60 minutos en
		// una hora, 24 horas en un dia
		return dias;
	}

	public String toString() {
		return "- Fecha de entrada: " + fechaIn.toString() + "\nFecha de salida: " + fechaOut.toString();
	}
}
