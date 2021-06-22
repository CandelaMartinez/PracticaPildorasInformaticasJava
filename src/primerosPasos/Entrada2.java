package primerosPasos;

import javax.swing.JOptionPane;

public class Entrada2 {
	public static void main(String[] args) {
		// clase JOptionPane. javax.swing hay que importar este paquete
		// construye una ventana con el metodo showInputDialog()
		// showInputDialog(): estatico.no hay que instanciar la clase Joptionpane(no hay
		// que crear un objeto)
        //hay que usar el nombre de la clase.metodo
		// recibe un objeto string, devuelve un string, (message)

		//variable nombre_usuario = almacena lo que me entra el usuario cuando ejecuto el metodo (parametro que le paso)
		String nombre_usuario = JOptionPane.showInputDialog("introduce tu nombre: ");
		
		//la variable edad debe almacenarse en un String ya que el metodo devuelve un String
		String edad = JOptionPane.showInputDialog("introduce tu edad: ");

		System.out.println(
				"hola " + nombre_usuario + " tienes " + edad + " años" + " el año proximo tendras " + (edad + 1));
		// a edad lo considera un texto String asi que me da "441" string
		// tenemos que transformar la edad de string a int 
		// metodo parseInt(valorquequieropasar)
		// pertenece a la clase Integer. devuelve un entero.
		// es estatico: tengo que usar el nombre de la clase delante del metodo
		// no tengo que crear un objeto de la clase para usar el metodo
		// me pide como parametro un dato string

		// declaro una variable int con metodo parseInt (parametro que le paso)
		// meti en la variable edad_usuario un entero que esta almacenado en el string
		// edad
		int edad_usuario = Integer.parseInt(edad);

		System.out.println("hola " + nombre_usuario + " tienes " + edad + " años" + " el año proximo tendras "
				+ (edad_usuario + 1));

		// antes de usar la edad_usuario se incrementa en 1
		edad_usuario++;
		System.out.println(
				"hola " + nombre_usuario + " tienes " + edad + " años" + " el año proximo tendras " + edad_usuario);

	}

}
