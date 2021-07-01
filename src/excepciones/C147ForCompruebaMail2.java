package excepciones;

import javax.swing.JOptionPane;
//excepciones
//creo mi propia excepcion
public class C147ForCompruebaMail2 {

	public static void main(String[] args) {
	
		String mimail=JOptionPane.showInputDialog("Introduce mail");
		
		
		try {
		examinaMail(mimail);
		
		}catch(Exception e) {
			
			System.out.println("no puedes introducir menos de 3 caracteres en la direccion de mail");
			
			//imprime los errores que se lanzaron, asi sabemos que clase ha generado esa excepcion
			e.printStackTrace();
		}
	}

	
	//le digo que el metodo lanza una exception
	static  void examinaMail (String mail) throws LongitudMailErronea{
		

		int arroba=0;
		boolean punto=false;
		
		
		//le digo cuando la lanza
	if(mail.length()<=3) {
		
     //en el constructor le paso el mensaje que debe aparecer al lanzar la excepcion
		//o uso el constructor por defecto porque ya estoy capturando el error
		
		throw new LongitudMailErronea();
		
	}else {
		
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
	
}

//creo mi propia clase que herede de exception
//se recomienda que haya dos constructores: sin parametros y con un mensaje
//al heredar de exception me obliga a usar el try catch

class LongitudMailErronea extends Exception {
	
	public LongitudMailErronea() {};
	
	public LongitudMailErronea(String msj_error) {
		//llamo al constructor de la clase padre, exception.
		super(msj_error);
		
		
	}
	
	
	
}













