package graficos;

import java.awt.Font;

import javax.swing.*;

public class C96MarcoSlider {

	public static void main(String[] args) {
		FrameSlider mimarco=new FrameSlider();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameSlider extends JFrame{
	public FrameSlider() {
		setBounds(550,400,550,350);
		LaminaSlider milamina=new LaminaSlider();
		add(milamina);
		setVisible(true);
	}
	
	
}

class LaminaSlider extends JPanel{
	public LaminaSlider() {
		
		//crear un Slider:sobrecarga de constructores API
		// valor min, max  y donde aparece el slider
		
		JSlider control=new JSlider(0,200,25);
		
		//en metodo: constante para vertical,
		//control.setOrientation(SwingConstants.VERTICAL);
		
		//seteo las marcas mayores y menores
		control.setMajorTickSpacing(50);
		control.setMinorTickSpacing(25);
		//imprima las marcas
		control.setPaintTicks(true);
		
		
		//modifico la fuent de los numeros
		control.setFont(new Font("Serif",Font.PLAIN,8));
		
		//rotulos, numeros
		control.setPaintLabels(true);
		
		//comportamiento del slider:puedo hacer que los valores numericos funcionen como iman
		control.setSnapToTicks(true);
		
		add(control);
		
		
		
	}
}