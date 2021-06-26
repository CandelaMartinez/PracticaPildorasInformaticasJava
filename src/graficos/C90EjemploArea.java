package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class C90EjemploArea {
	
	//cuadro de texto y boton de enviar, que hace que el texto aparezca en consola

	public static void main(String[] args) {
		MarcoArea mimarco= new MarcoArea();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoArea extends JFrame{
	public MarcoArea() {
		setBounds(500,300,500,350);
		LaminaArea milamina=new LaminaArea();
		add(milamina);
		setVisible(true);
	}
	
	
}

class LaminaArea extends JPanel{
	
	private JTextArea miarea;
	public LaminaArea() {
		//area de texto, por defecto va creciendo a medida que agrego texto para ajustarse
		//puedo cambiarlo y hacer que tenga saltos de linea automaticos, setLineWrap(bool)
		//pero sigue creciendo a lo alto, puedo hacer que salga una barra de desplazamiento
		//puedo crear una lamina, meterlo en la lamina y que la lamina tenga el comportamiento de barras de scroll
		miarea= new JTextArea(8,20);
		
		//lamina de scroll, pongo lo que quiero agregar dentro
		JScrollPane laminaBarras=new JScrollPane(miarea);
		
		//seteo saltos de linea fijos
		miarea.setLineWrap(true);
		//agrego la lamina de scroll con el area de texto dentro
		add(laminaBarras);
		
		//boton de enviar
		JButton miboton =new JButton("Click");
		//mi boton tiene que estar a la escucha del evento
		miboton.addActionListener(new GestionaArea());
		
		add(miboton);
		
	}
	
	//clase interna para gestionar el evento
	private class GestionaArea implements ActionListener{

		//rescate el texto del area de texto y lo imprima en consola
		@Override
		public void actionPerformed(ActionEvent e) {
		 System.out.println(miarea.getText());
			
		}
		
	}
	
}