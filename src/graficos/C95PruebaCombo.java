package graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
//1-creo marco: visible, bounds, closeOperation, instancio y agrego lamina
//2-creo lamina: layout, label, Font de label, agrego label a la lamina
//3-instancio combo dentro de lamina, agrego item dentro de combo, instancio laminaNorte, agrego combo a laminaNorte, agrego laminaNorte a lamina principal
//4-creo clase interna con evento y metodo actionPerformer
//5-en lamina: instancion evento,pongo combo a la escucha del evento



//agregar un texto y agregar un menu desplegable para poder cambiar el texto. estara en la zona north

public class C95PruebaCombo {

	public static void main(String[] args) {
		MarcoCombo mimarco=new MarcoCombo();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCombo extends JFrame{
	public MarcoCombo() {
		setVisible(true);
		setBounds(500,300,500,400);
		
		LaminaCombo milamina= new LaminaCombo();
		add(milamina);
	}
	
	
}

class LaminaCombo extends JPanel{
	public LaminaCombo() {
		//establezco disposicion
		setLayout(new BorderLayout());
		
		//inicio texto, letra y lo agrego a la lamina
		texto= new JLabel("En un lugar de la Tierra...");
		texto.setFont(new Font("serif",Font.PLAIN,18));
		add(texto, BorderLayout.CENTER);
		
		//crear segunda lamina que tendra el combo y estara en la zona norte de la lamina principal
		JPanel laminaNorte= new JPanel();
		
		//iniciar micombo
		micombo= new JComboBox();
		
		//agregar elementos a micombo: familia de letras. el menu tendra estos cuatro elementos
		micombo.addItem("Serif");
		micombo.addItem("SansSerif");
		micombo.addItem("Monospaced");
		micombo.addItem("Dialog");
		
		//instanciar la clase de eventos para poner el combo a la escucha
		EventoCombo mievento= new EventoCombo();
		
		//pongo micombo a la escucha
		micombo.addActionListener(mievento);
		
		//agregarlo a la lamina norte
		laminaNorte.add(micombo);
		
		//agregar esta lamina norte a la lamina principal
		add(laminaNorte, BorderLayout.NORTH);
		

		//editar las opciones
		micombo.setEditable(true);
	}
	
	//creo clase interna para crear los eventos
	private class EventoCombo implements ActionListener{

		//getSelectedItem devuelve un Object (lo que esta seleccionado en en menu)
		//el constructor me pide un String, lo tengo que castear(String)
		
		@Override
		public void actionPerformed(ActionEvent e) {
			texto.setFont(new Font((String)micombo.getSelectedItem(),Font.PLAIN,18));
			
		}
		
	}
	
	
	//campos de clase que usaremos: texto y desplegable
	
	private JLabel texto;
	private JComboBox micombo;
	
	
	
	
}

