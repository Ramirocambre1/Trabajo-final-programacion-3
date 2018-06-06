package clases;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Login {
	
	 ArrayList<Usuario>usuarios;
	 
	 public Login(){
		 
		 usuarios=new ArrayList<Usuario>();
	 }
	 
	 public void Loguear(){
		 
			 int estado = 1; 
			 System.out.println("LOG IN: ");         //***** Log in  *****//
			 while(estado==1)
			 {
				 Scanner scanner = new Scanner(System.in); //Scanner para username
				 Console console = System.console();
		  
				 System.out.println("Username: ");
				 String username2 = scanner.nextLine(); //Guarda Username.
				 for(Usuario usuario:usuarios) {
					 if(username2.equals(usuario.getNombre())) {
						 System.out.println("Password: ");
						 String pass2 = Hash.sha1(scanner.nextLine()); //Encripta Password.
						 if(pass2.equals(usuario.getPassword())) {
							 System.out.println("Acceso Correcto...");
							 estado=0;
				  }
						 else {
							 System.out.println("Acceso denegado, vuelva a ingresar");
						 }
					 }
					 
				  	}
				 
			 }
	 }
	 
	 public void nuevoUsuario()
	 {
		 Scanner scanner = new Scanner(System.in); //Scanner para username
		  Console console = System.console();
		  System.out.println("Sign In: ");        //***** Sign in  *****//
		  System.out.println("Username: ");
		  String username = scanner.nextLine(); //Guarda Username
		  System.out.println("Password: ");
		  String pass = Hash.sha1(scanner.nextLine()); //Encripto Pass
		  
		//  System.out.println("Username: " + username);
		//  System.out.println("Password: " + pass);
		 Usuario usuario1=new Usuario(username, pass);
		 usuarios.add(usuario1);
		 
	 }
	 
	 public void cargarUsuarios(Usuario e)
	 {
		 usuarios.add(e);
	 }
	 
	 public void mostrarUsuarios() {
		 
		for(Usuario array: usuarios) {
			
	        System.out.println("---------USUARIOS---------");
			array.mostrarUsuario1();
		}
		 
	 }
	
		 
	
	
	

}