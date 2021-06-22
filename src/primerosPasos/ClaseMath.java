package primerosPasos;

public class ClaseMath {
	// uso de la clase Math para sacar la raiz cuadrada. usa el tipo double como parametro
	//devuelve un doble como resultado
	public static void main(String[] args) {
	        double raiz= Math.sqrt(9);
	        System.out.println(raiz);
	      

	//round admite como parametro un float devuelve un int (float num1=5.85F)
	//o recibe un doble y me devuelve un long
	//pero si no puedo cambiar los tipos de variables recurro a una
	//refundicion. ponemos el tipo de dato al que queremos transformarlo () delante 
	//cuando quiero cambiar tipo de dato y hay perdida de informacion(int)
	        double num1=5.85;
	        int resultado=(int)Math.round(num1);
	        System.out.println(resultado);

	//metodo pow eleva un numero a una potencia. base(numero) potencia(elevado)
	//convertimos a entero el resultado de pow(que me da un double) para que entre en mi variable int
	    double base=5;
	    double exponente=3;
	    int resultado2 =(int)Math.pow(base,exponente);
	    System.out.println("el resultado de " + base + " elevado a "+ exponente + " es " + resultado2);
	}

}
