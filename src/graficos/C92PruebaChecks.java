package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


//texto en la parte superior y en la inferior que aparezcan dos checkbox
//letra negrita para ese texto y letra cursiva, pulso el check on off
//puedo tener ambos seleccionados
//clase Font para modificar las caracteristicas del texto

public class C92PruebaChecks {

	public static void main(String[] args) {
		MarcoCheck mimarco=new MarcoCheck();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCheck extends JFrame{
	public MarcoCheck() {
		setBounds(550,300,550,350);
		setVisible(true);
		LaminaCheck milamina=new LaminaCheck();
		add(milamina);
	}
}

class LaminaCheck extends JPanel{
	
	//declaro las variables fuera del constructor
	private JLabel texto;
	private JCheckBox check1, check2;
	
	public LaminaCheck() {
		
		//distribucion de la lamina
		setLayout(new BorderLayout());
		
		//instancio la letra
		Font miletra=new Font("Serif",Font.PLAIN,24);
		
		//inicio la etiqueta, que sera cambiada
		texto=new JLabel("En un lugar del mundo....");
		//le digo al texto que coja la letra que inicie
		texto.setFont(miletra);
		
		//crear una lamina que sera incluida enla zona norte
		JPanel laminatexto=new JPanel();
		//agrego el label a la laminatexto
		laminatexto.add(texto);
		//agrego la laminatexto a la lamina central con posicionamiento 
		add(laminatexto,BorderLayout.CENTER);
		
		//crear las casillas de verificacion, agregarlos a otra lamina y esa lamina agregarla a la zona sur de la lamina principal
		check1= new JCheckBox("Negrita");
		check2= new JCheckBox("Cursiva");
		
		//antes de agregarlos, ponerlos a la escucha de un click
		check1.addActionListener(new ManejaCheck());
		check2.addActionListener(new ManejaCheck());
		
		//creo la lamina donde van estos checks
		JPanel laminachecks= new JPanel();
		
		//agregar los elelmentos checks a la lamina
		laminachecks.add(check1);
		laminachecks.add(check2);
		
		//agrego la lamina al sur
		add(laminachecks,BorderLayout.SOUTH);
	}
	
	//clase interna evento
	//cuando el check este activado poner en negrita o cursiva segun el check
	//bold, vale un 1 y la cursiva vale un 2
	private class ManejaCheck implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int tipo=0;
			//si el check de la negrita esta seleccionado(true), tipo incrementa en 1.
			//si la desactivo llamo otra vez al action performer, si lo activo tipo es igual a 1 y lo desactivo es 1
			if(check1.isSelected()) tipo+=Font.BOLD;
			
			//tipo valdra 3 
			if(check2.isSelected()) tipo+=Font.ITALIC;
			
			//la variable tipo puede: valer 0(nada), 1(negrita), 2(cursiva), 3(las dos)
			texto.setFont(new Font("Serif",tipo,24));
			
		}
		
	}
}