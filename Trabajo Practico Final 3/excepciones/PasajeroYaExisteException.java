package excepciones;

public class PasajeroYaExisteException extends Exception{
private String clave; // Mensaje de error
	
	public PasajeroYaExisteException(String msg) {
		super(msg);
		clave = msg;
	}
}
