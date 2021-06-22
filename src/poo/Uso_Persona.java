package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		
Persona[] lasPersonas=new Persona[2];
lasPersonas[0]=new Empleado2("Clara",50000,2009,02,25);
lasPersonas[1]=new Alumno("Ramon","Biologia");

for (Persona p: lasPersonas) {
	System.out.println(p.dameNombre() + " , "+ p.dameDescripcion());
}
		
		
		
		
	}

}

abstract class Persona{
	//variable de clase
	private String nombre;
	
	//constructor 
	public Persona(String nom) {
		nombre=nom;
	}
	//metodo
	public String dameNombre() {
		return nombre;
	}
	//metodo abstracto
	public abstract String dameDescripcion();
	
}



class Empleado2 extends Persona{
	
	public Empleado2(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom);
		sueldo=sue;
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
		Id=IdSiguiente;
		IdSiguiente++;
			}
	//estoy obligada a reescribir el metodo dameDescripcion de la clase persona abstracta
	
	public String dameDescripcion(){
		return "este empleado tiene un Id= " + Id + " con un sueldo = "+ sueldo;
	}
	
	
	public double dameSueldo() {
		return sueldo;
	}
	
	public Date dameFechaContrato() {
		return altaContrato;
	}
	
	public int dameId() {
		return Id;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento=sueldo*porcentaje/100;
		sueldo+=aumento;
	}
	
			private double sueldo;
			private Date altaContrato;
			private int Id;
			public static int IdSiguiente=1;
			
}


class Alumno extends Persona{
	
	//constructor
	public Alumno(String nom,String car) {
		super(nom);
		
	carrera=car;
	}
	
	//variable
	private String carrera;
	
	//sobreescritura del metodo abstracto
	public String dameDescripcion() {
		return "este alumno esta estudiando la carrera de "+carrera;
	}
	
}

