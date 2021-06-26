package graficos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

//controlar los eventos que se disparan al introducir campo de texto y borrar campo de texto

public class C88Prueba {

	public static void main(String[] args) {
		MarcoPrueba miMarco=new MarcoPrueba();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoPrueba extends JFrame{
	public MarcoPrueba() {
		setBounds(500,300,500,350);
		LaminaPrueba miLamina=new LaminaPrueba();
		add(miLamina);
		setVisible(true);
	}
}

class LaminaPrueba extends JPanel{
	
	public LaminaPrueba() {
		JTextField miCampo=new JTextField(20);
		
		//creo una instancia de la clase que gestiona los eventos
		EscuchaTexto elEvento=new EscuchaTexto();
		
		//guardo en una variable el contenido del textfield en formato documento
		Document midoc=miCampo.getDocument();
		//poner ese documento a la escucha, con la instancia de los eventos como parametro
		midoc.addDocumentListener(elEvento);
		
		
		add(miCampo);
	}
	
	//clase interna que gestiona los eventos, debe implementar la I DocumentListener
	private class EscuchaTexto implements DocumentListener{

		//implemento metodos de la interface
		
		//cuando inserte texto en ese cuadro poner un texto
		@Override
		public void insertUpdate(DocumentEvent e) {
			System.out.println("haz insertado texto");
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			System.out.println("haz borrado texto");
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}