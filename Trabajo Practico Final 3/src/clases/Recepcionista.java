package clases;

public class Recepcionista extends Usuario {
	

	public Recepcionista (String nombre, String password) {
		super (nombre,password);
	}
	
	@Override
	public void mostrarUsuario () {
		super.mostrarUsuario();
		System.out.println("Tipo: Recepcionista");
	}
}
