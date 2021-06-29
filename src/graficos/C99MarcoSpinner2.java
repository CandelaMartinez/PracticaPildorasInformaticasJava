package graficos;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class C99MarcoSpinner2 {

	public static void main(String[] args) {
		FrameSpinner2 mimarco=new FrameSpinner2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class FrameSpinner2 extends JFrame{
	public FrameSpinner2() {
		setBounds(550,350,550,350);
		setVisible(true);
		add(new LaminaSpinner2());
	}
	
	
}

class LaminaSpinner2 extends JPanel{
	public LaminaSpinner2() {
		
		
		
		//Creo objeto donde instancio mi propio modelo de spinner que se comporta de forma contraria en sus flechas
		JSpinner control=new JSpinner(new MiModeloJS());
		
		
		//cambio el tamaño por defecto del cuadro, setPreferedSize(Dimension d)
		Dimension d=new Dimension(150,20);
		control.setPreferredSize(d);
		
		add(control);
		
	}
	//creo mi pripio modelo de spinner en una clase interna, que herede del SpinnerNumberModel
	//quiero cambiar el comportamiento de las flechas
	private class MiModeloJS extends SpinnerNumberModel{
		
	 
		public MiModeloJS() {
			//llamo al constructor de la clase padre, spinnernumbermodel
			super(5,0,10,1);
			}
		
		//sobreescribo metodos que heredo de la clase SpinnerNumberModel para cambiar comportamiento
		//este metodo que por defecto devuelve el valor siguiente, tiene que devolver el valor previo
		public Object getNextValue() {
			
			return super.getPreviousValue();
			
			
		}
		//lo mismo con el otro metodo
		
		public Object getPreviousValue() {
			
			return super.getNextValue();
		}
		
		}
	}
