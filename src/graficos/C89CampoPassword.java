package graficos;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//etiqueta usuario y cuadro de texto usuario
//etiqueta clave y cuadro de texto invisible
//boton para enviar el texto a una bbdd

//lamina principal BorderLayout, en el nord unalamina que tiene gridLayout
//en el sur de la lamina principal un boton de envio


//funcionalidad: entre 8 y 12 caracteres
//hasta que no llegue a 8 estara todo el rojo, si me paso de 12 tambien
public class C89CampoPassword {

	public static void main(String[] args) {
		MarcoPassword miMarco= new MarcoPassword();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoPassword extends JFrame{
	public MarcoPassword() {
		setBounds(400,300,550,400);
		LaminaPassword miLamina=new LaminaPassword();
		
		add(miLamina);
		setVisible(true);
	}
}

class LaminaPassword extends JPanel{
	
	JPasswordField cConstrasegna;
	
	public LaminaPassword() {
		//lamina principal
		setLayout(new BorderLayout());
		
		//segunda lamina
		JPanel laminaSuperior= new JPanel();
		laminaSuperior.setLayout(new GridLayout(2,2));
		
		//lamina secundaria en el norte de la principal
		add (laminaSuperior, BorderLayout.NORTH);
		
		
		//en lamina superior dos etiquetas
		JLabel etiqueta1=new JLabel("Usuario");
		JLabel etiqueta2=new JLabel("Contraseña");
		
		//cuadro de texto
		JTextField cUsuario=new JTextField(15);
		
		//creo la instancia del evento
		CompruebaPass miEvento= new CompruebaPass();
		
		
		//contraseña
		cConstrasegna= new JPasswordField(15);
		
		//pongo a cContra a la escucha el documento
		cConstrasegna.getDocument().addDocumentListener(miEvento);
		
		//agrego a la lamina superior los elementos
		laminaSuperior.add(etiqueta1);
		laminaSuperior.add(cUsuario);
		laminaSuperior.add(etiqueta2);
		laminaSuperior.add(cConstrasegna);
		
		//agrego el boton en el sur de lalamina principal
		
	JButton enviar= new JButton ("enviar");
	
	add(enviar,BorderLayout.SOUTH);
		
		
	}
	
	//clase interna que gestiona los eventos
	private class CompruebaPass implements DocumentListener{

		
		//a medida que ingrese caracteres  cuente la longitud
		//si es <8 y >12 rojo, sino blanco. 
		//getPassword() de la clase JPasswordField.devuelve el texto, un array de tipo char
		//uso la propiedad length para ver la longitud del array
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			//almaceno en el array los caracteres 
			char [] contra;
			contra=cConstrasegna.getPassword();
		
			if(contra.length<8||contra.length>12) {
				cConstrasegna.setBackground(Color.RED);
				
			}else {
				
				cConstrasegna.setBackground(Color.WHITE);
			}
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			char [] contra;
			contra=cConstrasegna.getPassword();
		
			if(contra.length<8||contra.length>12) {
				cConstrasegna.setBackground(Color.RED);
				
			}else {
				
				cConstrasegna.setBackground(Color.WHITE);
			}
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
}