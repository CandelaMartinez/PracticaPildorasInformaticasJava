package primerosPasos;
public class ArrayForEach {

	public static void main(String[] args) {
		String paises2[]=new String[8];
		
		paises2[0]="españa";
		paises2[1]="mexico";
		paises2[2]="colombia";
		paises2[3]="peru";
		paises2[4]="chile";
		paises2[5]="argentina";
		paises2[6]="ecuador";
		paises2[7]="venezuela";

		
		String[] paises= {"españa", "mexico", "colombia", "peru", "argentina", "ecuador", "venezuela"};
		
		for(int i=0; i<paises.length;i++) {
			
			System.out.println("pais "+(i+1) +" : "+ paises[i]);
		}
		
		
		//for each
		for(String elemento:paises) {
			System.out.println("pais: "+elemento);
			
		}
		
		
	}

}
