package poo;
//HERENCIA USO: REUTILIZACION DE CODIGO
import javax.swing.*;

public class Uso_Vehiculo {

	public static void main(String[] args) {
		
//creo dos objetos que comparten una estructura en comun, instancio una clase
		
		//renault es un ejemplar de clase coche, instanciamos la clase
		//nombreClase nombreObjeto = new nombreConstructor()
		//el operador new llama al constructor de la clase
		
		Coche Renault= new Coche();
		
		
		
		//instancio una clase del tipo coche
		Coche micoche=new Coche();
		
		//modificar el color del coche setter, le tengo que pasar el parametro de color
		micoche.establece_color(JOptionPane.showInputDialog("introduce color: "));
		
		//obtengo el valor de la propiedad getter
		System.out.println(micoche.dime_color());
		
		//uso el metodo publico del tipo getter: objeto.metodo 
		
		System.out.println(micoche.dime_datos_generales());
		
		//uso metodos getter y setter para asientos de cuero, paso el parametro
		micoche.configura_asientos(JOptionPane.showInputDialog("tiene asientos de cuero?: "));
		System.out.println(micoche.dime_asientos());
		
		//uso los metodos para climatizador
		micoche.configura_climatizador(JOptionPane.showInputDialog("tiene climatizador?"));
		System.out.println(micoche.dime_climatizador());
		
		//no hace falta primero establecerlo porque hace las dos cosas a la vez
		System.out.println(micoche.dime_peso_coche());
		
		System.out.println("el precio final del coche es: "+micoche.precio_coche());
		
		System.out.println("-------------------------------------------------------------------------");
		//creo instancias pertenecientes a la clase coche y a la clase furgoneta usando los constructores
		
		Coche micoche1=new Coche();
		Furgoneta mifurgoneta1= new Furgoneta(7,580);
		
		
		//le doy un color a micoche1, objeto de la clase Coche
		//le doy color, asientos, climatizador a mifurgoneta1, usando un metodo heredado de clase coche
		micoche1.establece_color("Rojo");
		
		mifurgoneta1.establece_color("Gris");
		mifurgoneta1.configura_asientos("si");
		mifurgoneta1.configura_climatizador("si");
		
		System.out.println(micoche1.dime_datos_generales()+" "+micoche1.dime_color());
		
		System.out.println(mifurgoneta1.dimeDatosFurgoneta()+" "+mifurgoneta1.dimeDatosFurgoneta());
		
		
	}

}
//modularizacion: poner en un mismo paquete 2 programas que dependen uno del otro para funcionar
//aplicaciones complejas quedan reducidas a pequeños bloques de codigo, mas facil de depurar errores
//clase principal: desde ahi comienza la ejecucion del programa, todo package tiene un main
//
//encapsulacion: las clases de un paquete se comunican entre si con metodos. la funcionalidad se hace solo desde la propia clase
//hay una serie de datos que tiene que encapsularse, las ruedas solo se pueden modificar desde la propia clase
//se agrega un modificador de acceso, private, delante del dato que quiero encapsular (private, public, protected y el modificador por defecto)
//
//metodos: las clases se comunican entre si a traves de metodos. porque las clases estan encapsuladas 
//metodos de acceso: setters o definidores: establece el valor de una propiedad
//public void(este metodo no devuelve ningun valor, no lleva return)    nombre_metodo()  {codigo que modifique valor de la propiedad}
//metodos de acceso: getters o captadores: obtenemos el valor de una propiedad
//public(acceder al metodo desde cualquier otra clase)dato_que_devuelve  nombre_metodo() {codigo + return}
//
//paso de parametros: a la vez que llamas al metodo le pasas un valor