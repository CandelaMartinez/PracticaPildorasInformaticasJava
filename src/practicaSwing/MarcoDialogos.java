package practicaSwing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.*;

public class MarcoDialogos extends JFrame {
	
	private LaminaBotones laminaTipo, laminaTipoMensaje, laminaMensaje,laminaTipoOpcion,laminaOpciones,laminaEntrada;
	private String cadenaMensaje="MENSAJE";
	private Icon iconoMensaje= new ImageIcon("src/practicaSwing/1.png");
	private Object objetoMensaje= new Date();
	private Component componenteMensaje= new LaminaEjemplo();
	
	//constructor de marco
	public MarcoDialogos() {
		
		setTitle("Prueba de dialogos");
		setBounds(500,300,600,450);
		
		//lamina Principal superior..............................................
		JPanel laminaCuadricula= new JPanel();
		laminaCuadricula.setLayout(new GridLayout(2,3));
		
		
		//lamina botones Box......................................................
		//array de los elementos que van en la primera caja
		String [] primero= {"Mensaje","Confirmar","Opcion","Entrada"};
				
		laminaTipo= new LaminaBotones("Tipo", primero);
		
		laminaTipoMensaje= new LaminaBotones("Tipo Mensaje", new String[] {
				"ERROR_MESSAGE",
				"INFORMATION_MESSAGE",
				"WARNING_MESSAGE",
				"QUESTION_MESSAGE",
				"PLAIN_MESSAGE"
		});
		
		laminaMensaje= new LaminaBotones("Mensaje", new String[] {
				"Cadena",
				"Icono",
				"Componente",
				"Otros",
				"Object[]"
		});
		
		laminaTipoOpcion= new LaminaBotones("Mensaje", new String[] {
				"DEFAULT_OPTION",
				"YES_NO_OPTION",
				"YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION",
				
		});
		
		laminaOpciones= new LaminaBotones("Mensaje", new String[] {
				"String[]",
				"Icon[]",
				"Object[]"
		});
		
		laminaEntrada= new LaminaBotones("Mensaje", new String[] {
				"Campo de texto",
				"Combo",
				
		});
		
		//..........................................................................
		setLayout(new BorderLayout());
		
		laminaCuadricula.add(laminaTipo);
		laminaCuadricula.add(laminaTipoMensaje);
		laminaCuadricula.add(laminaMensaje);
		laminaCuadricula.add(laminaTipoOpcion);
		laminaCuadricula.add(laminaOpciones);
		laminaCuadricula.add(laminaEntrada);
		
		add(laminaCuadricula,BorderLayout.CENTER);
		
		//crear la lamina inferior..................................................
		JPanel laminaMostrar= new JPanel();
		
		JButton botonMostrar= new JButton("Mostrar");
		
		//dar al boton funcionalidad
		botonMostrar.addActionListener(new AccionMostrar());
		
		
		laminaMostrar.add(botonMostrar);
		
		add(laminaMostrar,BorderLayout.SOUTH);
		
	
		
		
	}
	
	//...........................................DA OPCIONES A LA LAMINA OPCION.......................................
	
	public Object[] dameOpciones(LaminaBotones lamina) {
		
		String s= lamina.dameSeleccion();
		
		if(s.equals("String[]")) {
			
			return new String[] {"Amarillo","Azul","Rojo"};
		
		}else if(s.equals("Icon[]")) {
			
			return new Object[] {new ImageIcon("src/practicaSwing/1.png"),new ImageIcon("src/practicaSwing/2.png"),new ImageIcon("src/practicaSwing/3.png")};
		
		}else if(s.equals("Object[]")) {
			
			return new Object[] {cadenaMensaje,iconoMensaje,componenteMensaje, objetoMensaje};
			
		}else {
			return null;
		}
		
		
	}
	
	
	
