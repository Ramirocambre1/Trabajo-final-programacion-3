package excepciones;

public class NoHayReservasException extends Exception {
private String clave; // Mensaje de error
	
	public NoHayReservasException(String msg) {
		super(msg);
		clave = msg;
	}

}
