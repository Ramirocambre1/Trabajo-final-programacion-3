package clases;

import java.util.ArrayList;

public class Pasajero {
	private String nombre;
	private String apellido;
	private int dni;
	private String origen;
	private String domicilio;
	private ArrayList <Registro> registro; // registro de fechas en las que estuvo en el hotel
	private int telefono;
	
	public Pasajero (String nombre, String apellido, int dni, String origen, String domicilio,int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.origen = origen;
		this.domicilio = domicilio;
		registro = new ArrayList<Registro>();
		this.telefono = telefono;
		
	}
	
	public void mostrar () {
		System.out.println("-------- Pasajero --------------");
		System.out.println("Nombre: " + nombre + "\nApellido: " + apellido + "\nDNI: "+ dni);
		System.out.println("Origen" + origen + "\nDomicilio: "+ domicilio + "\nTelefono: " + telefono);
	}

	public int getDni() {
		return dni;
	}

}
