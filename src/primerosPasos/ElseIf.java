package primerosPasos;

import java.util.Scanner;

public class ElseIf {
    public static void main(String[] args) {
        //creamos un objeto scanner usando el constructor para entrar datos
        Scanner entrada=new Scanner(System.in);
       
        System.out.println("introduce tu edad ");

        //almacenamos en una variable la edad que el usuario introduzca 
            //edad = entrada(consola) siguiente entero
        int edad=entrada.nextInt();

        if(edad<18){
            System.out.println("adolescente");
        }
        else if(edad<40){
            System.out.println("joven");
        }
        else if(edad<65){
            System.out.println("madurito");
        }
        else{
            System.out.println("cuidate");
        }


        entrada.close();
    }
}
