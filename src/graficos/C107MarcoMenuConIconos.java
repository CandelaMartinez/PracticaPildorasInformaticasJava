package graficos;

import javax.swing.*;
import javax.swing.*;
//agrego iconos a las opciones que cuelgan del menu
//guardo imagenes en la carpeta del proyecto png
//JMenuItem constructor que admite argumentos del tipo (Icon y String)
//Icon es una interface, ImageIcon implementa la interface Icon, si construyo un objeto de la clase ImageIcon puedo usarlo para pasarlo de argumento
//ImageIcon constructor pide argumento String con ruta del archivo
public class C107MarcoMenuConIconos {

	public static void main(String[] args) {
		MenuFrameI mimenu=new MenuFrameI();
		mimenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
 
class MenuFrameI extends JFrame{
	public MenuFrameI() {
		setBounds(500,300,550,400);
		setVisible(true);
		
		MenuLaminaI milamina=new MenuLaminaI();
		add(milamina);
	}
}

class MenuLaminaI extends JPanel{
	public MenuLaminaI() {
		
		//creo la barra soporte
		JMenuBar mibarra=new JMenuBar();
		//creo las opciones dentro de la barra de menu, sobrecarga de constructor. String parametro
		JMenu archivo= new JMenu("Archivo");
		JMenu edi= new JMenu("Edicion");
		JMenu he= new JMenu("Herramientas");
		
		
		//creo los elementos item que van dentro de cada opcion
		JMenuItem guardar=new JMenuItem("Guardar");
		JMenuItem gC=new JMenuItem("Guardar como");
		
		//agrego los iconos en el constructor(desde raiz del proyecto
		JMenuItem cor=new JMenuItem("Cortar",new ImageIcon("src/graficos/cut.png"));
		
		JMenuItem cop=new JMenuItem("Copiar",new ImageIcon("src/graficos/copy.png"));
		//puedo cambiar la ubicacion del icono, 
		cop.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JMenuItem pe=new JMenuItem("Pegar",new ImageIcon("src/graficos/paste.png"));
		
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