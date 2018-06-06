package clases;

import java.util.ArrayList;

public class Administrador extends Usuario {
	
	private ArrayList<Recepcionista>recepcionistas;

	public Administrador(ArrayList<Recepcionista> recepcionistas, String usuario, String password) {
		super(usuario, password);
		this.recepcionistas = recepcionistas;
	}
	
	
	
	

}
