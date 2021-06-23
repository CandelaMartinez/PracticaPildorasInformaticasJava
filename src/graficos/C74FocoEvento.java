package graficos;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class C74FocoEvento {

	public static void main(String[] args) {
		MarcoFoco mimarco=new MarcoFoco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoFoco extends JFrame{
	public MarcoFoco() {
		setBounds(300, 300, 500, 300);
		setVisible(true);
	
		add(new LaminaFoco());
	}
}

class LaminaFoco extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//invalidar el layout, posicionamiento por defecto
		//a partir de ahora coloco los elementos donde quiera
		setLayout(null);
		
		//instancio las variables 
		//usando el constructor por defecto de la clase
		cuadro1 =new JTextField();
		cuadro2=new JTextField();
		
		//doy tamaño y posicion al cuadro de texto
		cuadro1.setBounds(120, 10, 150, 20);
		cuadro2.setBounds(120, 50, 150, 20);
		
		//los agrego a la lamina
		add(cuadro1);
		add(cuadro2);
		
		//cual de los dos componentes es el que va a estar a la escucha
		//crear una instancia de la clase oyente
		LanzaFocos elFoco=new LanzaFocos();
		//lo pongo a la escucha
		cuadro1.addFocusListener(elFoco);
	}
	
	//creo variables objeto de la clase JTextField
	//declare las variables fuera del ambito paintComponent para poder acceder desde otros lugares
	//es ambito de clase
	JTextField cuadro1;
	JTextField cuadro2;
	
	
	//clase oyente
	//creo la clase oyente que implementa la interface FocusListener
	//como clase interna para poder acceder a los objetos cuadro1 y cuadro2 porque pertenecen a la clase padre
	private class LanzaFocos implements FocusListener{

		//si un objeto que esta a la escucha gana el foco se ejecuta este metodo
		@Override
		public void focusGained(FocusEvent e) {
			System.out.println("He ganado el foco");
			
		}
		//si un objeto que esta a la escucha pierde el foco se ejecuta este metodo
		@Override
		public void focusLost(FocusEvent e) {
			//capturo el texto, metodo de la clase GetTextField
			String email=cuadro1.getText();
			
			boolean comprobacion=false;
			
			//veo si hay un @
			for(int i=0;i<email.length();i++) {
				if(email.charAt(i)=='@') {
					comprobacion=true;
				}
			}
			
			if(comprobacion) {
				System.out.println("Mail Correcto");
			}else {
				System.out.println("Mail Incorrecto");
			}
			
		}
		
	}
	
}



