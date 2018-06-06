package clases;

public class Registro {
	private Habitacion habitacion;
	private Fecha fechas;
	
	public Registro(Habitacion habitacion, Fecha fechas) {
		super();
		this.habitacion = habitacion;
		this.fechas = fechas;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}
	
	public void mostrarHabitaciones(){
		habitacion.mostrar();
	}
	
    
	
	
	

}
