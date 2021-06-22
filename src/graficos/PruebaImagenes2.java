package graficos;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaImagenes2 {
	public static void main(String[] args) {
		MarcoImagen2 mimarco=new MarcoImagen2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

	
}
class MarcoImagen2 extends JFrame{
	public MarcoImagen2() {
		setTitle("Marco con Imagen2");
		setBounds(750,300,900,1200);
		LaminaConImagenes2 milamina= new LaminaConImagenes2();
		add (milamina);
	}
	
}



//usare el metodo read() de la clase ImageIO del paquete Javax.imageIO
class LaminaConImagenes2 extends JPanel{
	//cada vez que llame al constructor tendre una imagen cargada en memoria
	public LaminaConImagenes2() {
		//metodo read de la clase ImageIO(ruta a la imagen)
				//lanza una exception, tengo que solventarla con un try catch
		 File miimagen2=new File("src/graficos/animal.gif");
				try {
				imagen2=ImageIO.read(miimagen2);
				}catch(IOException e) {
					System.out.println("la imagen no se encuentra");
				}
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		
		
		
		//ancho de la imagen, parametro (this) es la lamina, es el objeto que esta esperando que se cargue la imagen
		int ancho= imagen2.getWidth(this);
		int alto=imagen2.getHeight(this);
		
		
		
		//dibujo la imagen: objeto, x, y , observador de imagen (para ver como va apareciendo pixel a pixel
		g.drawImage(imagen2, 0, 0,null);
		
		
		//origen desde donde quiero copiar x , y, ancho de lo que quiero copiar, alto, coordenada x donde quiero copiar, y
		//4 primeros parametros que quiero copiar, 2 ultimos el destino
		//g.copyArea(0, 0, 400,250,400,0);
		
		//for para que se incrementen los valores del destino asi forma un mosaico
		for (int i=0; i<400; i++) {
			for (int j=0;j<250;j++) {
				//si es mayor que 0 se copia, sino se copia arriba del original
				if(i+j>0) {
				g.copyArea(0, 0, ancho,alto,ancho*i,alto*j);
				}
			}
		}
		
		
	}
	
	
	//variable de la clase Image para almacenar la imagen asi
	//paquete java awt 
	private Image imagen2;
}
