package clases;

public class Recepcionista extends Usuario {
	
	private Hotel hotel;
	/**
	 * 
	 * @param hotel 
	 * hotel a la cual pertenece la recepcionista
	 */
	public Recepcionista (Hotel hotel) {
		super ();
		this.hotel = hotel;
	}
	
	public void revisarDisponibilidad (int numeroHabitacion) {
		
	}
	
}
