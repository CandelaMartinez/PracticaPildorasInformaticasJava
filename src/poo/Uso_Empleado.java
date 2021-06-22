package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
//ESTE FICHERO VA A GENERAR UN .JAVA Y DOS .CLASS PORQUE GENERA UN FICHERO POR CLASE
//SOBRECARGA DE CONSTRUCTORES: TIENE VARIOS METODOS CONSTRUCTORES CON EL MISMO NOMBRE DE LA CLASE
//TIENEN QUE RECIBIR DIFERENTE CANTIDAD Y TIPO DE PARAMETROS
//PARA DARLE A LOS OBJETOS DIFERENTES ESTADOS INICIALES
//el fichero tiene mas de una clase, solo una de las clases sera public y tendra main

public class Uso_Empleado {

	public static void main(String[] args) {
		
		//polimorfirmo:creo una instancia de la clase jefatura, estado inicial
		Jefatura jefe_RRHH =new Jefatura("maria",85000,2006,9,25);
		
		//polimorfismo: establecer un incentivo al objeto
		jefe_RRHH.estableIncentivo(2570);
		
		
		
		
		// unico fichero para construir y usar el objeto empleado
		//el nombre de la clase sera el nombre de la clase main
		//solo una de las clases pueder tener el modificador de acceso public y puede ser main
		//la ejecucion siempre comienza por main de la clase publica
		
		//construyo instancias de la clase empleado. objeto
//		Empleado empleado1=new Empleado("paco gomez", 85000, 1990, 12, 17);
//		Empleado empleado2=new Empleado("ana lopez", 95000, 1995, 6, 2);
//		Empleado empleado3=new Empleado("maria martin", 65000, 2001, 0, 12);
//		
//		empleado1.subeSueldo(5);
//		empleado2.subeSueldo(5);
//		empleado3.subeSueldo(5);
//		
//		System.out.println("nombre: "+empleado1.dameNombre()+" sueldo: "+empleado1.dameSueldo()+ " fecha de alta: "+ empleado1.dameFechaContrato());
//		System.out.println("nombre: "+empleado2.dameNombre()+" sueldo: "+empleado2.dameSueldo()+ " fecha de alta: "+ empleado2.dameFechaContrato());
//		System.out.println("nombre: "+empleado3.dameNombre()+" sueldo: "+empleado3.dameSueldo()+ " fecha de alta: "+ empleado3.dameFechaContrato());

		// xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		//otra alternativa: creo un array: String [] miarray=new String[3];
		//creo un array de la clase empleado que yo cree
		//este es un array que almacena un objeto, ese objeto tiene entro diferentes tipos de datos
		
		Empleado [] misEmpleados=new Empleado[6];
		
		//meto en el array misEmpleados, posicion 0, un new empleado usando el metodo constructor
		misEmpleados[0]=new Empleado("paco gomez",85000, 1990, 12, 17);
		misEmpleados[1]=new Empleado("ana lopez",95000, 1995, 06, 02);
		misEmpleados[2]=new Empleado("maria martin",105000, 2002, 03, 15);
		
		
		//agrego al array llamando al segundo constructor
		misEmpleados[3]=new Empleado("marcelo davis");
		misEmpleados[4]=jefe_RRHH;//polimorfismo en accion
		misEmpleados[5]=new Jefatura("juan",96000,1999,5,26);
		
		//REFUNDICION DE OBJETOS: casting para convertir el objeto del tipo empleado a tipo jefatura
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
        //puedo usar el metodo de la clase jefatura
		jefa_Finanzas.estableIncentivo(5000);
		
		//INTERFACES: uso los metodos de las interfaces
		System.out.println("el jefe "+jefa_Finanzas.dameNombre()+" tiene un bonus de "+jefa_Finanzas.estableceBonus(500));
		
		System.out.println(misEmpleados[3].dameNombre()+" tiene un bonus de: "+misEmpleados[3].estableceBonus(200));
		
		//INTERFACES.principio de sustitucion con dos clases
		Empleado director_comercial=new Jefatura("sandra",83000,2012,05,05);
		//la clase empleado implementa comparable interfaz
		Comparable ejemplo=new Empleado("eli",98000,2011,06,07);
		
		
		
		//for para subir el sueldo
		
		
		/*for(int i=0; i<misEmpleados.length; i++) {
			misEmpleados[i].subeSueldo(5);
		}*/
		
		
		//uso el metodo que me obliga a tener la interfaz jefes
		System.out.println(jefa_Finanzas.tomar_desiciones("dar mas dias de vacaciones"));
		
		
		
		
		
		//for each: creo una variable e del tipo objeto empleado, la uso en misEmpleados array para recorrer
		//subo el sueldo de e que va cambiando en cada vuelta con el valor del array
		for(Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
		
		//SORT ARRAY. METODO STATIC. TENGO QUE USAR LA CLASE DELANTE DEL METODO
		//simplemente por incluir esto nos obliga a que el tipo a ordenar implemente la interfaz comparable
		
		Arrays.sort(misEmpleados);
		
		
//		for para imprimir en pantalla el sueldo de los empleados
		
		
		/*for (int i=0; i<misEmpleados.length; i++) {
			System.out.println("nombre "+ misEmpleados[i].dameNombre()+" sueldo "+ misEmpleados[i].dameSueldo()+
					" fecha alta "+misEmpleados[i].dameFechaContrato());
		}*/
		
		//creo una variable e del tipo empleado y recorro el bucle
		for(Empleado e: misEmpleados) {
			System.out.println("nombre "+ e.dameNombre()+" sueldo "+ e.dameSueldo()+
					" fecha alta "+ e.dameFechaContrato()+" id "+e.dameId() );
		}
		
		
		
		
		
	}
	
	


}


class Empleado implements Comparable,Trabajadores{
	//creamos el constructor de la clase empleado que va a recibir parametros
	//metodo constructor debe llevar el nombre de la clase a la que pertenece, no lleva void ni devuelve datos
	//clase gregorian calendar: metodo gregorian calendar (con parametros) construye una fecha con parametros . importar paquete
	//para este constructor enero es el mes 0
	//new llama al constructor de la clase
	//metodo get time me devuelve la fecha, HERENCIA: una clase puede heredar de otra, la clase Gregorian Calendar hereda de la clase Calendar que hereda de la clase object
	//tiene los metodos y de la clase calendar + object mas los suyos propios.
	//uso variables construidas fueral bloque de codigo asi las puedo usar fuera
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
		Id=IdSiguiente;
		IdSiguiente++;
		
		
		}
	
