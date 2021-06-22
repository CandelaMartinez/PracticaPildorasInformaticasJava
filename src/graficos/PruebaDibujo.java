package graficos;
import java.awt.*;
import javax.swing.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		//instancio marco, visible y que pasa cuando cierra marco
		MarcoConDibujos miMarco=new MarcoConDibujos();
		
		miMarco.setVisible(true);
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
//marco
class MarcoConDibujos extends JFrame{
	
	//constructor
	public MarcoConDibujos() {
		setTitle("prueba de dibujo");
		setSize(400,400);

		//agrego la lamina
		LaminaConFiguras miLamina= new LaminaConFiguras();
		add(miLamina);
		
	}
	
}
//lamina
class LaminaConFiguras extends JPanel{
	//sobreescribo metodo paintComponent de JPane
	
	public void paintComponent(Graphics g){
		//llamo al metodo padre para que haga su trabajo
		super.paintComponent(g);
		//cuadrado: posicion x de la esquina superior izq, posicion y, ancho, alto
		//g.drawRect(50, 50, 200, 200);
		
		//dibujo linea: x y del primer punto (inicial) x y del segundo punto (final) el los une con una linea
		//g.drawLine(100, 100, 300, 200);
		
		//dibujar arco: x, y, ancho de archo, alto de archo
		g.drawArc(50, 100, 100, 200, 120, 150);
		
		
		
	}
	
}