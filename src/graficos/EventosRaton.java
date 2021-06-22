package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class EventosRaton {

	public static void main(String[] args) {
		MarcoRaton mimarcos= new MarcoRaton();
		mimarcos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoRaton extends JFrame {
	public MarcoRaton() {
		
		setBounds(300, 300, 500, 300);
		setVisible(true);
		
		//el oyente sera el marcos
		//pongo el marco a la escucha
		//cada vez que haga algo en el marcos me desencadena la accion
		EventosDeRaton EventoRaton = new EventosDeRaton();
		addMouseListener(EventoRaton);
		
	}
}

//crear la clase que implemente la interface MouseListener
//objeto evento
/*class EventosDeRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Haz hecho click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Acabas de presionar el raton");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("acabas de levantar el dedo del raton");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entraste en el cuadro");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("saliste del cuadro");
		
	}
	
}*/


//en lugar de implementar la Interface MouseListener hago que herede de la clase adaptadora y asi tendria los metodos necesarios
class EventosDeRaton extends MouseAdapter{
	
	public void mouseClicked(MouseEvent e) {
		
		//uso los metodos de la clase MouseEvent desde un objeto de esa clase
		//accedemos a los campos de ejemplar de la clase MouseEvent de ese objeto e
		System.out.println("Coordenada x:"+e.getX()+ " Coordenada Y:"+ e.getY());
		
		//numero de clicks seguidos
		System.out.println("Haz hecho click "+e.getClickCount()+ " veces");
		
		//ver que tecla del raton o rueda apretaron	
		
		}
	
	public void mousePressed(MouseEvent e) {
		
		//metodo de la clase MouseEvent que me devuelve el valor de las constantes de clase
		
		int click= e.getModifiersEx();
		
		if(click==MouseEvent.BUTTON1_DOWN_MASK) {
		System.out.println("Haz hecho click en el boton izquierdo del raton ");
	}else if (click==MouseEvent.BUTTON3_DOWN_MASK) {
		System.out.println("Haz hecho click en el boton derecho del raton");
	}else if (click==MouseEvent.BUTTON2_DOWN_MASK) {
		System.out.println("Haz hecho click la rueda del raton");
	}
		
		//saber si estoy arrastrando el raton con el click pulsado
		//usamos la interface MouseMotionListener
		
	}
}