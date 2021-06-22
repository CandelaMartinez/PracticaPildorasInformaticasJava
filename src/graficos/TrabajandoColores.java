package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoColores {
	
	public static void main(String[] args) {
		MarcoConColor mimarco=new MarcoConColor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		
	}
	

}

class MarcoConColor extends JFrame{
	public MarcoConColor() {
		setTitle("prueba colores");
		setSize(400,400);
		LaminaConColor milamina= new LaminaConColor();
		add(milamina);
		//color de fondo usando una constante static de clase
		//milamina.setBackground(Color.PINK);
		
		//da el color de fondo de las ventanas del sistema donde se ejecuta el programa
		milamina.setBackground(SystemColor.window);
		
	}
}

class LaminaConColor extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		//rectangulo relleno de color cyan
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
		
		//establesco color y dibujo trazo de rectangulo con draw
		g2.setPaint(Color.GREEN.darker().darker());
		g2.draw(rectangulo);
		
		//establezco color y dibujo relleno
		g2.setPaint(Color.CYAN);
		g2.fill(rectangulo);
		
		//elipse con trazo de color y sin relleno
		Ellipse2D elipse=new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		//g2.setPaint(Color.RED);
		
		//color creado con rgb. brighter() o darker() hasta 3 veces aplicado
		//g2.setPaint(new Color(0,140,255).darker().darker());
		
		//instancio la clase Color
		Color micolor= new Color(125,89,65);
		g2.setPaint(micolor);
		
		g2.draw(elipse);
		
		
	}
}