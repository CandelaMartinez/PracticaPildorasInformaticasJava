package graficos;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;



public class C99ClaseAnonima {



	public static void main(String[] args) {
		FrameSpinner2 mimarco=new FrameSpinner2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class FrameSpinner3 extends JFrame{
	public FrameSpinner3() {
		setBounds(550,350,550,350);
		setVisible(true);
		add(new LaminaSpinner3());
	}
	
	
}

class LaminaSpinner3 extends JPanel{
	public LaminaSpinner3() {
		
		
		
		//clase interna anonima: mismo ejemplo que archivo anterior
		//tiene menos lineas de codigo
		//puedo aplicar las clases internas anonimas en todos lo eventos de swing
		JSpinner control=new JSpinner(new SpinnerNumberModel(5,0,10,1) {
			
					
				
				public Object getNextValue() {
					
					return super.getPreviousValue();
					
					
				}
				
				
				public Object getPreviousValue() {
					
					return super.getNextValue();
				}
				
				
		});
		
		
		//cambio el tamaño por defecto del cuadro, setPreferedSize(Dimension d)
		Dimension d=new Dimension(150,20);
		control.setPreferredSize(d);
		
		add(control);
		
	}
	
}
