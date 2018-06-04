package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
	
	private String nombre;
	private String direccion;
	private Recepcionista recepcionista;
	HashMap<Integer,Habitacion>habitaciones;
	HashMap<Integer,Reserva>reservas;
	ArrayList<Pasajero>registroPasajeros;
	
	public Hotel(String nombre, String direccion, Recepcionista recepcionista) {
		habitaciones=new HashMap<Integer,Habitacion>();
		reservas=new HashMap<Integer,Reserva>();
		registroPasajeros=new ArrayList<Pasajero>();
		this.nombre = nombre;
		this.direccion = direccion;
		this.recepcionista = recepcionista;
	} 
	
	public void agregarHabitacion(Habitacion e)
	{
		
	}
	
	public void mostrarHotel()
	{
		
	}
	
	public void mostrarDisponible()
	{
		
	}
	
	public void mostrarOcupadas()
	{
		
	}
	
	public void cambiarCostos()
	{
		
	}
	
	public void getCosto()
	{
		
	}
	
	public void verReserva()
	{
		
	}
	
	public void nuevaReserva()
	{
		
	}
	
	
	
	

}
