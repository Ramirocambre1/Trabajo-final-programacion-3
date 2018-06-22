package clases;

import java.io.Serializable;

public  class Usuario implements Serializable{
	
	private String nombre;
	private String password;
	
	public Usuario(String nombre, String password) {
		
		this.nombre = nombre;
		this.password = password;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	
	public void setPassword(String password){
		this.password=password;
	}
	public void mostrarUsuario() {
		System.out.println("Nombre: " +nombre);
		System.out.println("Password: " +password);
	}

	


}