package primerosPasos;
import javax.swing.*;
public class While1AdivinaClave {

	public static void main(String[] args) {
		//acceso aplicacion con clave
		
		String clave="Can";
		
		String pass="";
		
		
		//equals es un metodo de la clase String que compara 2 cadenas de texto para ver si son iguales
		//mientras clave no es igual (==false) a pass: repetir el bucle
		//cambio el valor de la variable con algo que pone el usuario
		while (clave.equals(pass)==false){
			pass= JOptionPane.showInputDialog("introduce la contraseña: ");
			
			if (clave.equals(pass)==false) {
				System.out.println("contraseña incorrecta");
			}
			
		}

		
		System.out.println("contraseña correcta, acceso permitido");
	}

}
