package poo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;


public class PruebaTemporizador {

	public static void main(String[] args) {
		//creo el objeto de la clase que cree que implementa la interface ActionListener
		DameLaHora oyente=new DameLaHora();
		
		//constructor de la clase Timer, uso el objeto creado
		Timer miTemporizador= new Timer(5000,oyente);
		
		//prendo el temporizador
		miTemporizador.start();
		
		//tengo que procurar que el programa permanezca en ejecucion para verlo
		//saco una ventana JOptionPane asi el programa sigue en ejecucion hasta detenerlo
		JOptionPane.showMessageDialog(null, "Acepta para detener");
		System.exit(0);
		
	}

}

//crear la clase que implemente la interface actionlistener

class DameLaHora implements ActionListener{
	
	//implemento el metodo que la interface me obliga a hacer

	@Override
	public void actionPerformed(ActionEvent e) {
		Date ahora=new Date();
		System.out.println("te pongo la hora cada 5 segundos "+ ahora);
		Toolkit.getDefaultToolkit().beep();
		
	}
	
	//cada vez que imprime la hora saque un sonido
	//clase toolkit puente entre los recursos de nuestro SO y Java
	
	
}