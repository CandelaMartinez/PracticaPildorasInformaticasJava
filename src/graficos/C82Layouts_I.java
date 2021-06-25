package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C82Layouts_I {

	public static void main(String[] args) {
		MarcoLayout2 marco= new MarcoLayout2();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoLayout2 extends JFrame{
	public MarcoLayout2() {
		setTitle("Prueba Acciones");
		setBounds(600,350,600,300);
		
		PanelLayout2 lamina= new PanelLayout2();
		
		add(lamina);
	}
	
}

class PanelLayout2 extends JPanel{
	public PanelLayout2() {
		
		//establezco separacion horizontal y vertical en pixeles
		//dentro del constructor de la lamina
		//setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		
		//establezco la nueva posicion
		setLayout(new BorderLayout(10,10));
		
		//le indico a cada uno de los elementos donde se tienen que colocar
		//con el metodo add de JPanel, con segundo argumento: posicion
		add (new JButton("amarillo"),BorderLayout.NORTH);
		add (new JButton("rojo"),BorderLayout.SOUTH);
		add (new JButton("azul"),BorderLayout.WEST);
		add (new JButton("verde"),BorderLayout.EAST);
		add (new JButton("negro"),BorderLayout.CENTER);
		
	}
	
}