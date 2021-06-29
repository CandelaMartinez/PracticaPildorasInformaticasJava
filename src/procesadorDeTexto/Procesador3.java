package procesadorDeTexto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//forma mas simplificada de hacer el mismo ejercicio
//metodo que crea los submenus




public class Procesador3 {

	public static void main(String[] args) {
		MenuProcesador3 mimarco=new MenuProcesador3();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador3 extends JFrame{
	public MenuProcesador3() {
		setBounds(500,300,550,400);
		setVisible(true);
		LaminaProcesador3 milamina=new LaminaProcesador3();
		add(milamina);
	}
}

class  LaminaProcesador3 extends JPanel{
	
	JTextPane miarea;
	JMenu fuen, es, ta;
	Font letras;
	
	//pasamos de la clase padre a la clase interna y los parametros se almacenan en variables que usan el constructor
	//detectar que item se ha pulsado: que deje todo igual menos lo que se apreto, dejar todo como esta el resto, detectar que tipo, tamaño hay en mi area de texto
	
	
	public LaminaProcesador3() {
		setLayout(new BorderLayout());
		//segunda lamina
		JPanel laminaMenu=new JPanel();
		//crear la barra de menu
		JMenuBar mibarra=new JMenuBar();
		//que elementos va a albergar la barra
		fuen= new JMenu("Fuente");
		 es= new JMenu("Estilo");
		ta= new JMenu("Tamaño");
		
		//uso metodo para los metodos que cuelgan
		configuraMenu("Arial", "fuente", "Arial", 9,10);
		configuraMenu("Courier", "fuente", "Courier", 9,10);
		configuraMenu("Verdana", "fuente", "Verdana", 9,10);
		//---------------------------------------------------------------------------------
		configuraMenu("Negrita", "estilo", "", Font.BOLD,0);
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC,0);
		//---------------------------------------------------------------------------------
		configuraMenu("12", "tamaño", "", 9,12);
		configuraMenu("16", "tamaño", "", 9,16);
		configuraMenu("20", "tamaño", "", 9,20);
		configuraMenu("24", "tamaño", "", 9,24);
		
		
		//---------------------------------------------------------------------------------
		//agregar estos elementos ala barra
		mibarra.add(fuen);
		mibarra.add(es);
		mibarra.add(ta);
		//agregar la barra a la lamina que ira en la zona superior
		laminaMenu.add(mibarra);
		//agregar la lamina en la zona superior de la principal
		add(laminaMenu,BorderLayout.NORTH);
		
		
		//construir un objeto JTextPane y agregarlo a la zona central de la lamina principal
		miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		
	}
	
	//metodo que inicia los items, los agrega colgando de donde corresponde segun el parametro que le paso
	//los pone a la escucha
	public void configuraMenu(String rotulo,String Menu, String tipoLetra,int estilos,int tam) {
		
		JMenuItem elemMenu=new JMenuItem(rotulo);
		if (Menu=="fuente") {
			fuen.add(elemMenu);
		}else if (Menu=="estilo") {
			es.add(elemMenu);
		}else if (Menu=="tamaño") {
			ta.add(elemMenu);
		}
		
		//instancio la clase interna de eventos
		elemMenu.addActionListener(new GestionaEventos(rotulo,tipoLetra,estilos,tam));
		
		
		
	}
	
	//clase interna que gestiona los eventos
	private class GestionaEventos implements ActionListener{
		String tipo, menu;
		int estilo,tama;
		
		//constructor:detecta menu que hemos pulsado, le damos valores a las variables
		GestionaEventos(String elemento,String texto2,int estilo2,int tamLetra){
			
			tipo=texto2;
			estilo= estilo2;
			tama=tamLetra;
			menu=elemento;
		}
		
		
		
		//tengo que pasar valores que no sean fijos
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//almaceno el tipo de letra que tiene mi cuadro de texto, usando metodo getFont() que devuelve un objeto de tipo Font
			letras=miarea.getFont();
			
			//extraer de este objeto Font tipo, tamaño, estilo
			//en var menu tengo el elemento elegido
			
			if(menu=="Arial"||menu=="Courier"||menu=="Verdana") {
				//almacena en la variable el estilo y tamaño que hay en el cuadro de texto, solo cambia el tipo
				
				//evaluo si ya tiene aplicado uno de los estilos, si es asi, aplico los dos estilos: negrita=1 y cursiva=2, los sumo
				if(letras.getStyle()==1||letras.getStyle()==2) {
					estilo=3;
				}
				
				
				estilo=letras.getStyle();
				tama= letras.getSize();
			}else if(menu=="Cursiva"||menu=="Negrita") {
				//me tiene que dejar el tipo y tamaño que hay
				tipo= letras.getFontName();
				tama=letras.getSize();
				
			}else if(menu=="12"||menu=="16"||menu=="20"||menu=="24") {
				//solo modifica el tamaño de letra
				estilo=letras.getStyle();
				tipo=letras.getFontName();
			}
			
			miarea.setFont(new Font(tipo,estilo,tama));
			
			System.out.println("tipo: "+tipo+" estilo: "+estilo+ " tamaño: "+tama);
		}
		
	}
	
	
	
}