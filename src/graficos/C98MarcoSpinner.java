package graficos;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class C98MarcoSpinner {

	public static void main(String[] args) {
		FrameSpinner mimarco=new FrameSpinner();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class FrameSpinner extends JFrame{
	public FrameSpinner() {
		setBounds(550,350,550,350);
		setVisible(true);
		add(new LaminaSpinner());
	}
	
	
}

class LaminaSpinner extends JPanel{
	public LaminaSpinner() {
		
		//constructor por defecto: valores numericos
		//JSpinner control=new JSpinner();
		
		
		
		//Spinner Model: fechas, listas(array)
		//JSpinner control=new JSpinner(new SpinnerDateModel());
		
		
		//spiner de lista: crear el array que contiene como parametro
		
		//String [] lista= {"enero","febrero","marzo","abril"};
		
		//array todas las fuentes que tengo instaladasen mi ordenador
		//String[] lista= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		                         
		//JSpinner control=new JSpinner(new SpinnerListModel(lista));
		
		//Objeto que me permite cambiar los parametros: valor inicial, minimo, maximo y de cuanto en cuanto va
		JSpinner control=new JSpinner(new SpinnerNumberModel(5,0,10,1));
		
		
		//cambio el tamaño por defecto del cuadro, setPreferedSize(Dimension d)
		Dimension d=new Dimension(150,20);
		control.setPreferredSize(d);
		
		add(control);
		
	}
	
	
}