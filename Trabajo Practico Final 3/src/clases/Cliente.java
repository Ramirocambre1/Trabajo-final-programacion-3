package clases;

public class Cliente extends Usuario {
	
	public Cliente (String nombre,String password) {
		super(nombre, password);
	}
	@Override
	public void mostrarUsuario () {
		super.mostrarUsuario();
		System.out.println("Tipo: Cliente");
	}
}
