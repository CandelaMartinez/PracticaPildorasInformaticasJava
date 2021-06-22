package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos2 {

	public static void main(String[] args) {
		MarcoBotones2 mimarco = new MarcoBotones2();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

//creo marco con lamina agregada
class MarcoBotones2 extends JFrame {
	public MarcoBotones2() {
		setTitle("Botones y Eventos");
		setBounds(700, 300, 500, 300);
		LaminaBotones2 milamina = new LaminaBotones2();
		add(milamina);

	}

}

//creo lamina que agrego al marco

class LaminaBotones2 extends JPanel {

	// construir boton- OBJETO FUENTE
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");

	// constructor
	public LaminaBotones2() {

		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		//instanciar color fondo, creo lo objetos que seran oyentes
		ColorFondo amarillo= new ColorFondo(Color.YELLOW);
		ColorFondo azul= new ColorFondo(Color.BLUE);
		ColorFondo rojo= new ColorFondo(Color.RED);

		//vinculamos el objeto fuente con el objeto oyente
		 botonAzul.addActionListener(azul);
		 botonAmarillo.addActionListener(amarillo);
		 botonRojo.addActionListener(rojo);

	}
	
	
	// setBackground pertenece a la clase JPane, si lo quiero usar la clase debe ser
	// clase interna de clase Lamina
	// creo objeto color de fondo OBJETO OYENTE
	private class ColorFondo implements ActionListener {

		// constructor
		public ColorFondo(Color c) {
			colorDeFondo = c;
		}

		// variable encapsulada tipo objeto Color
		private Color colorDeFondo;

		// metodo actionPerformed que me obliga a implementar la interface
		// ActionListener
		// por ser el color de fondo el objeto oyente

		
		@Override
		public void actionPerformed(ActionEvent e) {
			setBackground(colorDeFondo);

		}

	}

}
