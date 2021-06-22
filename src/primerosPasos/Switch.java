package primerosPasos;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Switch {
	 public static void main(String[] args) {
	        //averiguar el area de un figuras geometricas (cuadrado rectangula triangulo circulo)

	        //consola:usuario elige la figura geometrica de la que quiere hayar el area
	        //JOptionpane: el usuario introduce los datos del calculo
	        //imprimo las opciones que le doy al usuario
		 
	        //nextInt no es estatico: creo un objeto scanner para que el usuario introduzca por consola. 
	        //llamo al constructor scanner y le paso el parametro de consola
	        Scanner entrada=new Scanner(System.in);

	        //  \n salto de linea dentro de un string
	        System.out.println("Elige una opcion:  \n1: Cuadrado \n2: rectangulo \n3:triangulo \n4 circulo");

	        //almacenamos en la variable figura el proximo entero que el usuario  escriba por consola
	        int figura=entrada.nextInt();

	        //evaluamos lo que el usuario introdujo
	        //area cuadrado: lado*lado 
	        //area rectangulo: base * altura
	        //area triangulo: base*altura/2
	        //area circulo: PI * (radio*radio)
	        
	        
	        //guardamos en lado lo que el usuario introduzca en una ventana JOptionPane
	        //show input dialago devuelve un string. 
	        //convertir string(que devuelve el metodo showInputDialog) a int asi lo podemos calcular. parseInt
	        //parseInt es estatico. poner el nombre de la clase a la que pertenece.metodo(parametro)
	        switch(figura){
	            case 1: 
	                int lado=Integer.parseInt(JOptionPane.showInputDialog("introduce el lado: "));
	                //metodo pow. estatico. devuelve double. 2 parametros(base exponente)
	                System.out.println("el area del cuadrado es "+ Math.pow(lado, 2) );
	                break;
	                //pasame a entero lo que el usuario escriba en el cuadro te texto
	            case 2:
	                int base=Integer.parseInt(JOptionPane.showInputDialog("introduce la base"));
	                int altura=Integer.parseInt(JOptionPane.showInputDialog("introduce la altura"));
	                System.out.println("el area del rectangulo es " + base*altura);
	                break;

	            case 3:
	                //reuso las variables anteriores
	                base=Integer.parseInt(JOptionPane.showInputDialog("introduce la base"));
	                altura=Integer.parseInt(JOptionPane.showInputDialog("introduce la altura"));
	                System.out.println("el area del triangulo es " + (base*altura)/2);
	                break;

	            case 4:
	            int radio=Integer.parseInt(JOptionPane.showInputDialog("introduce el radio"));
	            System.out.print("el area del circulo es ");
	            //imprimo con formato asi el rtado me da solo con 2 decimales
	            //PI constante predefinida de clase, pow al cuadrado de variable radio
	            System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
	            break;

	            default:
	            System.out.println("opcion incorrecta");
	        }
	    entrada.close();

	    }
}
