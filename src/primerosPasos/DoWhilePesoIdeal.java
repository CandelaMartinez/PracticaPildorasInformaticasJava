package primerosPasos;

import javax.swing.*;

public class DoWhilePesoIdeal {

	public static void main(String[] args) {

		String genero = "";

		do {
			genero = JOptionPane.showInputDialog("Introduce tu genero (H/M)");

		} while (genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") == false);

		// va a seguir repitiendo el do mientras genero sea diferente a H y M en
		// miniscula o mayuscula

		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm: "));

		// showInputDialog devuelve un String asi que lo tengo que convertir a Int para
		// poder hacer el calculo

		int pesoideal = 0;

		if (genero.equalsIgnoreCase("H")) {
			pesoideal = altura - 100;

		} else if (genero.equalsIgnoreCase("M")) {
			pesoideal = altura - 110;

		}

		
		System.out.println("tu peso ideal es: "+pesoideal);
	}
}
