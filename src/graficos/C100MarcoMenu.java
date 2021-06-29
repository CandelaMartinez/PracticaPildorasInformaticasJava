package graficos;

import javax.swing.*;
import javax.swing.*;

public class C100MarcoMenu {

	public static void main(String[] args) {
		MenuFrame mimenu=new MenuFrame();
		mimenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
 
class MenuFrame extends JFrame{
	public MenuFrame() {
		setBounds(500,300,550,400);
		setVisible(true);
		
		MenuLamina milamina=new MenuLamina();
		add(milamina);
	}
}

class MenuLamina extends JPanel{
	public MenuLamina() {
		
		//creo la barra soporte
		JMenuBar mibarra=new JMenuBar();
		//creo las opciones dentro de la barra de menu, sobrecarga de constructor. String parametro
		JMenu archivo= new JMenu("Archivo");
		JMenu edi= new JMenu("Edicion");
		JMenu he= new JMenu("Herramientas");
		
		
		//creo los elementos item que van dentro de cada opcion
		JMenuItem guardar=new JMenuItem("Guardar");
		JMenuItem gC=new JMenuItem("Guardar como");
		
		JMenuItem cor=new JMenuItem("Cortar");
		JMenuItem cop=new JMenuItem("Copiar");
		JMenuItem pe=new JMenuItem("Pegar");
		
		JMenuItem gral=new JMenuItem("Generales");
		

		
		//agrego los items a cada elemento de la barra
		archivo.add(guardar);
		archivo.add(gC);
		archivo.add(he);
		
		edi.add(cor);
		edi.add(cop);
		edi.add(pe);
		
		//agrego un separador, sirve para crear grupos
		edi.addSeparator();
		
		he.add(gral);
	
		//agregar los elementos de menu en la barra
		mibarra.add(archivo);
		mibarra.add(edi);
		mibarra.add(he);
		
		
		//submenu
		//creo una opcion dentro de un item que es a su vez menu de otras opciones, submenu
		JMenu opciones= new JMenu("Opciones");
		//crear los items que depende de este menu de opciones
		JMenuItem op1= new JMenuItem("Opcion 1");
		JMenuItem op2= new JMenuItem("Opcion 2");
		//agregar estas opciones al submenu
		opciones.add(op1);
		opciones.add(op2);
		//especificar que este menu de opciones cuelga de menu edicion
		edi.add(opciones);
	
		//agrego la barra a la lamina
		add(mibarra);
	}
}