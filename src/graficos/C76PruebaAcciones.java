package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class C76PruebaAcciones {

	public static void main(String[] args) {
		MarcoAccion marcos= new MarcoAccion();
		marcos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcos.setVisible(true);
		

	}

}
class MarcoAccion extends JFrame{
	
	public MarcoAccion() {
		setTitle("Prueba acciones");
		setBounds(600,350,600,300);
		
		PanelAccion lamina= new PanelAccion();
		add(lamina);
	}
	
}

//lamina
class PanelAccion extends JPanel{

	//contructor 
	public PanelAccion() {
		//instancio la clase oyente para decir quien es la fuente del evento y poner el objeto oyente a la escucha
		//creo el objeto ImageIcon para indicar donde esta la ruta del icono
		AccionColor accionAmarillo= new AccionColor("amarillo",new ImageIcon("src/graficos/bolaAmarilla.gif"), Color.YELLOW);
		AccionColor accionAzul= new AccionColor("azul",new ImageIcon("src/graficos/bolaAzul.png"), Color.BLUE);
		AccionColor accionRojo= new AccionColor("rojo",new ImageIcon("src/graficos/bolaRoja.gif"), Color.RED);
		
		
		
		//instancio objetos boton usando otro de los constructores de la clase JButton
		//parametro objeto de la clase Action
		JButton botonAmarillo= new JButton(accionAmarillo);
		add(botonAmarillo);
		
		JButton botonAzul= new JButton(accionAzul);
		add(botonAzul);
		
		//otra forma mas sintetica de hacerlo
		add(new JButton(accionRojo));
		
		//MULTIPLES FUENTES: 1 creo mapa de entrada: objeto foco que recibe los cambios por la combinacion de teclas
		//getInputMap devuelve un objeto del tipo InputMap
		//pertenece a la clase JComponent
		//argumento usa constante de clase del tipo entero que establece la condicion 
		//devuelve un InputMap que es usado durante la condicion
		//el objeto que va a recibir la combinacion de teclas (boton) estara en el objeto que tiene el foco
		InputMap mapaEntrada= getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		//MULTIPLES FUENTES: 2 crear la combinacion de teclas con la clase KeyStroke
		//parse un String que le pasamos por parametro a KeyStroke
		//tiene que llevar un modificador (ctrl alt , etc) mas caracter unicode
		//es metodo static por eso uso el nombre de la clase delante
		KeyStroke teclaAmarilla= KeyStroke.getKeyStroke("ctrl A");
		
		//MULTIPLES FUENTES: 3 asigno la combinacion de teclas a un evento
		//metodo put perteneciente a la clase InputMap
		//para acceder al metodo uso una instancia de clase
		//argumentos: combinacion de teclas y objeto al que quiero asignar esa combinacion de teclas(la invento)
		mapaEntrada.put(teclaAmarilla, "fondoAmarillo");
		
		//MULTIPLES FUENTES: 4 asignar el objeto a la accion
		//clase ActionMap y metodo put
		//creamos una instancia de la clase ActionMap
		//uso el metodo put desde la instancia
		//parametros: evento, accion creada
		ActionMap mapaAccion= getActionMap();
		mapaAccion.put("fondoAmarillo", accionAmarillo);
	
		
		//hacemos lo mismo para el resto de los colores pero de una forma mas simplificada
		//en el caso del azul estableci dos atajos de teclado
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondoAzul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl L"), "fondoAzul");
		mapaAccion.put("fondoAzul", accionAzul);
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondoRojo");
		mapaAccion.put("fondoRojo", accionRojo);
	
		}
	
	
	
	//CLASE OYENTE
	//clase interna para poder usar el metodo setBackground() que pertenece a JPanel
	//poner a la lamina a la escucha para que cuando presione un boton cambie de color
	//creo una clase que implemente la interface Action o herede de la clase AbstractAction
	//evito tener que programar todos los metodos correspondientes a la clase Action
	//este metodo implementa 6 de los 7 metodos que la interface Action le obliga
	//solo tengo que implementar el metodo actionPerformed() que es el que falta

	class AccionColor extends AbstractAction{
		
		//constructor que sea encargado de realizar varias cosas con el objeto fuente, botones
		public AccionColor(String nombre, Icon icono, Color colorBoton) {
			//que voy a almacenar del objeto fuente
			//nombre de la fuente: constante NAME: valor que paso por parametro
			putValue(Action.NAME, nombre);
			
			//icono de la fuente:
			putValue(Action.SMALL_ICON, icono);
			
			//descripcion
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color "+ nombre);
			
			//accion del boton
			//en clave no uso una constante de la clase Action sino que la invento yo
			putValue("colorFondo", colorBoton);
			
		}

		//para que funcionen los botones le tengo que decir que tiene que hacer aqui en este metodo
		@Override
		public void actionPerformed(ActionEvent e) {
			//devuelve un objeto. entonces si lo quiero convertir a tipo color hago un casting
			Color c=(Color) getValue("colorFondo");
			//poner la lamina del color c, es un metodo de JPanel asi que para usarlo esta tiene que ser una clase interna de la clase que herede de JPanel
			setBackground(c);
			
			//rescatamos con getValue el nombre y la descripcion del boton que estamos usando
			System.out.println("Nombre: "+getValue(Action.NAME)+ " Descripcion: "+getValue(Action.SHORT_DESCRIPTION));
		}
		
	}
	
	
}
