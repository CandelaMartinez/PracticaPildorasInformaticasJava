package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//construyo un marcos con un cuadro de texto y un boton allado 
//al pulsar el boton captura el texto del cuadro de texto y lo imprime en consola
//ejemplo: validar una direccion de email

//creo dos laminas: la principal tendra un borderLayout
//la segunda lamina en el norte de la principal : flowlayout: email, cuadro de texto y boton
//texto resultado en la zona center de la lamina principal

public class C86PruebaTexto {

	public static void main(String[] args) {
		MarcoTexto mimarco=new MarcoTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}

class MarcoTexto extends JFrame{
	public MarcoTexto () {
		setBounds(600,300,600,350);
		//creo la instancia de la lamina y la agrego al marco
		LaminaTexto milamina=new LaminaTexto();
		add(milamina);
		setVisible(true);
	}
}

//lamina principal
class LaminaTexto extends JPanel{
	//declaro variable para poder usarla en la clase interna
	private JTextField campo1;
	
	//declaro una etiqueta que usare para imprimir si la validacion da correcto o no
	private JLabel resultado;
	
	public LaminaTexto() {
		
		//le digo al constructor que tiene que tener una disposicion de BorderLayout
		setLayout(new BorderLayout());
		
		//construyo una 2 lamina
		JPanel lamina2= new JPanel();
		//establezco el layout de la 2 lamina: label de email, cuadro de texto y boton
		lamina2.setLayout(new FlowLayout());
		
		//construyo etiqueta de texto fijo dentro de la lamina
		JLabel texto1=new JLabel("Email: ");
		lamina2.add(texto1);
		
		//cuadro de texto, creo la instancia y luego la agrego a la lamina
		//el ancho del cuadro de texto se adapta al texto del interior
		//JTextField campo1=new JTextField("texto por defecto");
		//le doy un ancho de 20 columnas
		campo1=new JTextField(20);
		//se pueden combinar los dos
		//JTextField campo1=new JTextField("texto por defecto",20);
		lamina2.add(campo1);
		//imprime por consola el texto del cuadro
		//System.out.println(campo1.getText());
		//ignora los espacios en blanco
		//System.out.println(campo1.getText().trim());
		
		//posiciono resultado entre el boton y el cuadro de texto
		//inicio el JLabel, la posiciono entre el boton y el cuadro de texto
		//cambio la alineacion como 2 parametro al centro con una constante de clase static
		resultado= new JLabel("",JLabel.CENTER);

		
		
		
		
		//agregar un boton
		JButton miBoton=new JButton ("Comprobar");
		
		//poner el boton a la escucha del evento correspondiente:
		//creo la instancia del evento correspondiente
		DameTexto miEvento=new DameTexto();
		
		//agrego al boton el evento correspondiente mediante su instancia
		miBoton.addActionListener(miEvento);
		
		//agrego el boton a la lamina
		lamina2.add(miBoton);
		
		
		//agregue la lamina2 en la zona norte de la lamina principal
		add(lamina2,BorderLayout.NORTH);
		
		//elemento resultado en la zona centro de la lamina principal
		
		add(resultado,BorderLayout.CENTER);
		
		
		
	}
	
	//clase que gestiona el evento como clase interna
	private class DameTexto implements ActionListener{

		//metodo que implementa esta interface
		//que es lo que tiene que hacer al click
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(campo1.getText().trim());
			
			//evaluar si la direccion de mail es correcta
			//evalua cuantas @ hay
			int correcto=0;
			//guardo lo que esta dentro del cuadro de texto para recorrerlo caracter a caracter
			String email=campo1.getText().trim();
			
			//evaluo cuantos @ hay
			for(int i=0;i<email.length();i++) {
				if(email.charAt(i)=='@') {
					correcto++;
					
				}
				
				
			}
			
			if(correcto!=1) {
				
				resultado.setText("incorrecto");
				
			}else {
				resultado.setText("correcto");
			}
			
			
			
		}
		
	}
}
