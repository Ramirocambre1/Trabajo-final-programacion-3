package clases;

public class Cliente extends Usuario {
	private Pasajero pasajero;
	
	public Cliente (Pasajero pasajero,String nombre,String password) {
		super(nombre, password);
		this.pasajero = pasajero;
	}
	
}
