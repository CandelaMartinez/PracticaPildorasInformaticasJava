package primerosPasos;

import java.util.*;

public class While2AdivinaNumeros {

	public static void main(String[] args) {
		//adivina numero
		
		//ejecuta el codigo dentro una vez y luego evalua y si es verdadero vuelve a ejecutar
		//ejecuta el codigo por lo menos una vez
		//metodo random, de la clase Math genera un double aleatorio entre 0 y 1.
		//si lo multiplico *100 me da el numero que necesito
		//metodo estatico: no hace falta crear un obejto. si poner la clase delante 
		
		//refundicion para que el double pase a entero: 
		int aleatorio=(int)(Math.random()*100);
		
//		System.out.println(aleatorio);
		
		
		Scanner entrada=new Scanner(System.in);
		
		int numero=0;
		
		int intentos=0;
		
		do{
			intentos++;
			System.out.println("Introduce un numero:" );
			//numero tiene que ser igual al proximo entero que introduzcas por consola
			numero= entrada.nextInt();
			
			//comparar los numeros
			if (aleatorio<numero) {
				System.out.println("el numero que tenes que adivinar es menor a: "+numero);
			}else if (aleatorio>numero) {
				System.out.println("el numero que tenes que adivinar es mayor a:"+numero);
			}
				
			
		}while (numero!=aleatorio);
		
		System.out.println("correcto. lo has conseguido en "+intentos+" intentos.");
		
		
		entrada.close();

	}

}
