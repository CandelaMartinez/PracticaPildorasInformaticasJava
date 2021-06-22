package graficos;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class PruebaImagenes {

	public static void main(String[] args) {
		MarcoImagen mimarco=new MarcoImagen();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

	
}
class MarcoImagen extends JFrame{
	public MarcoImagen() {
		setTitle("Marco con Imagen");
		setBounds(750,300,900,1200);
		LaminaConImagenes milamina= new LaminaConImagenes();
		add (milamina);
	}
	
}



//usare el metodo read() de la clase ImageIO del paquete Javax.imageIO
class LaminaConImagenes extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		File miimagen=new File("src/graficos/arbol.png");
		
		//metodo read de la clase ImageIO(ruta a la imagen)
		//lanza una exception, tengo que solventarla con un try catch
		try {
		imagen=ImageIO.read(miimagen);
		}catch(IOException e) {
			System.out.println("la imagen no se encuentra");
		}
		
		//dibujo la imagen: objeto, x, y , observador de imagen (para ver como va apareciendo pixel a pixel
		g.drawImage(imagen, 5, 5,null);
		
		
	}
	
	
	//variable de la clase Image para almacenar la imagen asi
	//paquete java awt 
	private Image imagen;
}



