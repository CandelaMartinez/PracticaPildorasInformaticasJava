package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class C62QueTiposDeLetraHay {

	public static void main(String[] args) {
		String fuente=JOptionPane.showInputDialog("introduce fuente");
		boolean estalafuente=false;
		
		//que tipos de letra tengo instaladas en el ordenador, me devuelve un array con los tipos de letras
		String [] nombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	
		for (String nombreFuente:nombresDeFuentes) {
			if(nombreFuente.equalsIgnoreCase(fuente)) {
				estalafuente=true;
			}
			
		
		}
		if(estalafuente) {
			System.out.println("fuente instalada");
		}else {
			System.out.println("no esta instalada la fuente");
		}
	
	}

}
