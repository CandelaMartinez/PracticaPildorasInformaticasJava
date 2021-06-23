package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class C57CreandoMarcoCentrado {

	public static void main(String[] args) {
		MarcoCentrado mimarco = new MarcoCentrado();
		
		//que va a hacer mi programa cuando se cierre el marco
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//por defecto es invisible, lo hago visible
		mimarco.setVisible(true);

	}

}

class MarcoCentrado extends JFrame{
	
	public MarcoCentrado() {
		
		//ver la resolucion de pantalla del sistema nativo. static, devuelve un objeto del tipo toolkit(sistema nativo donde se ejecuta), no recibe parametros
		//almaceno dentro de la variable objeto el sistema nativo de ventanas
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		
		//tamaño de la ventana, devuelve un objeto del tipo dimention que es el tamaño del monitor principal, abstract
		//importo paquete java.awt
		Dimension tamagnoPantalla=miPantalla.getScreenSize();
		
		//extraer los datos de ancho y alto. uso campos de clase de la clase dimension
		int alturaPantalla=tamagnoPantalla.height;
		int anchoPantalla=tamagnoPantalla.width;
		
		//creo un marco que sea de la mitad de mi pantalla
		setSize(anchoPantalla/2, alturaPantalla/2);
		
		//colocarla en el centro
		setLocation(anchoPantalla/4,alturaPantalla/4);
		
		//cambio titulo
		setTitle("marcoCentrado");
		
		//cambio icono, publico, abstract, devuelve obj tipo image, me pide el nombre del archivo como parametro (string)
		//admite jpg y png y gif. ruta relativa donde esta el icono alojado. partimos de la raiz de la ruta del proyecto
		Image miIcono=miPantalla.getImage("src/graficos/icono.png");
		
		setIconImage(miIcono);
		
	}
	
	
	
}