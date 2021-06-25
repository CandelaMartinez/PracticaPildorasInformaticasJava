package graficos;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C81Layouts_I {

	public static void main(String[] args) {
		MarcoLayout marco= new MarcoLayout();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoLayout extends JFrame{
	public MarcoLayout() {
		setTitle("Prueba Acciones");
		setBounds(600,350,600,300);
		PanelLayout lamina= new PanelLayout();
		//antes de agregar la lamina tengo que decir la disposicion que tendran los elementos en la misma
		FlowLayout disposicion= new FlowLayout(FlowLayout.LEFT);
		//metodo setLayout, perteneciente a la clase JPanel, lo uso desde una instancia de clase
		lamina.setLayout(disposicion);
		
		add(lamina);
	}
	
}

class PanelLayout extends JPanel{
	public PanelLayout() {
		add (new JButton("amarillo"));
		add (new JButton("rojo"));
		add (new JButton("azul"));
		
	}
	
}