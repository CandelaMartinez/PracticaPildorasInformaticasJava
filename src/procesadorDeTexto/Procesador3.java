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
//forma mas simplificada de hacer el mismo ejercicio
//metodo que crea los submenus
//clases 101-106
//clase 107: agrego iconos a negrita y cursiva
//clase 108: agrego checkbox a negrita y cursiva y radioButtom a tama?o letra
//clase 109: menu emergente al click derecho sobre texto
//clase 110: agregar a N y Cursiva atajos de teclado y a tama?o de letra 24



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
	//detectar que item se ha pulsado: que deje todo igual menos lo que se apreto, dejar todo como esta el resto, detectar que tipo, tama?o hay en mi area de texto
	
	
	public LaminaProcesador3() {
		setLayout(new BorderLayout());
		//segunda lamina
		JPanel laminaMenu=new JPanel();
		//crear la barra de menu
		JMenuBar mibarra=new JMenuBar();
		//que elementos va a albergar la barra
		fuen= new JMenu("Fuente");
		 es= new JMenu("Estilo");
		ta= new JMenu("Tama?o");
		
		//uso metodo para los metodos que cuelgan
		configuraMenu("Arial", "fuente", "Arial", 9,10,"");
		configuraMenu("Courier", "fuente", "Courier", 9,10,"");
		configuraMenu("Verdana", "fuente", "Verdana", 9,10,"");
		//---------------------------------------------------------------------------------
		
		
		configuraMenu("Negrita", "estilo", "", Font.BOLD,0,"src/graficos/bold.png");
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC,0,"src/graficos/italic.png");
		
		//clase 108, construyo estos nuevos elementos de menu con las casillas cuadras 
		//clase JCheckBoxMenuItem
		/*JCheckBoxMenuItem negrita=new JCheckBoxMenuItem("Negrita",new ImageIcon("src/graficos/bold.png"));
		es.add(negrita);
		
		JCheckBoxMenuItem cursiva=new JCheckBoxMenuItem("Cursiva",new ImageIcon("src/graficos/italic.png"));
		es.add(cursiva);
		
		//lo pongo a la escucha
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());*/
		
		//---------------------------------------------------------------------------------
		/*configuraMenu("12", "tama?o", "", 9,12,"");
		configuraMenu("16", "tama?o", "", 9,16,"");
		configuraMenu("20", "tama?o", "", 9,20,"");
		configuraMenu("24", "tama?o", "", 9,24,"");
		*/
		
		
		//construir un grupo de radio buttom
		
		ButtonGroup tamagnoLetra = new ButtonGroup();
		
		//construir cada uno de los radio button
		JRadioButtonMenuItem t12= new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem t16= new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem t20= new JRadioButtonMenuItem("20");
		//clase 110: agrego al tama?o un atajo de teclado
		//usar el metodo en el elemento JMenuItem que quiero el atajo
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
		t12.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", 12));
		t16.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", 16));
		t20.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", 20));
		t24.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", 24));
		
		//agregar los elementos al menu bajo la pesta?a de tama?o
		ta.add(t12);
		ta.add(t16);
		ta.add(t20);
		ta.add(t24);
		
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
		
		//quito los checkbox de negrita y cursiva
		
		
		//.....................................................................................
		//agrego la barra de herramientas lateral
		JToolBar barraH= new JToolBar();
		//boton con forma de un icono
		JButton negritaBarra = new JButton(new ImageIcon("src/graficos/ro.png"));
		JButton cursivaBarra = new JButton(new ImageIcon("src/graficos/amar.png"));
		JButton underlineBarra = new JButton(new ImageIcon("src/graficos/ro.png"));
		JButton azulBarra = new JButton(new ImageIcon("src/graficos/1.png"));
		JButton amarBarra = new JButton(new ImageIcon("src/graficos/2.png"));
		JButton rojoBarra = new JButton(new ImageIcon("src/graficos/3.png"));
		JButton alineaDe= new JButton(new ImageIcon("src/graficos/derecha.png"));
		JButton alineaIz = new JButton(new ImageIcon("src/graficos/izquierda.png"));
		JButton alineaCen = new JButton(new ImageIcon("src/graficos/centrado.png"));
		JButton alineaJus = new JButton(new ImageIcon("src/graficos/justificado.png"));
		
		barraH.add(negritaBarra);
		barraH.add(cursivaBarra);
		barraH.add(underlineBarra);
		barraH.add(azulBarra);
		barraH.add(amarBarra);
		barraH.add(rojoBarra);
		barraH.add(alineaDe);
		barraH.add(alineaIz);
		barraH.add(alineaCen);
		barraH.add(alineaJus);
		
		//poner los botones de la barra de herramientas a la escucha
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction() );
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		underlineBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		//metodo static que pinta el texto y pide de parametros: nombre de la accion y un elemento color
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("pintar azul", Color.BLUE));
		amarBarra.addActionListener(new StyledEditorKit.ForegroundAction("pintar amarillo", Color.YELLOW));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("pintar rojo",Color.RED));
		//poner los botones de justificado de texto a la escucha
		alineaDe.addActionListener(new StyledEditorKit.AlignmentAction("derecha",2));
		alineaIz.addActionListener(new StyledEditorKit.AlignmentAction("izquierda",0));
		alineaCen.addActionListener(new StyledEditorKit.AlignmentAction("centrado",1));
		alineaJus.addActionListener(new StyledEditorKit.AlignmentAction("justificado",3));
		
		//situar la barra de herramientas: cuando la ejecuto los botones aparecen uno allado del otro
		//hay que cambiar la disposicion de los elementos de la barra: pide un argumento int (0 es hori, 1 es vert) 
		barraH.setOrientation(1);
		add(barraH, BorderLayout.WEST);

		
		
		
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
				}/*else if (Menu=="tama?o") {
			
			
			ta.add(elemMenu);
			//pongo a la escucha elemMenu, le agrego una accion dentro con la subclase FontSizeAction de la 
			//clase StyledEditorKit, me permite cambiar el tama?o seleccionando parte del texto
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama?o", tam));
		}*/
		
	
		
		
		
	}
	

	
	
	
}