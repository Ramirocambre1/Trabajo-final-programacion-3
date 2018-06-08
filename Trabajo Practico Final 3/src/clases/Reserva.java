package clases;

import java.util.ArrayList;

public class Reserva {
	
	private int numeroReserva;
	private String dniPasajero;
	private int cantidadPasajeros;
	private double costo;
        private int numeroHabitacion; 
        
	public Reserva(int numeroReserva, String dniPasajero, int cantidadPasajeros, double costo,int numeroHabitacion) {
		this.numeroReserva = numeroReserva;
		this.dniPasajero = dniPasajero;
		this.cantidadPasajeros = cantidadPasajeros;
		this.costo = costo;
                this.numeroHabitacion = numeroHabitacion;
        
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
	
	public void calcularCostos(int cantidadDias)
	{
        calcular cantidad de dias q estuvo en la habitacion
	}
	*/
}

