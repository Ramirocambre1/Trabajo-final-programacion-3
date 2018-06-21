package excepciones;

public class NoHayPasajerosException extends Exception {
private String clave; // Mensaje de error
	
	public NoHayPasajerosException(String msg) {
		super(msg);
		clave = msg;
	}

}
