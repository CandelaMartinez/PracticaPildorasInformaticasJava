package graficos;

import javax.swing.*;

//trabajar con disposicion libre: colocar un boton en donde querramos 
//dos etquetas con dos cuadros de texto
public class C118LibreDisposicion {

	public static void main(String[] args) {
		MarcoLibre mimarco= new MarcoLibre();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoLibre extends JFrame{
	public MarcoLibre() {
		setBounds(450,350,600,400);
		setVisible(true);
		LaminaLibre milamina= new LaminaLibre();
		add(milamina);
	}
}
class LaminaLibre extends JPanel{
	public LaminaLibre() {
		//disposicion libre
		setLayout(null);

		//elementos
		JLabel nombre= new JLabel("Nombre: ");
		JLabel apellido= new JLabel("Apellido: ");
		
		JTextField cNombre= new JTextField();
		JTextField cApellido= new JTextField();
		
		//JButton boton1= new JButton("boton 1");
		//JButton boton2= new JButton("boton 2");
		
		//posicionar elementos. eje x(Horizontal) eje y (Vertical)
		//el punto 0 0 esta en la esquina superior izquierda
		//x, y, ancho, alto
		//boton1.setBounds(50, 50, 150, 50);
		//boton2.setBounds(400, 150, 150, 50);
		nombre.setBounds(20, 20, 80, 10);
		cNombre.setBounds(100, 17, 100, 20);
		
		apellido.setBounds(20, 60, 80, 15);
		cApellido.setBounds(100, 55, 100, 20);
		
		
		//agregarlo a la lamina
		//add(boton1);
		//add(boton2);
		add(nombre);
		add(apellido);
		add(cNombre);
		add(cApellido);
	}
}