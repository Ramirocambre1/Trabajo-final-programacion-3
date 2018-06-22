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
import java.util.Map;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

public class Login {

	ArrayList<Usuario> usuarios;

	public Login() {

		usuarios = new ArrayList<Usuario>();
	}

	public Usuario Loguear() {
		System.out.println("--------------- LOG IN ----------------");
		Usuario e = null;
		boolean estado = false;
		while (estado == false) {
			Scanner scanner = new Scanner(System.in); // Scanner para username
			Console console = System.console();
			System.out.println("Username: ");
			String username2 = scanner.nextLine(); // Guarda Username.
			int i = 0;
			boolean flag = false;
			Usuario usuario;
			while (i < usuarios.size() && flag == false) {
				usuario = usuarios.get(i);
				if (username2.equals(usuario.getNombre())) {
					flag = true; // indicamos que encontramos el usuario
					System.out.println("Password: ");
					String pass2 = Hash.sha1(scanner.nextLine()); // Encripta Password.
					if (pass2.equals(usuario.getPassword())) {
						System.out.println("Acceso Correcto...");
						e = usuario;
						estado = true;
					} else {
						System.out.println("Acceso denegado, vuelva a ingresar");
					}
				}
				i++;
			}
			if (flag == false) { // si no se encontro el usuario
				System.out.println("El Usuario no existe, ingrese uno valido!");
			}
		

		}
		return e;
	}

	public void nuevoAdministrador() {
		System.out.println("------------- NUEVO ADMINISTRADOR --------------");
		Scanner scanner = new Scanner(System.in); // Scanner para username
		Console console = System.console();
		// System.out.println("Sign In: "); //***** Sign in *****//
		String username = null;
		boolean estado = true;
		while (estado == true) {
			System.out.println("Username: ");
			username = scanner.nextLine(); // Guarda Username
			estado = verificarUsuario(username);
			if (estado == true) {
				System.out.println("El Usuario ya existe, ingrese otro.");
			}
		}

		System.out.println("Password: ");
		String pass = Hash.sha1(scanner.nextLine()); // Encripto Pass
		// System.out.println("Username: " + username);
		// System.out.println("Password: " + pass);
		Administrador usuario1 = new Administrador(username, pass);
		cargarUsuario(usuario1);
		// actualizamos el archivo
		try {
			pasarToarchivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// scanner.close();

	}

	public void nuevoRecepcionista() {
		System.out.println("------------- NUEVO RECEPCIONISTA --------------");
		Scanner scanner = new Scanner(System.in); // Scanner para username
		Console console = System.console();
		String username = null;
		boolean estado = true;
		while (estado == true) {
			System.out.println("Username: ");
			username = scanner.nextLine(); // Guarda Username
			estado = verificarUsuario(username);
			if (estado == true) {
				System.out.println("El Usuario ya existe, ingrese otro.");
			}
		}

		System.out.println("Password: ");
		String pass = Hash.sha1(scanner.nextLine()); // Encripto Pass

		Recepcionista usuario1 = new Recepcionista(username, pass);
		cargarUsuario(usuario1);
		// actualizamos el archivo
		try {
			pasarToarchivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// scanner.close(); // comentado porq hacia fallar el scanner en el main

	}

	public void nuevoCliente() {
		System.out.println("------------- NUEVO CLIENTE --------------");
		Scanner scanner = new Scanner(System.in); // Scanner para username
		Console console = System.console();
		// System.out.println("Sign In: "); //***** Sign in *****//
		String username = null;
		boolean estado = true;
		while (estado == true) {
			System.out.println("Username: ");
			username = scanner.nextLine(); // Guarda Username
			estado = verificarUsuario(username);
			if (estado == true) {
				System.out.println("El Usuario ya existe, ingrese otro.");
			}
		}

		System.out.println("Password: ");
		String pass = Hash.sha1(scanner.nextLine()); // Encripto Pass
		// System.out.println("Username: " + username);
		// System.out.println("Password: " + pass);
		Cliente usuario1 = new Cliente(username, pass);
		cargarUsuario(usuario1);
		// actualizamos el archivo
		try {
			pasarToarchivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// scanner.close();

	}

	public void cargarUsuario(Usuario e) {
		usuarios.add(e);
	}

	public void mostrarUsuarios() {

		for (Usuario array : usuarios) {

			System.out.println("---------USUARIOS---------");
			array.mostrarUsuario();
		}

	}

	public boolean verificarUsuario(String e) {
		boolean estado = false;

		for (Usuario array : usuarios) {
			String nombre = array.getNombre();
			if (nombre.equals(e)) {
				estado = true;
			}
		}
		return estado;

	}

	public void pasarToarchivo() throws IOException {
		File fichero = new File("Usuario.dat");
		FileOutputStream fos = new FileOutputStream(fichero);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (Usuario array : usuarios) {
			oos.writeObject(array);
		}
		oos.close();
		fos.close();
	}

	public void listarArchivo() throws IOException, ClassNotFoundException {

		ObjectInputStream ois = null;
		try {
			File fichero = new File("Usuario.dat");
			FileInputStream fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);
			System.out.println("DATOS DEL ARCHIVO");
			while (true) {
				Usuario e = (Usuario) ois.readObject();
				e.mostrarUsuario();
			}
		} catch (IOException io) {
			System.out.println("FIN de la muestra");
		} finally {
			ois.close();
		}
	}

	public void leerArchivo() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = null;
		try {
			File fichero = new File("Usuario.dat");
			FileInputStream fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);
			Usuario e;
			while ((e = (Usuario) ois.readObject()) != null) {

				cargarUsuario(e);
			}
		} catch (EOFException e2) {
			// TODO: handle exception
		} catch (IOException io) {
			System.out.println("FIN de la carga archivo to array");
		} finally {
			if (ois != null) {
				ois.close(); // se tuvo que poner esto sino saltaba null pointer en caso de leer archivo inexistente
			}
			
		}

	}

	public void modificarUsuario() {

		Usuario e = null;
		System.out.println("Ingrese el usuario a modificar:");
		Scanner scanner = new Scanner(System.in); // Scanner para username
		Console console = System.console();
		String username = null;
		username = scanner.next(); // Guarda Username

		for (Usuario array : usuarios) {

			String nombre = array.getNombre();

			if (nombre.equals(username)) {

				e = array;
				usuarios.remove(e);

			} else {
				System.out.println("No existe el usuario, ingrese uno valido:");
			}
		}
		int opcion = 0;
		System.out.println("1-Modificar Usuario");
		System.out.println("2-Modificar Password");
		System.out.println("Ingrese una opcion:");
		opcion = scanner.nextInt(); // Guarda opcion
		if (opcion == 1) {
			System.out.println("Ingrese nuevo usuario");
			String username2 = null;
			username2 = scanner.next(); // Guarda Username
			e.setNombre(username2);
		}
		if (opcion == 2) {
			System.out.println("Ingrese nueva Password");
			String pass = null;
			pass = Hash.sha1(scanner.next()); // Encripto Pass
			e.setPassword(pass);

		}
		cargarUsuario(e);
		try {
			pasarToarchivo();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// scanner.close();
	}

	public void listarUsuarios() {
		System.out.println("------------- USUARIOS -------------");
		for (Usuario us : usuarios) {
			us.mostrarUsuario();
			System.out.println("///////////////////////");
		}
	}

	// hacer borrar usuario
}
