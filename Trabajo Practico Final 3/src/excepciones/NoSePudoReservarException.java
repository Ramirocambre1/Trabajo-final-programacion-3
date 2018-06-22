package excepciones;

public class NoSePudoReservarException extends Exception {
private String clave; // Mensaje de error
	
	public NoSePudoReservarException(String msg) {
		super(msg);
		clave = msg;
	}

}
