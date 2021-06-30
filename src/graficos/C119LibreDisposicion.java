package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.*;

//crear una clase que organice los elementos en disposicion libre para luego poder usarla
public class C119LibreDisposicion {

	public static void main(String[] args) {
		MarcoLibre2 mimarco= new MarcoLibre2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoLibre2 extends JFrame{
	public MarcoLibre2() {
		setBounds(450,350,600,400);
		setVisible(true);
		LaminaLibre2 milamina= new LaminaLibre2();
		add(milamina);
	}
}
class LaminaLibre2 extends JPanel{
	
	public LaminaLibre2() {
		//disposicion layout de mi clase que construi
		setLayout(new EnColumnas());

		//elementos
		JLabel nombre= new JLabel("Nombre: ");
		JLabel apellido= new JLabel("Apellido: ");
		JLabel edad= new JLabel("Edad: ");
		
		JTextField cNombre= new JTextField();
		JTextField cApellido= new JTextField();
		JTextField cEdad= new JTextField();
		
		
		
		//agregarlo a la lamina, por parejas
		
		add(nombre);
		add(cNombre);
		
		add(apellido);
		add(cApellido);
		
		add(edad);
		add(cEdad);
	}
}

//clase com mi propia disposicion debe implementar la interface

class EnColumnas implements LayoutManager{
	
	//variables de clase
	private int x;
	private int y;

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	//uso este metodo: parametro: el contenedor donde ubico mis elementos
	@Override
	public void layoutContainer(Container miContenedor) {
		int contador=0;
		
		//almacene las dimensiones del contenedor
		int d=miContenedor.getWidth();
		
		//punto central horizontal del contenedor
		x=d/2;
		
		//cuantos componentes hemos agregado al contenedor, primer elemento es el 0
		int n=miContenedor.getComponentCount();
		
		
		//recorrer individualmente los elementos para poder ubicarlos a c/u
		
		for(int i=0; i<n;i++) {
			
			
			
			contador ++;
			
			//almaceno el primer componente en c
			Component c= miContenedor.getComponent(i);
			
			//ubico c, al punto medio x le tengo que restar el ancho del componente
			c.setBounds(x-100, y, 100, 20);
			
			//incremento el desplazamiento horizontal
			x+=100;
			
			//incremento la y cuando ya haya agregado la primera pareja de componentes porque el segundo componente debe ir en la misma disposicion vertical
			//incremente la y cada vez que sea par el contador (guarda la cantidad de elementos agregados)
			if(contador%2==0) {
				x=d/2;
				y+=40;
			}
			
			
		}
		
	}
	
}