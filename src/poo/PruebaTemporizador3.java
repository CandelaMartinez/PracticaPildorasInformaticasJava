package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador3 {

	public static void main(String[] args) {

		//invoco al constructor por defecto, sin parametros
		Reloj2 mireloj = new Reloj2();

		mireloj.enMarcha(2000,true);

		JOptionPane.showMessageDialog(null, "Acepta para terminar");
		System.exit(0);

	}

}

class Reloj2 {


	//las que antes eran variables de clase puedo declararlas como parametos del metodo
	//cuando tengo una clase interna que va a acceder a una variable local que pertenece al metodo,
	//esta variable local debe ser final, la clase interna DameLaHora2 no accede a intervalo
	//solo accede a sonido
	public void enMarcha(int intervalo,final boolean sonido) {
		//pongo la clase interna dentro del metodo ya que solo le necesito instanciar una vez
		//sin modificador de acceso

		class DameLaHora2 implements ActionListener {

			public void actionPerformed(ActionEvent evento) {

				Date ahora = new Date();
				System.out.println("te pongo la hora cada 2 seg " + ahora);

				if (sonido) {
					Toolkit.getDefaultToolkit().beep();
				}

			}

		}
		ActionListener oyente = new DameLaHora2();
		Timer mitempo = new Timer(intervalo, oyente);
		mitempo.start();
	}

	

}
