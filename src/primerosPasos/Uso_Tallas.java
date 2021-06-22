package primerosPasos;
import java.util.*;

public class Uso_Tallas {

	//enum Talla {MINI,MEDIANO,GRANDE,MUY_GRANDE};
	
	enum Talla{
		
		MINI("S"), MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
		
		private Talla(String abreviatura) {
			this.abreviatura=abreviatura;
		}
		
		public String dameAbreviatura() {
			return abreviatura;
		}
		
		private String abreviatura;
		
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner entrada =new Scanner(System.in);
		System.out.println("escribe una talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");
		String entrada_datos=entrada.next().toUpperCase();
		
		//devuelve el nombre a la constante enumerada del valor
		//almacenado en entrada_datos, que es el que escribe el usuario
		Talla la_talla=Enum.valueOf(Talla.class, entrada_datos);
		
		System.out.println("talla= "+la_talla);
		System.out.println("abreviatura= "+la_talla.dameAbreviatura());
		
	
	}

}


