package primerosPasos;

import javax.swing.JOptionPane;

public class Entrada3_formato {
public static void main(String[] args) {
        
        double x =10000.0;
        // metodo printf (imprime con formato)
        //tiene 2 parametros: el formato que le tiene que aplicar al valor numerico:"" y el valor numerico: x/3
        //"%1.2f" le da 2 decimales al rtado de esa division 
        System.out.printf("%1.2f",x/3);
        System.out.println("");

        //pido un numero por consola(ventana) y lo guardo en mun1 (string)
        //metodo showInputDialog estatico por eso uso la clase delante
        //devuelve un string almacenado en num1
        String num1=JOptionPane.showInputDialog("Introduce numero ");

        //transformo el string a double para usar metodo sqrt(raiz) que recibe como parametro un double
        //uso el metodo estatico parseDouble de la clase Double(parametro string)
        //devuelve un doble que lo almacena en num2(declaramos num2)
        double num2=Double.parseDouble(num1);

        //imprimo la raiz cuadrada de num2. metodo sqrt de la clase Math
        
        System.out.print("la raiz de " + num2 +" es" );
        
        System.out.printf("%1.2f", Math.sqrt(num2));
        //le puse formato a lo que me devuelve la raiz asi solo da 2 decimales



    }
}
