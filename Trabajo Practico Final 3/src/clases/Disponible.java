package clases;

public class Disponible {
	private boolean disponibilidad;
	private String detalle;
	
	public Disponible(boolean disponibilidad, String detalle) {
		this.disponibilidad = disponibilidad;
		this.detalle = detalle;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public void ocupar() {
		disponibilidad=true;
	}
	
	public void desocupar() {
		disponibilidad=false;
	}
	
	

}
