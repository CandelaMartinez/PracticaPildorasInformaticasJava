package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class CambioEstado {

	public static void main(String[] args) {
		MarcoEstado mimarco = new MarcoEstado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoEstado extends JFrame {
	public MarcoEstado() {
		
		setBounds(300, 300, 500, 300);
		setVisible(true);
		
		//creo instancio oyente y la vinculo con el objeto fuente
		Cambio nuevoEstado= new Cambio();
		addWindowStateListener(nuevoEstado);
		
		}

}

//creo clase OYENTE con interface implementada para escuchar si la ventana cambia de estado

class Cambio implements WindowStateListener{

	@Override
	public void windowStateChanged(WindowEvent e) {
		//System.out.println("La ventana ha cambiado de estado");
		
		//metodo de la clase WindowEvent, estado nuevo de la ventana, static
		//devuelve numeros, constantes de la clase Frame
		//System.out.println(e.getNewState());
		
		
		if(e.getNewState()==Frame.MAXIMIZED_BOTH) {
			System.out.println("La ventana se ha maximizado a pantalla completa");
		}else if(e.getNewState()==Frame.NORMAL) {
			System.out.println("La ventana esta en estado normal");
		}else if (e.getNewState()==Frame.ICONIFIED) {
			System.out.println("La ventana esta minimizada");
		}
		
		
	}
	
	
	
}