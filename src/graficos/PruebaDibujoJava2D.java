package graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDibujoJava2D {
	public static void main(String[] args) {
		//instancio marco, visible y que pasa cuando cierra marco
		MarcoConDibujos2 miMarco=new MarcoConDibujos2();
		
		miMarco.setVisible(true);
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
//marco
class MarcoConDibujos2 extends JFrame{
	
	//constructor
	public MarcoConDibujos2() {
		setTitle("prueba de dibujo");
		setSize(400,400);

		//agrego la lamina
		LaminaConFiguras2 miLamina= new LaminaConFiguras2();
		add(miLamina);
		
	}
	
}
//lamina
class LaminaConFiguras2 extends JPanel{
	//sobreescribo metodo paintComponent de JPane
	
	public void paintComponent(Graphics g){
		//llamo al metodo padre para que haga su trabajo
		super.paintComponent(g);
	
		//dibujar un rectangulo: instanciar clase Rectangle2d y necesito objeto de Graphics2d con parametro: instancia de obj que implemente interface Shape
		
		//refundicion del objeto graphics en objeto graphics2d representado por la variable objeto g2
		Graphics2D g2=(Graphics2D) g;
		
		//instanciar la clase Rectangle2D, pero su subclase porque es una clase abstracta que no se puede instanciar
		//polimorfismo: puedo meter una hija donde se espera una madre
		Rectangle2D rectangulo= new Rectangle2D.Double(100,100,200,150);
		
		//uso el metodo de la clase Graphics2D, parametro de un objeto que implemente la interface Shape
	    g2.draw(rectangulo);
	    
	    //instanciar la clase 
	    Ellipse2D elipse=new Ellipse2D.Double();
	    
	    //metodo de la clase ellipse2d, dibuja el cuadrado imaginario donde va la elipse dentro para poder posicionarla
	    //uso el rectangulo que tengo dibujado como limite de la elipse
	    elipse.setFrame(rectangulo);
	    
	    //ya tengo las dimensiones, dibujarla
	    g2.draw(elipse);
		
	    //dibujo una linea, instancio un objeto Line2D como parametro en lugar de construirlo fuera
	    //puse como punto inicial y final que coincida con el rectangulo
	    g2.draw(new Line2D.Double(100,100,300,250));
	    
	    //toma como centro de la circunferencia ese punto dentro del rectangulo y dibuja el circulo fuera de ese rectangulo
	    //dibujar un circulo que englobe todo
	    //donde esta el punto intermedio de x y
	    double centroX=rectangulo.getCenterX();
	    double centroY=rectangulo.getCenterY();
	    //radio igual al alto del rectangulo que cree
	    double radio=150;
	    Ellipse2D circulo= new Ellipse2D.Double();
	    circulo.setFrameFromCenter(centroX, centroY, centroX+radio, centroY+radio);
	    
	    //dibujarla
	    g2.draw(circulo);
	    
	    
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	}
}
