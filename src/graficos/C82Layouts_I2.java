package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C82Layouts_I2 {

	public static void main(String[] args) {
		MarcoLayout3 marco= new MarcoLayout3();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoLayout3 extends JFrame{
	public MarcoLayout3() {
		setTitle("Prueba Acciones");
		setBounds(600,350,600,300);
		
		//para que aparezcan las dos laminas le digo al contenedor que disposicion van a tener las laminas
		//posiciono cada lamina dentro del marcos con BorderLayout
		//instancia dentro de marcos perteneciente a la primera lamina
		PanelLayout3 lamina= new PanelLayout3();
		add(lamina,BorderLayout.NORTH);
		
		//instancia dentro del marco perteneciente a la segunda lamina
		PanelLayout3B lamina2 = new PanelLayout3B();
		add(lamina2,BorderLayout.SOUTH);
		
		
	}
	
}

//si quiero establecer dos disposiciones diferentes tengo que usar dos laminas
//una lamina con cada disposicion
class PanelLayout3 extends JPanel{
	public PanelLayout3() {
		
		//posicionamiento
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		add (new JButton("amarillo"));
		add (new JButton("rojo"));
		
		
	}
	
}

//creo otra lamina para poder establecer otra disposicion
class PanelLayout3B extends JPanel{
	
	public PanelLayout3B() {
		
		//posicionamiento
		setLayout(new BorderLayout());
		
		add (new JButton("azul"),BorderLayout.WEST);
		add (new JButton("verde"),BorderLayout.EAST);
		add (new JButton("negro"),BorderLayout.CENTER);
	}
	
	
	
}