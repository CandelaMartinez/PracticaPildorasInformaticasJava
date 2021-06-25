package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//1-primero Layout: lamina(BorderLayout) con otra lamina dentro(GridLayout) center y un boton deshabilidado en north

//2-hacer que al apretar los numeros ese numero aparezca en el display: getText() y setText()
//crear una clase que gestione los eventos con I ActionListener, que me obliga a implementar actionPerformed() con la accion especificada
//hay que poner todos los botones a la escucha, para que desencadene el evento cuando se haga click, llamando al metodo actionPerformed() 
//actionPerformed() escribira el texto del boton pulsado en el display de arriba

public class C83Calculadora {

	public static void main(String[] args) {
		MarcoCalculadora mimarco= new MarcoCalculadora();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

//1-clase construir la interface
class MarcoCalculadora extends JFrame{
	public MarcoCalculadora() {
		
		setTitle("Calculadora");
		
		
		//1-agrego al marco la lamina
		LaminaCalculadora milamina= new LaminaCalculadora();
		add(milamina);
		
		//1-le doy un tamaño por defecto al contenedor adaptado a lo que contiene 
		//no uso el metodo setBounds, de la clase Window,JFrame hereda de la clase Window
		pack();
		
	}
	
}

//1-agregar una lamina y dentro de esta en lazona norte colocar el display y en el centro colocar una segunda lamina
//esta lamina contenedora tendra una disposicion de BorderLayout: un elemento va en north y otro en center
class LaminaCalculadora extends JPanel{
	
	//1-en la zona center una lamina
	//esta lamina sera un gridLayout
	//la declaro fuera del constructor asi puedo usarla en el metodo
	private JPanel milamina2;
	
	//2-declaro fuera del constructor asi puedo usarla en la clase interna
	JButton pantalla;
	
	//variable que uso para detectar si el texto es el primer numero
	//si no se inicia el valor por defecto es false
	private boolean principio;
	
	public LaminaCalculadora() {
		//2
		principio=true;
		//1-disposicion BorderLayout
		setLayout(new BorderLayout());
		//1-en la zona norte un boton, inicializo la variable pantalla
		pantalla=new JButton("0");
		add (pantalla,BorderLayout.NORTH);
		//1-deshabilitar el boton asi se ve mejor la pantalla (ideal hacerlo con un cuadro de texto)
		pantalla.setEnabled(false);
		
		
		//1-inicializo la 2 lamina dentro del constructor
		milamina2= new JPanel();
		
		//1-le digo la disposicion 4 col y 4 filas
		milamina2.setLayout(new GridLayout(4,4));
		
		//2- creo una instancia a la clase InsertaNumero
		ActionListener insertar= new InsertaNumero();
		
		
		
		//1-agregar los botones usando el metodo que cree
		//2-ponerlos a la escucha, agregando la instancia de la clase que cree
		ponerBoton("7", insertar);
		ponerBoton("8", insertar);
		ponerBoton("9", insertar);
		//ponerBoton("/");
		
		ponerBoton("4", insertar);
		ponerBoton("5", insertar);
		ponerBoton("6", insertar);
		//ponerBoton("*");
		
		ponerBoton("1", insertar);
		ponerBoton("2", insertar);
		ponerBoton("3", insertar);
		//ponerBoton("-");
		
		ponerBoton("0", insertar);
		//ponerBoton(".");
		//ponerBoton("=");
		//ponerBoton("+");
		
		
		
		
		
		//1-agregar la 2 lamina en la lamina principal en la zona central
		add(milamina2,BorderLayout.CENTER);
	}
	
	//1-2-agregar los botones y los pongo a la escucha
	//creo un metodo que se encargue de agregar estos botones a la lamina
	private void ponerBoton (String rotulo,ActionListener oyente) {
		JButton boton=new JButton(rotulo);
		//2-pongo el boton a la escucha
		boton.addActionListener(oyente);
		milamina2.add(boton);
	}
	
	//2-creo la clase interna que va a gestionar los eventos
	private class InsertaNumero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//2-capturo el texto del boton pulsado para que luego aparezca el el display 
			String entrada=e.getActionCommand();
			
			//2- que aparezca ese texto en el display
			//debe ser: lo que hay en el display + el nuevo texto
			//tiene que detectar si es el primer numero(0) y borrarlo
			//si principio es verdadero, resetea la pantalla y lo poner en false
			if(principio) {
				pantalla.setText("");
				principio=false;
			}
			pantalla.setText(pantalla.getText()+ entrada);
			
		}
		
	}
	
	
}