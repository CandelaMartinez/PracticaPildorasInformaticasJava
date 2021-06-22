package poo;
//HERENCIA: los nietos tienen los metodos y variables de los abuelos, padres y propios
//java no admite la herencia multiple, solo se puede heredar de una clase
//regla para determinar la herencia de las clases: 
//APLICAR EL TERMINO "ES UN..." A NUESTRO DISEÑO DE CLASE respuesta siempre
// la (subclase) es una (clase)? una furgoneta es un coche?
//correcto: clase vehiculo con subclases coche, furgoneta, camion, moto


//furgoneta hereda de coche. 
//coche es superclase(clase padre) y furgoneta subclase(clase hijo)
//agregarle las caracteristicas propias
public class Furgoneta extends Coche {
	
	private int capacidad_carga;
	private int plazas_extra;
	
	//creo el constructor llamando al constructor del padre y agregandole mas caracteristicas
	public Furgoneta(int plazas_extra, int capacidad_carga) {
		super(); //llama al constructor de la clase padre
		
		this.capacidad_carga=capacidad_carga;//this.variable de clase
		
		this.plazas_extra=plazas_extra;
	}
	
	public String dimeDatosFurgoneta() {
		return "la capacidad de carga es "+capacidad_carga+" y las plazas son "+plazas_extra;
	}
	
	
}
