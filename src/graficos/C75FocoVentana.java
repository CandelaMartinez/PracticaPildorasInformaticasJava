package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

//todo en una unica clase

public class C75FocoVentana extends JFrame implements WindowFocusListener{

	public static void main(String[] args) {
		C75FocoVentana miv=new C75FocoVentana();
		miv.iniciar();

	}
	
	//contruye marcos
	public void iniciar() {
		
		//instancio marcos
		marco1=new C75FocoVentana();
		marco2= new C75FocoVentana();
		
		//hago visible el marco
		marco1.setVisible(true);
		marco2.setVisible(true);
		
		//posiciono y doy tamaño
		marco1.setBounds(300, 100, 600, 350);
		marco2.setBounds(1200, 100, 600, 350);
		
		//indico que hacer 
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//poner a los marcos a la escucha de los eventos correspondientes
		//indicamos cual sera la clase oyente, this porque es la propia clase
		marco1.addWindowFocusListener(this);
		marco2.addWindowFocusListener(this);
	}
	

	@Override
	public void windowGainedFocus(WindowEvent e) {
		if (e.getSource()==marco1) {
			marco1.setTitle("tengo el foco");
		}else {
			marco2.setTitle("tengo el foco");
		}
		
	}

	//tambien hay que decirle que hacer cuando pierda el foco
	//si no le digo, la frase anterior queda
	@Override
	public void windowLostFocus(WindowEvent e) {
		
		if (e.getSource()==marco1) {
			marco1.setTitle("");
		}else {
			marco2.setTitle("");
		}
	}

	//creo variables del tipo FocoVentana
	C75FocoVentana marco1;
	C75FocoVentana marco2;
	
}
