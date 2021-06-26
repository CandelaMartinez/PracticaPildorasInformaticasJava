package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//creo un gran area de texto en el centro
//sur: dos botones, agrega o quita (ON OFF) saltos de linea y inserta texto
//todo dentro de una misma clase
public class C91PruebaArea {

	public static void main(String[] args) {
		MarcoPruebaArea mimarco= new MarcoPruebaArea();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoPruebaArea extends JFrame{
	public MarcoPruebaArea() {
		setTitle("probando areas de texto");
		setBounds(500, 300, 500, 350);
		
		//establecer un Layout en el propio marco, no dentro de lalamina
		setLayout(new BorderLayout());
		
		//inicio la lamina
		laminaBotones= new JPanel();
		
		//inicio Boton, lo pongo a la escucha del evento click, que inserta un texto por defecto
		botonInsertar=new JButton("insertar");
		
		botonInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//clase JtextArea: metodo append (string) agrega a continuacion el texto
				
				areaTexto.append("en un lugar de la mancha de cuyo nombre no quiero acordarme*****");
				
			}
		});
			
			//agregar el boton a la lamina en la parte inferior del marco
		laminaBotones.add(botonInsertar);
		
		//agregar el otro boton
		botonSaltoLinea=new JButton("salto Linea");
		//ponerlo a la escucha on off
		botonSaltoLinea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//detectar si el area de texto tiene o no tiene salto de linea
				
				//saltar es lo contrario al resultado del metodo
				boolean saltar=!areaTexto.getLineWrap();
				//apaga o prende el salto de linea
				areaTexto.setLineWrap(saltar);
				
				//dependiendo si hay o no salto de linea el texto cambia
				if(saltar) {
					botonSaltoLinea.setText("quitar salto");
				}else {
					botonSaltoLinea.setText("salto linea");
				}
				
			}
		});
			//agregamos los componentes
		laminaBotones.add(botonSaltoLinea);
		add(laminaBotones,BorderLayout.SOUTH);
		//inicio area de texto
		areaTexto=new JTextArea(8,20);
		//agrego el area de texto a la lamina de scroll
		laminaBarras= new JScrollPane(areaTexto);
		//agregar lalamina 
		add(laminaBarras, BorderLayout.CENTER);
	
		
	}
	
	//crear dos laminas, uno con un cuadro de texto en center, otra en zona sur con botones
	private JPanel laminaBotones;
	//botones
	private JButton botonInsertar, botonSaltoLinea;
	//area de texto
	private JTextArea areaTexto;
	//lamina scroll
	private JScrollPane laminaBarras;
	
}