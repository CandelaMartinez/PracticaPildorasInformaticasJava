package primerosPasos;

import java.util.Scanner;

public class If {
	public static void main(String[] args) {
		// creamos un objeto scanner usando el constructor para entrar datos
		Scanner entrada = new Scanner(System.in);

		System.out.println("introduce tu edad ");

		// almacenamos en una variable la edad que el usuario introduzca
		// edad = entrada(consola) siguiente entero
		int edad = entrada.nextInt();

		// evaluar la edad

		if (edad >= 18) {
			System.out.println("eres mayor");
		} else {
			System.out.println("eres menor");
		}

		entrada.close();
	}
}
