package excepciones;

public class NoHayHabitacionesException extends Exception{
private String clave; // Mensaje de error
	
	public NoHayHabitacionesException(String msg) {
		super(msg);
		clave = msg;
	}
}
