package excepciones;

import javax.swing.JOptionPane;
//excepciones
//mail longitud<=3 caracteres lanzo una excepcion. provoco de manera manual una excepcion
//debo indicar en la declaracion que excepcion podria lanzar el metodo
public class C146ForCompruebaMail {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
	
		String mimail=JOptionPane.showInputDialog("Introduce mail");
		
		
		//meto la llamada al metodo en el try catch asi no para el programa si salta la excepcion
		//no me obliga a construir el try catch porque no ArrayIndexOutOfBoundsException no hereda de IOException
		try {
		examinaMail(mimail);
		
		}catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.println("no puedes introducir menos de 3 caracteres en la direccion de mail");
		}
	}

	static  void examinaMail (String mail) {
		

		int arroba=0;
		boolean punto=false;
		
		
		//genero de forma manual un error
		//si la direccion es menor a 3 caracteres, lanza este error
		//eligo una excepcion que se adapte, pongo una cualquiera solo a modo de prueba
		//no concuerda el tipo de error con lo que pasa, tengo que crear mi propia excepcion
	if(mail.length()<=3) {
		//instancio la clase de excepcion
		ArrayIndexOutOfBoundsException e= new ArrayIndexOutOfBoundsException();
		//lanzo esa instancia
		throw e;
		
		
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