	//creo el metodo compare to que me obliga la interfaz comparable a crear
	//devuelve un negativo si es menor, 0 si es igual o positivo si es mayor
	//sobreescribo metodo compareTo
	
	public int compareTo(Object miObjeto) {
		//refundicion: transformo el tipo Objeto a tipo Empleado
		Empleado otroEmpleado=(Empleado)miObjeto;
		if(this.Id<otroEmpleado.Id) {
			return -1;
		}
		if(this.Id>otroEmpleado.Id) {
			return 1;
		}
		return 0;
	}
	
	
	//sobrecarga de constructor: construyo metodo que le da un estado inicial diferente al objeto
	//this llama al otro constructor de la clase y pasarle los parametros correspondientes
	//se almacenan dentro del otro constructor y los parametros que no se los pongo como por defecto
	public Empleado(String nom) {
		this(nom,30000,2000,01,01);
	}
	
	
	
	//metodo getter que nos devuelve el nombre
	public String dameNombre() {
		return nombre;
	}
	//metodo getter devuelve sueldo
	public double dameSueldo() {
		return sueldo;
	}
	//metodo getter fecha alta
	public Date dameFechaContrato() {
		return altaContrato;
	}
	
	public int dameId() {
		return Id;
	}
	
	//metodo setter que suba el sueldo. establece el valor de una variable
	public void subeSueldo(double porcentaje) {
		double aumento=sueldo*porcentaje/100;
		sueldo+=aumento;
	}
	
	
	
	
	//creo las variables de clase en cualquier momento, al final de la clase
	//hay que importar el paquete de la clase Date, la clase String pertenece a java.lang que esta por defecto instalada
			private String nombre;
			private double sueldo;
			private Date altaContrato;
			private int Id;
			public static int IdSiguiente=1;
			
			
	//creo el metodo que al implementar la interface trabajadores me obliga a hacer
			@Override
			public double estableceBonus(double gratificacion) {
				return Trabajadores.bonusBase+gratificacion;
			}
	
}

//creo la clase jefatura(ojo, mejor hacerlo en un fichero aparte)

	class Jefatura extends Empleado implements Jefes{
	
	//al crear la jerarquia de interfaces obliga a la clase jEFAtura, al heredar de interface Jefes (qi
	//(que hereda de la interface trabajadores) a definir el metodo 
		
	
	//creo el constructor de la clase jefatura llamando al constructor padre
	public Jefatura(String nom, double sue, int agno,int mes,int dia) {
		super(nom,sue,agno,mes,dia);
		
	}
	
	//metodo que me obliga a implementar la interfaz Jefes
	public String tomar_desiciones(String desicion) {
		return "un miembro de la direccion ha tomado la desicion de: " + desicion;
	}
	
	
	//metodo setter para establecer el monto del incentivo
	public void estableIncentivo(double b) {
		incentivo=b;
	}
	//metodo getter que me de el sueldo del jefe
	//este metodo esta sobreescribiendo el metodo del padre empleado para la clase jefatura
	//lo cambia solo para esta clase. aparece un triangulo verde
	//super.llama a damesueldo de la clase padre
	public double dameSueldo() {
		double sueldoJefe=super.dameSueldo();
		return sueldoJefe+incentivo;
		
	}
	
	
	//variable incentico
	private double incentivo;

//la prima es porque estamos en la clase jefatura
	@Override
	public double estableceBonus(double gratificacion) {
	double prima=2000;
	
		return Trabajadores.bonusBase + gratificacion+prima;
	}
	
	
	
	
}













