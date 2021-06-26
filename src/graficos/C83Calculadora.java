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

//3- agregar los botones de las operaciones: que esten a la escucha de un evento
//cada vez que pulso una tecla de operaciones no se concatena lo proximo que escribo sino que borra la pantall
//guarde el numero de la pantalla en una variable y que el siguiente sea un numero nuevo y luego hagan la operacion
//declarar una variable resultado donde se vaya acumulando el valor y las operaciones
//declarar una variable operacion donde guarde las operaciones que se vayan clickeando
//declarar una variable para guardar las operaciones para saber si es un =, alli le pasare dentro del ActionPerformed un valor y podre usarlo dentro del metodo calcular

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
	
	//2-3-variable que uso para detectar si el texto es el primer numero
	//si no se inicia el valor por defecto es false
	private boolean principio;
	
	
	//3-declarar una variable donde almaceno el numero de la pantalla y las operaciones clickeadas
	private double resultado;
	
	//3- declarar una variable donde guardo la ultima orden para saber si es un =
	private String ultimaOperacion;
	
	
	
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
		
		//2- creo una instancia a la clase InsertaNumero para pasarla por parametro al metodo ponerBoton
		ActionListener insertar= new InsertaNumero();
		
		//3-creo una instancia de la clase AccionOrden para pasarla por parametro al metodo ponerBoton
		ActionListener orden =new AccionOrden();
		
		
		//1-agregar los botones usando el metodo que cree
		//2-ponerlos a la escucha, agregando la instancia de la clase que cree
		//3-poner los botones de las operaciones matematicas a la escucha e insertarlos
		
		ponerBoton("7", insertar);
		ponerBoton("8", insertar);
		ponerBoton("9", insertar);
		ponerBoton("/",orden);
		
		ponerBoton("4", insertar);
		ponerBoton("5", insertar);
		ponerBoton("6", insertar);
		ponerBoton("*",orden);
		
		ponerBoton("1", insertar);
		ponerBoton("2", insertar);
		ponerBoton("3", insertar);
		ponerBoton("-",orden);
		
		ponerBoton("0", insertar);
		ponerBoton(".",orden);
		ponerBoton("=",orden);
		ponerBoton("+",orden);
		
		
		
		
		
		//1-agregar la 2 lamina en la lamina principal en la zona central
		add(milamina2,BorderLayout.CENTER);
		
		//3-inicio la variable ultima operacion asi no me da error
		ultimaOperacion="";
		
		
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
	
	
	//3- clase interna para gestionar los eventos de los botones de las operaciones
	private class AccionOrden implements ActionListener{

		//gestionara lo relativo a las operaciones matematicas
		//cuando haga click el valor numerico sera nuevo
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//almaceno el texto del boton en la variable operacion
			String operacion=e.getActionCommand();
			
			//llamo al metodo calcular que es el encargado de realizar las operaciones matematicas
			//le paso como parametro lo que haya en el display
			//estamos trabajando con el texto del boton, que es un String, hay que hacer un parse
			calcular(Double.parseDouble(pantalla.getText()));
			
			//almaceno en la variable de clase las operaciones que el usuario vaya realizando, la ultima
			//para poder usar la variable fuera del bloque de actionPerformed en metodo calcular
			ultimaOperacion=operacion;
			
			
			//le digo que borre el numero de pantalla cada vez que la ejecute
			 principio=true;
			 
			
		}
		//3- metodo cerebro del programa
		//si se pulso el +, suma. si se pulso el -, resta, etc
		public void calcular(double x) {
			if(ultimaOperacion.equals("+")) {
				//sumar en esta variable lo que le hayamos pasado por parametro, lo que hay en pantalla
				resultado+=x;
			}
			
			else if (ultimaOperacion.equals("-")) {
				resultado-=x;
			}
			
			else if (ultimaOperacion.equals("*")) {
				resultado*=x;
			}
			
			else if (ultimaOperacion.equals("/")) {
				resultado/=x;
			}
			
			//logro que se guarde lo que hay inicialmente en la pantalla, ya que la primera vez que se ejecuta, resultado vale =
			else if (ultimaOperacion.equals("=")) {
				resultado=x;
			}
			
			//muestro el acumulado en pantalla
			//tengo que hacer una conversion a String, concatenado con una cadena delante
			pantalla.setText(""+resultado);
			
		}
		
		
		
	}
	
	
	
}