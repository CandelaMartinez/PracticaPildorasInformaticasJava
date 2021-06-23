package graficos;
import javax.swing.*;
import java.awt.*;

public class C58EscribiendoEnMarco {

	public static void main(String[] args) {
		//instancio la clase
		MarcoConTexto miMarco =new MarcoConTexto();
		
		//que hace mi programa cuando cierre el marco
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}

//clase para construir el marco
class MarcoConTexto extends JFrame{
	public MarcoConTexto() {
		
		setVisible(true);
		
		setSize(600, 450);
		
		setLocation(400, 200);
		
		setTitle("primer texto");
		
		//agregar la lamina que construi: instancio y agrego
		Lamina miLamina= new Lamina();
		
		add(miLamina);
		
		
		
	}
}

//clase para construir laminas
//no construyo constructor asi que usara el constructor por defecto (sin parametros)

class Lamina extends JPanel{
	//sobreescribir el metodo paintComponent que hereda de la clase JPanel
	//string, posicion x posicion y
	//sin sobreescribir me escribe algo por defecto, lo sobreescribo para que escriba lo que yo quiero
	
	
	public void paintComponent(Graphics g) {
		
		//haz tu trabajo y ademas escribe lo que yo quiero y donde yo quiero: invocar paintComponen de la clase JComponent
		super.paintComponent(g);
		
		g.drawString("Estamos aprendiendo Swing",100 ,100 );
		
		
		
	}
	
}