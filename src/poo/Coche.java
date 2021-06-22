package poo;

public class Coche {
	//especificar en la clase coche las caracteristicas comunes de los coches
	//encapsulo la variable, si puedo acceder pero no modificarla

	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	
	//defino variables de propiedades que pueden variar en cada coche
	//solo se pueden manipular dentro del metodo setter
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;
	
	
//	metodo constructor mismo nombre que la clase, establece un estado inicial del objeto
	public Coche() {
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500;
		}
	
	//a continuacion del metodo constructor creo el metodo getter que me dara los datos generales
	//tiene que ser publica para poder acceder desde otras clases(modificador de acceso)
	//un metodo getter esta obligado a llevar siempre una instruccion return
	public String dime_datos_generales() {
		return "la plataforma del vehiculo tiene "+ ruedas+ " ruedas, mide: "+ largo/1000+ " metros, con un ancho de "+ancho+
				" cm y un peso de plataforma de  "+peso_plataforma + " kilos";
		}
	
	//metodo setter para modificar el color , lo puedo usar desde otras clases porque es public
	//va a recibir un parametro cuando lo llamemos
	public void establece_color(String color_coche) {
		color=color_coche;
	}
	
	//metodo getter para que nos informe del nuevo color
	public String dime_color() {
		return "el color del coche es " + color;
	}
	
	//equalsignorecase compara cadenas de texto sea mayusculas o minusculas
	//metodo setter (establece, inicializa) y getter (lo veo)
	//this. hace referencia a la variable de la clase, se usa cuando dos variables se llaman igual
	public void configura_asientos(String asientos_cuero) {
		if(asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero=true;
		}else {
			this.asientos_cuero=false;
		}
	}
	
	public String dime_asientos() {
		if(asientos_cuero==true) {
			return "el coche tiene asientos de cueros";
		}else {
			return "el coche no tiene asientos de serie";
		}
	}
	
	//metodo setter y getter climatizador
	public void configura_climatizador(String climatizador) {
		if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	
	//es lo mismo if (climatizador) que if (climatizador==true)
	public String dime_climatizador() {
		if (climatizador) {
			return "el coche incorpora climatizador";
		}else {
			return "el coche lleva aire acondicionado";
		}
	}
	
	//establecemos el peso total del coche
	//metodo que es a la vez setter y getter, no recomendado en POO, establece y muestra
	//la variable peso_carroceria solo se puede ver dentro del metodo
	public String dime_peso_coche() {
		int peso_carroceria=500;
		peso_total=peso_plataforma+peso_carroceria;
		if(asientos_cuero==true) {
			peso_total=peso_total+50;
		}if (climatizador==true) {
			peso_total=peso_total+20;
		}
		return "el peso del coche es "+peso_total;
	}
	
	//metodo getter que me devuelve el precio
	//no tomo una variable de clase y cambio su valor, por eso es un getter
	public int precio_coche() {
		int precio_final=10000;
		if(asientos_cuero==true) {
			precio_final+=2000;
		}if (climatizador==true) {
			precio_final+=1500;
		}
		return precio_final;
	}
	

}
