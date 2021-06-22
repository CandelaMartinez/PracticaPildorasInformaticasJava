package graficos;


import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class EventosRaton2 {

	public static void main(String[] args) {
		MarcoRaton2 mimarcos= new MarcoRaton2();
		mimarcos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoRaton2 extends JFrame {
	public MarcoRaton2() {
		
		setBounds(300, 300, 500, 300);
		setVisible(true);
		
		//el oyente sera el marcos
		//pongo el marco a la escucha
		//cada vez que haga algo en el marcos me desencadena la accion
		EventosDeRaton2 EventoRaton = new EventosDeRaton2();
		addMouseMotionListener(EventoRaton);
		
	}
}

class EventosDeRaton2 implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("estas arrastrando el raton");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("estas moviendo el raton");
		
	}
	
}