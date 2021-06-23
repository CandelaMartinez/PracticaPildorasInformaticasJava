package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C77_80VariosOyentes {

	public static void main(String[] args) {
		MarcoPrincipal mimarco= new MarcoPrincipal();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoPrincipal extends JFrame{
	
	public MarcoPrincipal() {
		setTitle("prueba varios");
		setBounds(1300,100,300,200);
		LaminaPrincipal lamina=new LaminaPrincipal();
		add(lamina);
		
		
	}
	
	
}

class LaminaPrincipal extends JPanel {
	
	public LaminaPrincipal() {
		JButton botonN= new JButton("Nuevo");
		add(botonN);
		
		botonC=new JButton("Cerrar");
		add(botonC);
		
		//creo una instancia de la clase interna que pertenece al oyente
		OyenteNuevo miOyente= new OyenteNuevo();
		//vinculo ese oyente con el boton, que es objeto fuente
		//la clase oyente tiene una instaciacion de la clase marcos emergente que lo que hace es construir un marco
		botonN.addActionListener(miOyente);
		
	}
	
	//declaro la variable fuera del constructor y la instancio dentro del constructor
	//ya que querre usar la instancia fuera del constructor
	JButton botonC ;
	
	//creo un oyente nuevo como clase interna
	private class OyenteNuevo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	
			//usa como parametro el boton de cerrar
			MarcoEmergente marco=new MarcoEmergente(botonC);
			marco.setVisible(true);
			
		}
		
		
		
	}
	
	
}

//clase que cree nuevas ventanas
//con numeros correlativos
//en diferente posicion cada una
//no le agrego laminas, quiero que sean vacias
class MarcoEmergente extends JFrame{
	
	private static int contador=0;
	public MarcoEmergente(JButton botonCierre) {
		
		contador++;
		setTitle("Ventana "+contador);
		setBounds(40*contador,40*contador,300,150);
		//necesito usar aqui el botonC que esta en la clase LaminaPrincipal y no lo puedo usar
		//la forma de poder usarlo es pasandolo por parametro
		//le digo que este boton es la fuente desencadenante del evento
		CierraTodas oyenteCerrar = new CierraTodas();
		botonCierre.addActionListener(oyenteCerrar);
		
		
		
	}
	
	
	//si quiero que los marcos emergentes se cierren esta debe ser una clase interna de marcoemergente
	//clase oyente 
	private class CierraTodas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//el metodo tiene que cerrar el objeto con el metodo dispose() de la clase JFrame
			//dispose() cierra el objeto y libera recursos
			
			dispose();
		}
		
		
		
	}
	
	
	
	
	
	
}