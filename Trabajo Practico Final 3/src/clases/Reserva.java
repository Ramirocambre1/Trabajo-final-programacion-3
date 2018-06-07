package clases;

import java.util.ArrayList;

public class Reserva {
	
	private int numeroReserva;
	private String dniPasajero;
	private int cantidadPasajeros;
	private double costo;
	ArrayList<Pasajero> registroPasajeros; // El array list lo saque de habitacion
	
	public Reserva(int numeroReserva, String dniPasajero, int cantidadPasajeros, double costo) {
		registroPasajeros = new ArrayList<Pasajero>();
		this.numeroReserva = numeroReserva;
		this.dniPasajero = dniPasajero;
		this.cantidadPasajeros = cantidadPasajeros;
		this.costo = costo;
	}
	
	public void agregarPasajero(Pasajero e) //
	{
		registroPasajeros.add(e);
		
	}
	/*
	public void setFechaEntrada()
	{
		
	}
	
	public void setFechaSalida()
	{
		
	}
	
	public void getFechaEntrada()
	{
		
	}
	
	public void getFechaSalida()
	{
		
	}
	
	public void calcularCostos()
	{
		
	}
	*/
}

// hola lollllldsfgdgdf
