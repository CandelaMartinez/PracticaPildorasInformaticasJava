package poo;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		//creo la instancia de la clase reloj
		Reloj mireloj=new Reloj(2000,true);
		//ponga en funcionamiento el reloj
		mireloj.enMarcha();
		//para que la ejecucion del programa no termine
		JOptionPane.showMessageDialog(null,"Acepta para terminar");
		System.exit(0);

	}

}

class Reloj{
	//contructor
	public Reloj(int intervalo,boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
		}
	
	//metodo poner en marcha el temporizador
	public void enMarcha() {
		ActionListener oyente=new DameLaHora2();
		Timer mitempo=new Timer(intervalo,oyente);
		mitempo.start();
	}
	
	
	
	
	
	//campos encapsulados
	private int intervalo;
	private boolean sonido;
	
	
	
	//clase interna, solo las clases internas pueden tener el modificador private
	//las demas clases solo pueden tener public o por defecto
	private class DameLaHora2 implements ActionListener{
		
		public void actionPerformed(ActionEvent evento) {
			
			Date ahora=new Date();
			System.out.println("te pongo la hora cada 2 seg "+ ahora);
			
			if (sonido) {
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
		
		
	}
}


