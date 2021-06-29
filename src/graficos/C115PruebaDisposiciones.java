package graficos;

import java.awt.BorderLayout;

import javax.swing.*;
//meter dentro una caja vertical: dentro 3 cajas horizontales con elementos dentro

public class C115PruebaDisposiciones {

	public static void main(String[] args) {
		MarcoCaja mimarco = new MarcoCaja();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoCaja extends JFrame {
	public MarcoCaja() {
		setTitle("marco en la caja");
		setBounds(600, 350, 200, 200);

		// ...................................................................................
		// primera caja horizontal
		// etiqueta
		JLabel rotulo1 = new JLabel("nombre");

		// cuadro de texto
		JTextField texto1 = new JTextField(10);
		// tamaño maximo de la caja de texto, parametro: objeto tipo dimension
		texto1.setMaximumSize(texto1.getPreferredSize());

		// creo la caja horizontal
		Box cajaHorizontal1 = Box.createHorizontalBox();

		// mete dentro del contenedor horizontal los elementos con espacios entre
		// elementos
		cajaHorizontal1.add(rotulo1);

		cajaHorizontal1.createHorizontalStrut(10);

		cajaHorizontal1.add(texto1);
		// ...................................................................................
		// segunda caja horizontal
		// etiqueta
		JLabel rotulo2 = new JLabel("contraseña");

		// cuadro de texto 
		JTextField texto2 = new JTextField(10);
		// tamaño maximo de la caja de texto, parametro: objeto tipo dimension
		texto2.setMaximumSize(texto2.getPreferredSize());

		// creo la caja horizontal
		Box cajaHorizontal2 = Box.createHorizontalBox();

		// mete dentro del contenedor horizontal los elementos con espacios
		
		cajaHorizontal2.add(rotulo2);

		cajaHorizontal2.createHorizontalStrut(10);

		cajaHorizontal2.add(texto2);

		//....................................................................................
		//tercera caja horizontal
		
		JButton boton1= new JButton("ok");
		JButton boton2= new JButton("Cancelar");
		
		//creo 3 caja horizontal
		Box cajaHorizontal3 = Box.createHorizontalBox();
		
		//meto dentro los elementos y espacios (que se adaptan cuando redimensiona)
		
		cajaHorizontal3.add(boton1);
		
		cajaHorizontal3.add(Box.createGlue());
		
		cajaHorizontal3.add(boton2);
		
		//...................................................................................
		//box vertical que va a contener todos los box horizontales
		
		Box cajaVertical= Box.createVerticalBox();
		
		cajaVertical.add(cajaHorizontal1);
		
		cajaVertical.add(cajaHorizontal2);
		
		cajaVertical.add(cajaHorizontal3);
		
		//agregar la caja vertical al marcos, ubicacion
		
		add(cajaVertical,BorderLayout.CENTER);
		
		//...................................................................................
		
		
		
		
	}
}