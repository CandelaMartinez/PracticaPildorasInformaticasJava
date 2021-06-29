package graficos;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//slider que cambia el tamaño de la letra

public class C97MarcoSlider {

	public static void main(String[] args) {
		FrameSliders mimarco=new FrameSliders();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameSliders extends JFrame{
	public FrameSliders() {
		setBounds(550,400,550,350);
		setVisible(true);
		
		LaminaSliders milamina=new LaminaSliders();
		add(milamina);
	}
}

class LaminaSliders extends JPanel{
	public LaminaSliders() {
		
		setLayout(new BorderLayout());
		rotulo= new JLabel("en un lugar de la tierra...");
		add(rotulo,BorderLayout.CENTER);
		
		//slider con sus caract, agregar el slider a la 2 lamina y agregar la 2 lamina arriba de la principal
		control=new JSlider(8,50,12);
		control.setMajorTickSpacing(20);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		control.setFont(new Font("Serif",Font.ITALIC,10));
		
		JPanel laminaSlider=new JPanel();
		laminaSlider.add(control);
		
		//ponerlo a la escucha con addChangedListener con parametro de tipo changedListener
		control.addChangeListener(new EventoSlider());
		
		add(laminaSlider, BorderLayout.NORTH);
		
		
		
	}
	

	
	//clase interna de eventos con interface ChangeListener y sus metodos
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			
			//getValue() que me coja el valor del control para el tamaño
			rotulo.setFont(new Font("Serif",Font.PLAIN,control.getValue()));
			
		}
		
	}
	
	//variables de clase
	private JLabel rotulo;
	private JSlider control;

}