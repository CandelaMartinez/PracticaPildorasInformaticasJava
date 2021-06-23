package graficos;
import java.awt.Frame;

import javax.swing.*;

public class C55CreandoMarcos {

	public static void main(String[] args) {
		//instancio la clase MiMarco
		MiMarco marco1=new MiMarco();
		
		//uso la instancia de Jframe para usar el metodo para hacerla visible
		marco1.setVisible(true);
		
		//que pasa cuando se cierra: cerrar la app cuando cierre la ventana
		//exit_on_close es una constante de clase. es static por eso hay que usar el nombre de la clase delante
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//si tengo varias ventanas se cierra solo la que yo cierro
		//marco1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		
	}

}
//hereda de jframe para poder usar los metodos, tiene que importar swing

class MiMarco extends JFrame{
	
	//constructor
	public MiMarco() {
		//uso el metodo de la clase Jframe para establecer el tamaño de la ventana
		//setSize(500,300);
		
		//cambia la ubicacion dentro del elemento padre. esquina superior de la pantalla es el eje 0,0
		//setLocation(500,300);
		
		//cuadrado ubicado en x500 y300
		setBounds(500,300,550,250);
		
		//ver si puede el usuario redimensionar el marcos
		//setResizable(false);
		
		//marco se abre a pantalla completa: static, public, final, int podriamos poner el valor de la constante nomas
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		
		//titulo
		setTitle("mi ventana");
		
	
		
		
		
		
		
	}
	
	
}
