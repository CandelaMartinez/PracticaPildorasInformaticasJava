package primerosPasos;

import javax.swing.JOptionPane;

public class ForCompruebaMail {

	public static void main(String[] args) {
		//metodo charAt de la clase String: no estatico. devuelve char
		//metodo lenght de la calse String: no estatico. devuelve int
		
		int arroba=0;
		boolean punto=false;
		
		String mail=JOptionPane.showInputDialog("Introduce mail");
		
		//recorrer con un for caracter a caracter para ver si tiene un arroba
		
		for(int i=0; i<mail.length(); i++ ) {
			if(mail.charAt(i)=='@') {
				arroba++;
			}
			
			if(mail.charAt(i)=='.') {
				punto=true;
			}
			
			
		}
		
		if (arroba==1 && punto==true) {
			System.out.println("es correcto");
			
		}
		else {
			System.out.println("no es correcto");
		}

	}

}
