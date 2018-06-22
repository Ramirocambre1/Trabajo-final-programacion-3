package clases;


public class Administrador extends Usuario {
	

	public Administrador( String usuario, String password) {
		super(usuario, password);
	}
	@Override
	public void mostrarUsuario () {
		super.mostrarUsuario();
		System.out.println("Tipo: Administrador");
	}

}
