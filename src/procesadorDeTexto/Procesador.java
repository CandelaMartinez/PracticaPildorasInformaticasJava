package procesadorDeTexto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//menu en la parte superior, en la parte inferior el cuadro de texto
//cuadro de texto con JTextPane asi agrego barras de desplazamiento

//1- crear la barra de menu
//2- crear area de texto con JPane
//3- poner los elementos del menu a la escucha de un evento

public class Procesador {

	public static void main(String[] args) {
		MenuProcesador mimarco=new MenuProcesador();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuProcesador extends JFrame{
	public MenuProcesador() {
		setBounds(500,300,550,400);
		setVisible(true);
		LaminaProcesador milamina=new LaminaProcesador();
		add(milamina);
	}
}

class  LaminaProcesador extends JPanel{
	
	JTextPane miarea;
	public LaminaProcesador() {
		setLayout(new BorderLayout());
		//segunda lamina
		JPanel laminaMenu=new JPanel();
		//crear la barra de menu
		JMenuBar mibarra=new JMenuBar();
		//que elementos va a albergar la barra
		JMenu fue= new JMenu("Fuente");
		JMenu es= new JMenu("Estilo");
		JMenu ta= new JMenu("Tamaño");
		
		
		//Submenu:crear los elementos que cuelgan de los items de la barra y agregarlos, ponerlos a la escucha
		//que cuelga de tamaño................................................................
		JMenuItem ar= new JMenuItem("Arial");
		
		JMenuItem cou= new JMenuItem("Courier");
		//clase interna anonima para gestionar evento de cou
		cou.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miarea.setFont(new Font("Courier",Font.PLAIN,12));
				
			}
			
		});
		
		JMenuItem ver= new JMenuItem("Verdana");
		
		fue.add(ar);
		fue.add(cou);
		fue.add(ver);
		
		//que cuelga de estilo.................................................................		
		JMenuItem ne= new JMenuItem("Negrita");
		JMenuItem cur= new JMenuItem("Cursiva");
		
		
		es.add(ne);
		es.add(cur);
		
		//que cuelga de tamaño.................................................................		
		JMenuItem ta12= new JMenuItem("12");
		JMenuItem ta16= new JMenuItem("16");
		JMenuItem ta20= new JMenuItem("20");
		JMenuItem ta24= new JMenuItem("24");
		
		ta.add(ta12);
		ta.add(ta16);
		ta.add(ta20);
		ta.add(ta24);
		
		//agregar estos elementos ala barra
		mibarra.add(fue);
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
	
	
	
}