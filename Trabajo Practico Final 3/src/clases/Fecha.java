package clases;

import java.sql.Date;

public class Fecha {
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
	
	/*public int cantidadDias () { // para calcular el costo en base a los dias en que estuvo
		
	}*/
}
