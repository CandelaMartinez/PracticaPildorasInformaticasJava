package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//marcos con texto y debajo botones de radio para que cambie el texto

public class C94EjemploRadio {

	public static void main(String[] args) {
		MarcoRadio mimarco=new MarcoRadio();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoRadio extends JFrame{
	public MarcoRadio() {
		setVisible(true);
		setBounds(500,300,500,350);
		LaminaRadio milamina= new LaminaRadio();
		add(milamina);
	}
}

class LaminaRadio extends JPanel{
	public LaminaRadio() {
		//central texto, sur botones
		setLayout(new BorderLayout());
		
		//inicializo la variable que tiene el texto que cambiare y lo ubico
		texto=new JLabel("En un lugar de la tierra, donde arden las estrellas....");
		add(texto, BorderLayout.CENTER);
		
		//botones de radio, agrupados como unidad
		ButtonGroup migrupo= new ButtonGroup();
		
		boton1= new JRadioButton("pequeño",false);
		boton2= new JRadioButton("mediano",true);
		boton3= new JRadioButton("grande",false);
		boton4= new JRadioButton("enorme",false);
		
		//agregar estos botones en una segunda lamina que estara agregada a la primera
		JPanel laminaRadio= new JPanel();
		
		//creo una instancia de la clase evento para poder poner los botones a la escucha
		EventoRadio mievento=new EventoRadio();
		
		//poner a los botones a la escucha
		boton1.addActionListener(mievento);
		boton2.addActionListener(mievento);
		boton3.addActionListener(mievento);
		boton4.addActionListener(mievento);
		
		//agregar los botones al grupo
		migrupo.add(boton1);
		migrupo.add(boton2);
		migrupo.add(boton3);
		migrupo.add(boton4);
		
		//agregar los botones a la lamina
		laminaRadio.add(boton1);
		laminaRadio.add(boton2);
		laminaRadio.add(boton3);
		laminaRadio.add(boton4);
		
		//agrego la laminaRadio a la lamina principal en la zona sur
		add(laminaRadio, BorderLayout.SOUTH);
		
		
		
	}
	
	//clase interna que maneje los eventos de los botones
	private class EventoRadio implements ActionListener{

		//detectamos que boton de radio pulso: getSource que aplico al objeto del evento
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource()==boton1) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 10));
				
			}else if (e.getSource()==boton2) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 12));
				
			}else if(e.getSource()==boton3) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 14));
				
			}else if (e.getSource()==boton4){
				
				texto.setFont(new Font("Serif", Font.PLAIN, 18));
				
			}
			
		}
		
	}
	
	//variable para construir texto y botones de radio
	private JLabel texto;
	private JRadioButton boton1, boton2, boton3, boton4;
	
}