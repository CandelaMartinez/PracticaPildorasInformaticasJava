package primerosPasos;

import java.util.Scanner;

public class Entrada1 {
	public static void main(String[] args) {

		// nextLine() introducimos texto
		// nextInt() introducimos enteros
		// nextDouble() introducimos doubles

		// no son estaticos, no pongo el nombre de la clase antes
		// tengo que crear antes un objeto perteneciente a la clase Scanner delante del
		// metodo

		// uso el constructor scanner(crea objeto) lo meto en una variable scanner y le
		// digo
		// como parametro() que use la consola para entrar informacion
		// para usar el constructor hay que usar delante la palabra new

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce tu nombre");

		// ahora tengo que especificarle que tipo de dato voy a introducir por consola
		// para almacenarlo en una variable

		// metodo nextline (devuelve string)
		// al metodo nexLine hay que ponerle delante el objeto que cree

		String nombre_usuario = entrada.nextLine();
		// la consola del sistema (entrada) se queda a la espera de que ingrese un
		// string para almacenarlo en nombre_usuario

		System.out.println("introduce edad ");

		int edad = entrada.nextInt();
		// la consola entrada se queda a la espera de un entero
		// cuando lo reciba lo almacenara dentro de la variable edad
		
		System.out.println("hola " + nombre_usuario + " el año que viene tendras " + (edad + 1) + " años ");

		entrada.close();

	}

}
