package graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class C69EventosVentana2 {

	public static void main(String[] args) {
		
		//dispose on close: solo me cierra la ventana
		MarcoVentana2 mimarco = new MarcoVentana2();
	
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setTitle("Ventana 1");
		mimarco.setBounds(300, 300, 500, 350);
		
		MarcoVentana2 mimarco2 = new MarcoVentana2();
		
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mimarco2.setTitle("Ventana 2");
		mimarco2.setBounds(900, 300, 500, 350);
	}

}

//creo marco 
class MarcoVentana2 extends JFrame {
	public MarcoVentana2() {
		//setTitle("Respondiendo");
		//setBounds(700, 300, 500, 300);
		setVisible(true);
		
		
		//poner el marco a la escucha de que se produzca un evento del tipo ventana
		//dentro instancio el objeto oyente
		addWindowListener(new MVentana2());
		
		
		}

}

//en vez de implementar la interface WindowsListener que estoy obligada a implementar por ser oyente
//heredo de la clase adaptadora y como la clase adaptadora ya tiene la interface con sus metodos implementados
//mi clase hereda sus metodos y no necesita implementarlos porque ya los tiene

class MVentana2 extends WindowAdapter{


	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana Minimizada");
		
	}


	
	
	
	
}