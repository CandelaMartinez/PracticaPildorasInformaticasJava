package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;


public class C62TrabajandoConFuentes {

	public static void main(String[] args) {
		MarcoConFuentes mimarco=new MarcoConFuentes();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoConFuentes extends JFrame {
	public MarcoConFuentes() {
		
			setTitle("prueba colores");
			setSize(400,400);
			LaminaConFuentes milamina= new LaminaConFuentes();
			add(milamina);
			//si quiero que todo este del mismo color
			milamina.setForeground(Color.MAGENTA);
	}
}

class LaminaConFuentes extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		//crear una instancia de la clase Font(nombre, tipo, tamaño )
		Font mifuente = new Font ("Arial",Font.BOLD,26);
		
		g2.setFont(mifuente);
		//g2.setColor(Color.CYAN);
		g2.drawString("Juan", 100, 100);
		
		//creo otra fuente, la instancio de setFont
		g2.setFont(new Font("Arial",Font.ITALIC,40));
		//g2.setColor(new Color(128,90,59));
		g2.drawString("curso java", 100, 200);
	}
}