	//...........................................DEVUELVE TIPO DE ICONO/NRO DE BOTONES EN CONFIRMAR......................................................
	//el tipo de mensaje es una constante int
	public int dameTipo(LaminaBotones lamina) {
		
		//almaceno en un string la opcion seleccionada de la lamina pasada por parametro
		String s= lamina.dameSeleccion();
		
		if(s.equals("ERROR_MESSAGE")||s.equals("YES_NO_OPTION")) {
			return 0;
		
		}else if(s.equals("PLAIN_MESSAGE")||s.equals("DEFAULT_OPTION")) {
			return -1;
		
		}else if(s.equals("INFORMATION_MESSAGE")||s.equals("YES_NO_CANCEL_OPTION")) {
			return 1;
		
		}else if(s.equals("WARNING_MESSAGE")||s.equals("OK_CANCEL_OPTION")) {
			return 2;
		
		}else if(s.equals("QUESTION_MESSAGE")) {
			return 3;
		
		}else {
			return 0;
		}
		
	}
	
	
	
	//............................................DEVUELVE MENSAJE.............................................................
	public Object dameMensaje() {
		
		//almaceno el string de la opcion seleccionada
		String s= laminaMensaje.dameSeleccion();
		
		if(s.equals("Cadena")){
			
			return cadenaMensaje;
		
		}else if(s.equals("Icono")){
			
			return iconoMensaje;
		
		}else if(s.equals("Componente")){
			
			return componenteMensaje;
		
		}else if(s.equals("Otros")){
			
			return objetoMensaje;
		
		}else if(s.equals("Object[]")){
			
			return new Object[] {cadenaMensaje,iconoMensaje,componenteMensaje, objetoMensaje};
		
		}else {
			return 0;
		}
	}
	
	//...........................................CLASE INTERNA eventos...............................................................
	private class AccionMostrar implements ActionListener{

		//detectamos cual es la opcion seleccionada en cada uno de los boxes con el metodo dameSeleccion()
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			//tipo de JOptionPane que elijo.......................................................................
			
			
			if(laminaTipo.dameSeleccion().equals("Mensaje")){
				
				JOptionPane.showMessageDialog(MarcoDialogos.this,dameMensaje(),"Titulo",dameTipo(laminaTipoMensaje));
				
			}else if(laminaTipo.dameSeleccion().equals("Confirmar")){
				
				JOptionPane.showConfirmDialog(MarcoDialogos.this, dameMensaje(),"Titulo",dameTipo(laminaTipoOpcion),dameTipo(laminaTipoMensaje));
				
			}else if(laminaTipo.dameSeleccion().equals("Entrada")){
				
				//controlo las opciones de la ultima lamina box: combo o cadena de texto
				if(laminaEntrada.dameSeleccion().equals("Campo de texto")) {
				
				
				JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(),"Titulo",dameTipo(laminaTipoMensaje));
				
				
				}else if (laminaEntrada.dameSeleccion().equals("Combo")) {
					
					JOptionPane.showInputDialog(MarcoDialogos.this,dameMensaje(),"Titulo", dameTipo(laminaTipoMensaje),null,new String[] {"Amarillo","Azul","Rojo"},"Azul");
					
					
				}
				
				
			}else if(laminaTipo.dameSeleccion().equals("Opcion")){
				
				JOptionPane.showOptionDialog(MarcoDialogos.this, dameMensaje(), "Titulo", 1, dameTipo(laminaTipoMensaje), null, dameOpciones(laminaOpciones), null);
			}
			
			
		}
		
	}

	

	

}

//clase que construye la lamina que voy a mostrar en mensaje con rectangulo color amarillo

class LaminaEjemplo extends JPanel{
	
	//sobreescribo metodo
	public void paintComponent(Graphics g) {
		
		//llamo al metodo de la clase padre
		super.paintComponent(g);
		
		//casting 
		Graphics2D g2= (Graphics2D)g;
		
		//creo rectangulo, con las mismas dimensiones que la propia lamina
		Rectangle2D rectangulo= new Rectangle2D.Double(0,0,getWidth(),getHeight());
		
		//rellenarlo
		g2.setPaint(Color.YELLOW);
		g2.fill(rectangulo);
		
		
	}
}

