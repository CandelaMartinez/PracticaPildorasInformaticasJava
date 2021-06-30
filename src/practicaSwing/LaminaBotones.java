package practicaSwing;

import javax.swing.*;

public class LaminaBotones extends JPanel{
	
	//variables de clase
	ButtonGroup grupo;

	//constructor para crear las cajas que van dentro de la lamina con grid 
	public LaminaBotones(String titulo, String [] opciones) {
		
		//creo bordes, metodo static(tipo de borde, titulo)
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
				
		//indico a la lamina que tipo de Layout tiene
		//(componente padre, tipo de disposicion constante static de clase)
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//radioButton
		grupo= new ButtonGroup();
		
		//recorro el array opciones para ver la cantidad de botones a crear
		for( int i=0; i<opciones.length;i++) {
			//texto que haya en la posicion del array elegida
			JRadioButton bot= new JRadioButton(opciones[i]);
			
			//el texto de la accion de comandos sera el contenido del array de string
			bot.setActionCommand(opciones[i]);
			
			
			add(bot);
			grupo.add(bot);
			
			//para que aparezca el primero seleccionado
			bot.setSelected(i==0);
			
		}
		
	}
	
	
	//metodo que devuelve un String con las opciones seleccionadas
	public String dameSeleccion() {
		
		//devuelve un objeto del tipo ButtonModel, el boton seleccionado
		ButtonModel miboton= grupo.getSelection();
		
		//devuelve el string que esta en el boton seleccionado
		String s=miboton.getActionCommand();
		
		return s;
	
		
	}
	
	
}
