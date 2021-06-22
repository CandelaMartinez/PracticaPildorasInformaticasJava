package primerosPasos;

public class Arrays {

	public static void main(String[] args) {
        //declaracion explicita
		int[] miMatriz3 = new int[5];
		int miMatriz2[] = new int[5];
		
		
		//declaracion implicita
		int [] miMatriz= {5, 38, -15, 92, 71, 66, 57, 34, 53, 43, 55 , 66, 11, 53, 12, 55, 79, 55,23,21};

		miMatriz[0] = 5;
		miMatriz[1] = 38;
		miMatriz[2] = -15;
		miMatriz[3] = 92;
		miMatriz[4] = 71;

		System.out.println(miMatriz[3]);

		for (int i = 0; i < miMatriz.length; i++) {

			System.out.println("valor del indice " + i + " = " + miMatriz[i]);
		}

	}

}
