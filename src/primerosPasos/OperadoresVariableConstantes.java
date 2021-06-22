package primerosPasos;

public class OperadoresVariableConstantes {
	 public static void main(String[] args) {
	        int a=5;
	        int b;
	        b=7;
	        int c =b+a;
	        System.out.println(c);
	    // incremento en 1 el ultimo valor de c
	        c++;
	    // imprimo el ultimo valor de c (incrementado)
	        System.out.println(c);
	    // incremento el ultimo valor de c en 6 mas e imprimo
	        c+=6;   
	        System.out.println(c);

	    // constantes, no podemos cambiarle el valor inicial asignado
	    final int d=5;
	    System.out.println(d);
	    final double apulgadas=2.54;
	    double cm=6;
	    double resultado= cm/apulgadas;
	    System.out.println("en " + cm + " cm hay " + resultado + " pulgadas");

	    //declarar muchas variables de un mismo tipo en una linea
	    int operador1, operador2, rresultado;
	    operador1=8;
	    operador2=7;
	    rresultado= operador1+operador2;
	    System.out.println(rresultado);
	 


	    
	    }

}
