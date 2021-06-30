package practicaSwing;
import javax.swing.*;
public class AplicacionDialogos {

	//creo marco
	//lamina principal superior: GridLayout, con laminas BoxLayout dentro
	//creo clase que cree cajas: BoxLayout, con titulo y componentes del tipo radioButton (!= cantidad ), center
	//lamina inferior con boton de mostrar, borderLayout.south
	
	//funcionalidad boton de mostrar: que opcion he seleccionado en cada uno de los boxes 
	//desencadene esa accion de comando
	
	//gestionar el box mensaje: cambiar el tipo de mensaje: icono del JOptionPane
	
	//gestionar el box confirmar: gestionar el tipo de botones siempre que elijamos la opcion de confirmar
	
	//gestionar el box de opciones
	
	//gestionar el box opcion entrada
	
	
	
	public static void main(String[] args) {
		//instancio el marco.....................................................
		MarcoDialogos miMarco= new MarcoDialogos();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		miMarco.setVisible(true);
		
		
		
		
	}

	
	
	
}
