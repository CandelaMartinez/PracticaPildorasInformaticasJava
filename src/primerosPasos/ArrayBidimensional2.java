package primerosPasos;

public class ArrayBidimensional2 {

	public static void main(String[] args) {
	
		
		int [][] matrix2= { 
				{10,15,18,19,21},
				{18,99,32,45,23},
				{55,63,62,22,42},
				{44,62,77,22,42}
				
		};

	
		for (int i = 0; i < 4; i++) {

			System.out.println();

			for (int j = 0; j < 5; j++) {

				System.out.print(matrix2[i][j] + " - ");

			}

		}
		
		for(int[] fila:matrix2) {
			
			System.out.println();
			
			for(int z:fila) {
				System.out.print(z + " - ");
			}
			
		}
		
	
	
	}

}
