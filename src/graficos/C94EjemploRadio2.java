package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//marcos con texto y debajo botones de radio para que cambie el texto

public class C94EjemploRadio2 {

	public static void main(String[] args) {
		MarcoRadio2 mimarco=new MarcoRadio2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoRadio2 extends JFrame{
	public MarcoRadio2() {
		setVisible(true);
		setBounds(500,300,500,350);
		LaminaRadio2 milamina= new LaminaRadio2();
		add(milamina);
	}
}

class LaminaRadio2 extends JPanel{
	public LaminaRadio2() {
		//central texto, sur botones
		setLayout(new BorderLayout());
		
		//inicializo la variable que tiene el texto que cambiare y lo ubico
		texto=new JLabel("En un lugar de la tierra, donde arden las estrellas....");
		
		//caracteristicas del texto por defecto
		texto.setFont(new Font("Serif",Font.PLAIN,12));
		
		add(texto, BorderLayout.CENTER);
		
		//inicio lamina y grupo
		laminaBotones2=new JPanel();
		migrupo= new ButtonGroup();
		
		//va a crear boton, agruparlo y ponerlo a la escucha
		colocarBotones("pequeño",false,8);
		colocarBotones("mediano",false,14);
		colocarBotones("grande",false,56);
		colocarBotones("enorme",true,106);
		
		//agregar lalamina botones ala lamina principal
		add(laminaBotones2,BorderLayout.SOUTH);
		
	}
	
	//metodo para simplificar el codigo
	//final para no poder modificar en ejecucion el valor de ese argumento
	
	public void colocarBotones(String nombre, boolean seleccionado, final int tamagno) {
		//contruyo boton
		JRadioButton boton=new JRadioButton(nombre,seleccionado);
		//agrupo boton
		migrupo.add(boton);
		//agregarlos a la lamina
		laminaBotones2.add(boton);
		//boton tiene que responder a una serie de eventos
		ActionListener mievento=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font("Serif",Font.PLAIN,tamagno));
				
			}
			
		};
		
		//poner el  boton a la escucha
		boton.addActionListener(mievento);
		
	}
	
	//variable para construir texto y botones de radio, grupo, lamina
	private JLabel texto;
	private JRadioButton boton;
	private ButtonGroup migrupo;
	private JPanel laminaBotones2;
	
}