package app;

import java.io.Console;
import java.util.Scanner;

import clases.Hash;
import clases.Login;

public class Main {

	public static void main(String[] args) {
	
		Login login=new Login();
		login.nuevoUsuario();
		login.nuevoUsuario();
		login.mostrarUsuarios();
		login.Loguear();
	}
}
