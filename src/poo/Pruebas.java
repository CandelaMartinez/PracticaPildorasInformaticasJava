package poo;
//FINAL:CONSTANTE PARA QUE NADIE PUEDA MODIFICAR CIERTOS VALORES 
//CAMPOS constantes VARIABLES STATIC: TODOS LOS OBJETOS COMPARTIRAN LA VARIABLE STATIC 
//METODOS STATIC: NO ACTUAN SOBRE OBJETOS, NO ACCEDEN A CAMPOS DE EJEMPLAR (VARIABLES Y CONSTANTES
//DECLARADAS EN LA CLASE) A MENOS QUE ESTAS SEAN STATIC
//PARA LLAMARLOS SE USA NOMBRE_CLASE.NOMBRE_METODO

public class Pruebas {

	public static void main(String[] args) {
		
		//crear objetos de la clase empleados
		Empleados trabajador1= new Empleados("paco");
		Empleados trabajador2= new Empleados("maria");
		Empleados trabajador3= new Empleados("paco");
		Empleados trabajador4= new Empleados("maria");
		Empleados trabajador5= new Empleados("paco");
		Empleados trabajador6= new Empleados("maria");
		Empleados trabajador7= new Empleados("paco");
		Empleados trabajador8= new Empleados("maria");
		
		
		
		//paco cambia su seccion inicial
		trabajador1.cambiaSeccion("RRHH");
		
	
		
		//imprimo informacion del trabajador
		System.out.println(trabajador1.devuelveDato());
		System.out.println(trabajador2.devuelveDato());
		System.out.println(trabajador3.devuelveDato());
		System.out.println(trabajador4.devuelveDato());
		System.out.println(trabajador5.devuelveDato());
		System.out.println(trabajador6.devuelveDato());
		System.out.println(trabajador7.devuelveDato());
		System.out.println(trabajador8.devuelveDato());
		

		
		
		//llamo al metodo static que es metodo de clase y no de objeto
		//al no operar sobre objetos y pertenecer a la clase, hay que poner el nombre de la clase delante
		System.out.println(Empleados.dameIdSiquiente());
		
		
		
	}

}

//crear cada clase en un fichero diferente, en este caso es solo una prueba asi que no importa

class Empleados{
	
    
	//constructor: mismo nombre que clase
	public Empleados(String nom) {
		nombre=nom;
		seccion="administracion";
		Id=IdSiguiente;
		IdSiguiente++;
		
		
		
	}
	
	//metodos getter y setter. this hace referencia al campo de clase
	//la seccion tiene que ser igual al campo de clase que le pasemos por parametro
	public void cambiaSeccion(String seccion) {
		this.seccion=seccion;
	}
	//getter . tipo de dato que devuelve nombre
	public String devuelveDato() {
		return "el nombre es "+nombre+ " y la seccion es "+seccion+" y el id es "+Id;
	}
	
	//metodo static es metodo de clase
	//no puede acceder a variables de clase private
	//solo puede acceder a variables de clase static
	
	public static String dameIdSiquiente () {
		return "el Id siguiente es: "+IdSiguiente;
		
	}
	
	//CONVERTIMOS LA VARIABLE NOMBRE EN UNA CONSTANTE PARA QUE NADIE PUEDA CAMBIAR EL VALOR ALMACENADO
	//campos de clase
	private final String nombre;
	private String seccion;
	
	
	//static para que no tengan cada objeto su propia copia de id sino que haya una
	//static no pertenece a ningun objeto sino que pertenece a la clase
	//al llamarla se usa el nombre de la clase
	//sola copia de id y la compartan todos los objetos.
	//las variables publicas eclipse las pone en cursiva
	private int Id;
	private static int IdSiguiente=1;
	
	
	
}