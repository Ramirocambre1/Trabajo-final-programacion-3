package clases;

public class Menu {
	
	public void menuAdmin()
	{
		System.out.println("1.Menu de Usuario");
		System.out.println("2.Menu de Hotel");
		System.out.println("3.Salir");
		
		
	}
	
	public void menuUsuario()
	{
		System.out.println("---Menu del Usuario---");
		System.out.println("1.Crear Nuevo Administrador");
		System.out.println("2.Crear Nuevo Cliente");
		System.out.println("3.Crear Nuevo Recepcionista");
		System.out.println("4.Borrar Usuario");
		System.out.println("5.Modificar Usuario");
		System.out.println("6.Volver");
		
	}
	
	public void menuHotel()
	{
		System.out.println("---Menu del Hotel---");
		System.out.println("1.Info Hotel");
		System.out.println("2.Listar Habitaciones");
		System.out.println("3.Mostrar Habitaciones Disponibles");
		System.out.println("4.Mostrar Habitaciones Ocupadas");
		System.out.println("5.Reservar Habitacion");
		System.out.println("6.Check In");
		System.out.println("7.Check Out");
		System.out.println("8.Agregar Habitacion");
		System.out.println("9.Menu de pasajeros");
		System.out.println("10.Volver");
		
	}
	
	public void menuPasajero()
	{
		System.out.println("---Menu del Pasajero---");
		System.out.println("1.Agregar Nuevo Pasajero");
		System.out.println("2.Eliminar");
		System.out.println("3.Listar Pasajeros");
		System.out.println("4.Volver");
	}
	
	public void menuLogeo()
	{
		System.out.println("1.Loguearse");
		System.out.println("2.Cerrar el Programa");
	}
	
	public void ingresaOpcion()
	{
		System.out.println("Ingrese la opcion:");
		
	}
	
	public void ingresaOpcionprueba()
	{
		System.out.println("1.Admin:");
		System.out.println("2.Recepcionista");
		System.out.println("3.Cliente");
	}
	
	
	public void menuCliente()
	{
		System.out.println("---Menu del Cliente---");
		System.out.println("1.Reservar habitacion.");
		System.out.println("2.Check In:");
		System.out.println("3.Check out:");
		System.out.println("4.Volver");
		
	}
	
}
