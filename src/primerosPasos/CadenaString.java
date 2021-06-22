package primerosPasos;

public class CadenaString {
	 public static void main(String[] args) {
	        String nombre="Maria Candela Martinez";
	        System.out.println("mi nombre es: " + nombre);
	        System.out.println("mi nombre tiene: " +nombre.length() + " letras");
	        System.out.println("la primera letra de " + nombre + " es "+ nombre.charAt(0));
	//charAt me devuelve la letra en la posicion que le indique ()
	//ultima_letra me almacena el numero de letras de nombre=7
	//ultima_letra -1 seria la posicion 6 (0,1,2,..) porque empieza desde 0 a contar posicion
	        int ultima_letra;
	        ultima_letra=nombre.length();
	        System.out.println("la ultima letra es la: " + nombre.charAt(ultima_letra-1));

	        String frase="hoy es un estupendo dia para aprender a programar en java";

	//extraer posicion:29  posicion del caracter que no quiero extraer:57 (los espacios blanco se cuentan)
	        String frase_resumen=frase.substring(0, 29) + "irnos a la playa y olvidarnos de todo..."
	        + " y " +frase.substring(29,57);
	        System.out.println(frase_resumen);

	//comparar cadenas de caracteres, distingue entre mayusculas y minusculas. true or false

	        String alumno1, alumno2;
	        alumno1="David";
	        alumno2="david";
	        System.out.println(alumno1.equals(alumno2));

	//comparar cadenas de caracteres, no distingue entre mayusculas y minusculas:true or false

	        System.out.println(alumno1.equalsIgnoreCase(alumno2));
	        


	    }

}
