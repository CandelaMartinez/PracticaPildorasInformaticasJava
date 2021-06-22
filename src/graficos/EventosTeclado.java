package graficos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class EventosTeclado {

	public static void main(String[] args) {
		MarcoConTeclas mimarco= new MarcoConTeclas();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoConTeclas extends JFrame {
	public MarcoConTeclas() {
		
		setBounds(300, 300, 500, 300);
		setVisible(true);
		
		//indicamos quien es el objeto oyente
		EventoDeTeclado tecla=new EventoDeTeclado();
		//ponemos el obj a la escucha de los eventos del teclado
		addKeyListener(tecla);
	}
}

//crear un oyente para que detecte las teclas que pulsamos
//como tiene que estar a la escucha de que suceda un evento de teclado, implementa la interface KeyListener
class EventoDeTeclado implements KeyListener{

	//desencadena la accion cuando ta pulse y levante
	@Override
	public void keyTyped(KeyEvent e) {
	    char letra=e.getKeyChar();
		System.out.println(letra);
	}

	//desencadena la accion cuando pulso la tecla
	@Override
	public void keyPressed(KeyEvent e) {
		
		//metodo de la clase KeyEvent que me da el valor numerico de la tecla
	 int codigo=e.getKeyCode();
	 System.out.println(codigo);
		
	}

	//desencadena la accion cuando suelto la tecla
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
}