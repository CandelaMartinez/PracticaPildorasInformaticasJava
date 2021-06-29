package procesadorDeTexto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

//clase 114: sintetizar el codigo



public class Procesador4 {

	public static void main(String[] args) {
		MenuProcesador4  mimarco=new MenuProcesador4();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador4 extends JFrame{
	public MenuProcesador4() {
		setBounds(500,150,550,800);
		setVisible(true);
		LaminaProcesador4 milamina=new LaminaProcesador4();
		add(milamina);
	}
}

class  LaminaProcesador4 extends JPanel{
	
	
	//variables de clase
	JTextPane miarea;
	JMenu fuen, es, ta;
	Font letras;
	JButton negritaBarra, cursivaBarra, subraBarra, azulBarra, rojoBarra, amarilloBarra, alineaIz, alineaDer, alineaJus, alineaCen;
	JToolBar barraH;
	

	public LaminaProcesador4() {
		
		//disposicion de la lamina principal
		setLayout(new BorderLayout());
		
		//segunda lamina
		JPanel laminaMenu=new JPanel();
		
		//..............................................................................................................
		//crear la barra de menu
		JMenuBar mibarra=new JMenuBar();
		
		//que elementos va a albergar la barra
		fuen= new JMenu("Fuente");
		es= new JMenu("Estilo");
		ta= new JMenu("Tamaño");
		
		//uso metodo para los elementos que cuelgan: submenu
		configuraMenu("Arial", "fuente", "Arial", 9,10,"");
		configuraMenu("Courier", "fuente", "Courier", 9,10,"");
		configuraMenu("Verdana", "fuente", "Verdana", 9,10,"");
		
		configuraMenu("Negrita", "estilo", "", Font.BOLD,0,"src/graficos/bold.png");
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC,0,"src/graficos/italic.png");
		
	
		//.............................................................................................................
		//radio button
		//construir un grupo de radio button
		ButtonGroup tamagnoLetra = new ButtonGroup();
		
		//construir cada uno de los radio button que van en el tamaño
		JRadioButtonMenuItem t12= new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem t16= new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem t20= new JRadioButtonMenuItem("20");
		
		
		//atajo de teclado para el boton tamaño24
		JRadioButtonMenuItem t24= new JRadioButtonMenuItem("24");
		//setAccelerator(uso metodo static getKeyStroke para crear un objeto KeyStroke que me pide como argumento el metodo
		//le paso como parametros dos constantes static de clase keyEvent (letra) inputEvent(modificador)
		t24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_DOWN_MASK));
		
		//agregar los elementos al grupo
		tamagnoLetra.add(t12);
		tamagnoLetra.add(t16);
		tamagnoLetra.add(t20);
		tamagnoLetra.add(t24);
		
		//poner los elementos a la escucha
		t12.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 12));
		t16.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 16));
		t20.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 20));
		t24.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 24));
		
		//agregar los elementos al menu bajo la pestaña de tamaño
		ta.add(t12);
		ta.add(t16);
		ta.add(t20);
		ta.add(t24);
		
		
		//agregar estos elementos ala barra
		mibarra.add(fuen);
		mibarra.add(es);
		mibarra.add(ta);
		
		//agregar la barra a la lamina que ira en la zona superior
		laminaMenu.add(mibarra);
		
		//agregar la lamina en la zona superior de la principal
		add(laminaMenu,BorderLayout.NORTH);
		
		//...................................................................................
		//construir un objeto JTextPane y agregarlo a la zona central de la lamina principal
		miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		
		
		//...................................................................................
		//instancio la clase del menu emergente
		JPopupMenu emergente= new JPopupMenu();
		
		//creo los items que tendra el menu emergente y los agrego al emergente
		JMenuItem negritaE= new JMenuItem("Negrita");
		emergente.add(negritaE);
		
		JMenuItem cursivaE= new JMenuItem("Cursiva");
		emergente.add(cursivaE);
		
		//especifica sobre que elemento tengo que hacer click para que salga, en el area de texto
		miarea.setComponentPopupMenu(emergente);
		
		//gestionar evento del menu emergente
		negritaE.addActionListener(new StyledEditorKit.BoldAction() );
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
	

		//.................................................................................
		//barra de herramientas
		//instancio la variable barra ya declarada
		barraH= new JToolBar();
		//llamo al metodo para crear los botones y agregarlos, me devuelve un objeto JButton, puedo usar el metodo para poner a la escucha el boton
		configuraBarra("src/graficos/1.png").addActionListener(new StyledEditorKit.BoldAction());
		configuraBarra("src/graficos/2.png").addActionListener(new StyledEditorKit.ItalicAction());
		configuraBarra("src/graficos/3.png").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barraH.addSeparator();
		
		configuraBarra("src/graficos/azul.png").addActionListener(new StyledEditorKit.ForegroundAction("pintar azul", Color.BLUE));
		configuraBarra("src/graficos/amar.png").addActionListener(new StyledEditorKit.ForegroundAction("pintar amarillo", Color.YELLOW));
		configuraBarra("src/graficos/ro.png").addActionListener(new StyledEditorKit.ForegroundAction("pintar rojo",Color.RED));
		
		barraH.addSeparator();
		
		configuraBarra("src/graficos/derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("derecha",2));
		configuraBarra("src/graficos/izquierda.png").addActionListener(new StyledEditorKit.AlignmentAction("izquierda",0));
		configuraBarra("src/graficos/centrado.png").addActionListener(new StyledEditorKit.AlignmentAction("centrado",1));
		configuraBarra("src/graficos/justificado.png").addActionListener(new StyledEditorKit.AlignmentAction("justificado",3));
		
		barraH.setOrientation(1);
		add(barraH, BorderLayout.WEST);

		
		
		
	}
	
	
	
	//metodo para configurar la barra de herramientas: construye boton con icono, lo agrega ala barra de herramientas y me lo devuelve asi lo puedo poner a la escucha
	public JButton configuraBarra(String ruta) {
		JButton boton= new JButton(new ImageIcon(ruta));
		barraH.add(boton);
		return boton;
		
		
	}
	
	//metodo que inicia los items, los agrega colgando de donde corresponde segun el parametro que le paso
	//los pone a la escucha
	public void configuraMenu(String rotulo,String Menu, String tipoLetra,int estilos,int tam,String rutaIcono) {
		
		//agrego iconos en el constructor del elemento de menu
		
		JMenuItem elemMenu=new JMenuItem(rotulo,new ImageIcon(rutaIcono));
		
		if (Menu=="fuente") {
			
			fuen.add(elemMenu);
			//evaluo que tipo de letra se pide. pongo a la escucha el elemento y llamo al constructor de la subclase
			if(tipoLetra=="Arial") {
				
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Arial"));
			
			}else if(tipoLetra=="Courier") {
				
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Courier"));
			
			}else if(tipoLetra=="Verdana") {
				
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra","Verdana"));
			}
			
			
			
		}else if (Menu=="estilo") {
			
			es.add(elemMenu);
			//modifico el estilo solo del texto seleccionado, a cursiva o negrita segun corresponda
			//si vuelvo a pulsar en la opcion la quita
			//clase 110: agrego atajos de teclado
			if(estilos==Font.BOLD) {
			
				elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				elemMenu.addActionListener(new StyledEditorKit.BoldAction());
			
				}else if(estilos==Font.ITALIC) {
			
				elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
				elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
				}
		
	
		
		
		
	}
	

	
	
	
}