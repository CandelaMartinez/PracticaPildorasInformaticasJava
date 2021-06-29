package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
//construir un menu y la barra de herramientas que se pueda arrastrar y agregar un boton para que pueda salir de la app
public class C111MarcoBarra {

	public static void main(String[] args) {
		MarcoBarra mimarco= new MarcoBarra();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class MarcoBarra extends JFrame{
	
	public MarcoBarra() {
		
		setTitle("Marco con Barra");
		setBounds(500,300,600,450);
		lamina=new JPanel();
		add(lamina);
		
		//configuro acciones
		Action accionAz = new AccionC("Azul", new ImageIcon("src/graficos/azul.png"),Color.BLUE);
		Action accionAm = new AccionC("Amarillo", new ImageIcon("src/graficos/amar.png"),Color.YELLOW);
		Action accionRo = new AccionC("Rojo", new ImageIcon("src/graficos/ro.png"),Color.RED);
		//accion del boton de salir, instancio la clase AbstractAction que me obliga a implementar el metodo actionPerformed
		Action accionSa =new AbstractAction("Salir", new ImageIcon ("src/graficos/cut.png")) {
			
			//salir de la aplicacion
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		};
		
		
		
		
		//construir menu
		JMenu mimenu= new JMenu("Color");
		
		//agregar al menu las acciones
		mimenu.add(accionAz);
		mimenu.add(accionAm);
		mimenu.add(accionRo);
		
		//crear una barra de menu para que cuelguen los 3 elementos anteriores
		JMenuBar barraMenu= new JMenuBar();
		
		//agregar el menu a la barra
		barraMenu.add(mimenu);
		
		//decirle al marco que agregue esta barra de menu construida
		//agregar directamente al marcos una barra de menu, metodo de JFrame
		setJMenuBar(barraMenu);
		
		//construccion de la barra de herramientas: puedo indicar en el constructor que sea lateral, por defecto es horizontal
		//add puedo permitir pasar una accion por parametro
		
		JToolBar barraHerramientas= new JToolBar();
		
		//agrego acciones a la barra
		barraHerramientas.add(accionAz);
		barraHerramientas.add(accionAm);
		barraHerramientas.add(accionRo);
		//agregar un separador y el boton de salir
		barraHerramientas.addSeparator();
		barraHerramientas.add(accionSa);
		
		//si quiero arrastrar mi bara debo indicarle una disposicion de borderlayout
		add(barraHerramientas, BorderLayout.NORTH);
		
		
		
	
	}

	//clase interna para construir acciones
	private class AccionC extends AbstractAction{
		public AccionC (String nombre, Icon icono, Color c) {
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION,"color de fondo--"+nombre);
			putValue("color", c);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color c=(Color)getValue("color");
			lamina.setBackground(c);
			
		}
		
	}
	
	
	JPanel lamina;
	
	
}


