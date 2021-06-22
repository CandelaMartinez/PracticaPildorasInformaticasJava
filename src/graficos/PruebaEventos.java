package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos {

	public static void main(String[] args) {
		MarcoBotones mimarco=new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}

//creo marco con lamina agregada
class MarcoBotones extends JFrame{
	public MarcoBotones() {
		setTitle("Botones y Eventos");
		setBounds (700,300,500,300);
		LaminaBotones milamina= new LaminaBotones();
		add (milamina);
		
	}
	
	
	
}

//creo lamina que agrego al marco
//evento: al hacer click/ objeto fuente: botonAzul/ oyente: lamina que se va a poner de color azul
//como la lamina es oyente, tiene que implementar la interface ActionListener
class LaminaBotones extends JPanel implements ActionListener{
	
	//construir boton- OBJETO FUENTE
	JButton botonAzul= new JButton("Azul");
	JButton botonAmarillo= new JButton("Amarillo");
	JButton botonRojo= new JButton("Rojo");
	
	
	//constructor
	public LaminaBotones() {
		//agregarlo a la lamina 
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		//agrego al objeto fuente, quien va a ser el receptor de la accion: la propia clase (lamina)
		//AGREGO OBJETO EVENTO A OBJETO FUENTE Y LO VINCULO A OYENTE
		botonAzul.addActionListener(this);
		botonAmarillo.addActionListener(this);
		botonRojo.addActionListener(this);
		
		}
	
	//metodo que tengo que implementar por la interface ActionListener
	//DESCRIBO EVENTO
	public void  actionPerformed(ActionEvent e) {
		//dentro del objeto botonPulsado almaceno quien es la fuente
		Object botonPulsado= e.getSource();
		
		if(botonPulsado==botonAzul) {
			
			setBackground(Color.BLUE);
			
		}if(botonPulsado==botonAmarillo) {
			
			setBackground(Color.YELLOW);
			
		}if (botonPulsado==botonRojo){
			
			setBackground(Color.RED);
		}
		
		
		
	}
	
}