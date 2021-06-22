package primerosPasos;

import javax.swing.*;

public class ForFactorial {

	public static void main(String[] args) {
		// factorial: 6F es 6*6*5*4*3*2*1

		long resultado = 1L;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("introduce el numero"));

		for (int i = numero; i > 0; i--) {
			resultado = resultado * i;

		}

		System.out.println("el factorial de " + numero + " es: " + resultado);

	}

}
