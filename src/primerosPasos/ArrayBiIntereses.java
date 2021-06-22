package primerosPasos;

public class ArrayBiIntereses {

	public static void main(String[] args) {
		double acumulado;
		double interes= 0.10;
		
		double [] [] saldo= new double [6][5];
		
		for (int i=0; i<6; i++) {
			
			//saldo inicial y acumulado fijo en 10000 en todas las posiciones
			saldo[i][0]=10000;
			acumulado=10000;
			
			//j comienza de 1 ya que la posicion 0 es fija en 10000
			for(int j=1;j<5;j++) {
				
				//interes=0.10
				acumulado=acumulado+(acumulado*interes);
				
				saldo[i][j]=acumulado;
				
				}
	
			//una vez que recorri la posicion j le sumo a interes
			interes=interes+0.01;
		}
			
		
		
		for(int z=0; z<6; z++) {
			System.out.println();
			
			for (int h=0; h<5; h++ ) {
				
				System.out.printf("%1.2f",saldo[z][h]);
				
				System.out.print("   ");
			}
			
		}
		

	}

}
