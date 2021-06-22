package graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class EventosVentana {

	public static void main(String[] args) {
		
		//dispose on close: solo me cierra la ventana
		MarcoVentana mimarco = new MarcoVentana();
	
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setTitle("Ventana 1");
		mimarco.setBounds(300, 300, 500, 350);
		
		MarcoVentana mimarco2 = new MarcoVentana();
		
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mimarco2.setTitle("Ventana 2");
		mimarco2.setBounds(900, 300, 500, 350);
	}

}

//creo marco con lamina agregada
class MarcoVentana extends JFrame {
	public MarcoVentana() {
		//setTitle("Respondiendo");
		//setBounds(700, 300, 500, 300);
		setVisible(true);
		
		//crear instancia de la clase oyente y decirle que este preparado para llamar a esa instancia
		MVentana oyenteVentana= new MVentana();
		
		//poner el marco a la escucha de que se produzca un evento del tipo ventana
		addWindowListener(oyenteVentana);
		
		
		}

}

//crear clase oyente con interface WindowsListener y metodos implementados

class MVentana implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Ventana Abierta");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Ventana Cerrandose");
		
	}

	//solo se ejecuta cuando cierro la ventana2 porque cuando cierro la ventana1 el programa termina y no se ve
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("La ventana ha sido cerrada");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana Minimizada");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana Restaurada");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana Activada");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana Desactivada");
		
	}
	
	
	
	
}