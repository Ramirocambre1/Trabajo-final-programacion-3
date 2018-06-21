package clases;

import java.io.Console;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

public class Login {
	
	 ArrayList<Usuario>usuarios;
	 
	 public Login(){
		 
		 usuarios=new ArrayList<Usuario>();
	 }
	 
	 public Usuario Loguear(){
		 
		 	 Usuario e=null;
			 boolean estado = false; 
			 System.out.println("LOG IN: ");         //***** Log in  *****//
			 while(estado==false)
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
							 e=usuario;
							 estado=true;
				  }
						 else {
							 System.out.println("Acceso denegado, vuelva a ingresar");
						 }
					 }else {
						 System.out.println("El Usuario no existe, ingrese uno valido!");
					 }
					 
				  	} 
			 }
			 
			return e;
	 }
	 
	 public void nuevoUsuario()
	 {
		 Scanner scanner = new Scanner(System.in); //Scanner para username
		  Console console = System.console();
		  System.out.println("Sign In: ");        //***** Sign in  *****//
		  String username = null;
		  boolean estado=true;
		  while(estado==true) {
			  System.out.println("Username: ");
			  username = scanner.nextLine(); //Guarda Username
			  estado=verificarUsuario(username);
			  if(estado==true) {
				  System.out.println("El Usuario ya existe, ingrese otro.");
			  }
			  }
	 
		  System.out.println("Password: ");
		  String pass = Hash.sha1(scanner.nextLine()); //Encripto Pass
		  
		//  System.out.println("Username: " + username);
		//  System.out.println("Password: " + pass);
		 Usuario usuario1=new Usuario(username, pass);
		  cargarUsuario(usuario1);
		 
	 }
	 
	 public void cargarUsuario(Usuario e)
	 {
		 usuarios.add(e);
	 }
	 
	 public void mostrarUsuarios() {
		 
		for(Usuario array: usuarios) {
			
	        System.out.println("---------USUARIOS---------");
			array.mostrarUsuario1();
		}
		 
	 }
	
	 public boolean verificarUsuario(String e) {
		 boolean estado=false;
		
		 for(Usuario array: usuarios) {
			 String nombre= array.getNombre();
			 if(nombre.equals(e)) {
				 estado=true;
			 }
		 }
		return estado;
		 
	 }
		 
	 public void pasarToarchivo() throws IOException {
		 File fichero=new File("Usuario.dat");
		 FileOutputStream fos=new FileOutputStream(fichero);
		 ObjectOutputStream oos=new ObjectOutputStream(fos);
		 for(Usuario array: usuarios) {
			 oos.writeObject(array);
		 }
		 oos.close();
		 fos.close();
	 }
	 
	 public void leerArchivo() throws IOException,ClassNotFoundException {
		 
		 ObjectInputStream ois=null;
		 try {
		 File fichero=new File("Usuario.dat");
		 FileInputStream fis=new FileInputStream(fichero);
		 ois=new ObjectInputStream(fis);
		  System.out.println("DATOS DEL ARCHIVO");
		 while(true) {
			 Usuario e=(Usuario)ois.readObject();
			 e.mostrarUsuario1();
		 }
		 }catch(IOException io) {
			 System.out.println("FIN de la muestra");
		 }finally {
			 ois.close();
		 }
	 }
	 
	 public void pasarToarray() throws ClassNotFoundException, IOException {
		 ObjectInputStream ois=null;
		 try {
		 File fichero=new File("Usuario.dat");
		 FileInputStream fis=new FileInputStream(fichero);
		 ois=new ObjectInputStream(fis);
		 Usuario e;
		 while(( e = (Usuario)ois.readObject())!=null) {
			 
			 cargarUsuario(e);
		 }
		 }
		 catch (EOFException e2) {
			// TODO: handle exception
		}
		catch(IOException io) {
			 System.out.println("FIN de la carga archivo to array");
		 }finally {
			 ois.close();
		 }
		 
	 }
	 
	 public void modificarUsuario() {
		 
		 Usuario e=null;
		 System.out.println("Ingrese el usuario a modificar:");
		 Scanner scanner = new Scanner(System.in); //Scanner para username
		 Console console = System.console();
		 String username = null;
		 username = scanner.next(); //Guarda Username
		 
		 for(Usuario array: usuarios) {
			
			 String nombre= array.getNombre(); 
			
			 if(nombre.equals(username)) { 
				
				 e=array;
				 System.out.println("asdasda1");
				 usuarios.remove(e);
				 System.out.println("asdasda2");
				
			 }else {
				 System.out.println("No existe el usuario, ingrese uno valido:");
			 }
		 }
		 System.out.println("asdasda3");
		 int opcion = 0;
		 System.out.println("1-Modificar Usuario");
		 System.out.println("2-Modificar Password");
		 System.out.println("Ingrese una opcion:");
		 opcion = scanner.nextInt(); //Guarda opcion
		 if(opcion==1) {
			 System.out.println("Ingrese nuevo usuario");
			 String username2 = null;
			 username2 = scanner.next(); //Guarda Username
			 e.setNombre(username2);
		 }
		 if(opcion==2) {
			 System.out.println("Ingrese nueva Password");
			 String pass = null;
			 pass = Hash.sha1(scanner.next()); //Encripto Pass
			 e.setPassword(pass);
			 
		 }
		 cargarUsuario(e);
	 }
	 
	 public void listarUsuarios () {
		 for (Usuario us: usuarios) {
			 us.mostrarUsuario1();
		 }
	 }
}
