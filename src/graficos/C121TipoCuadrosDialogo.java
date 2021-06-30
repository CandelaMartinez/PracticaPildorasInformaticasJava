package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//cada boton me abre una ventana de dialogo diferente

public class C121TipoCuadrosDialogo {

	public static void main(String[] args) {
		CuadrosDialogo mimarco= new CuadrosDialogo();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class CuadrosDialogo extends JFrame{
	public CuadrosDialogo() {
		setBounds(500,300,400,250);
		setVisible(true);
		LaminaCuadrosDialogo milamina= new LaminaCuadrosDialogo();
		add(milamina);
	}
}

class LaminaCuadrosDialogo extends JPanel{
	
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	
	public LaminaCuadrosDialogo() {
		
		boton1 =new JButton("boton1");
		boton2 =new JButton("boton2");
		boton3 =new JButton("boton3");
		boton4 =new JButton("boton4");
		
		
		boton1.addActionListener(new AccionBotones());
		boton2.addActionListener(new AccionBotones());
		boton3.addActionListener(new AccionBotones());
		boton4.addActionListener(new AccionBotones());
		
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
	}
	
	private class AccionBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==boton1) {
				
				//metodo de la clase JOptionPane (componente padre, objeto,titulo, entero(tipo de mensaje que me dara el tipo de icono: 0 1 2 3))
				//componente padre es la lamina clase en la que me encuentro
				//un String es un object
				//JOptionPane.showMessageDialog(LaminaCuadrosDialogo.this, "Mensaje de prueba");
				
				JOptionPane.showMessageDialog(LaminaCuadrosDialogo.this, "Mensaje de prueba","Advertencia",2);
				
			}else if(e.getSource()==boton2) {
				
				//cuadro de texto para que el usuario pueda escribir
				
				JOptionPane.showInputDialog(LaminaCuadrosDialogo.this,"Introduce Nombre: ","Datos personales",1);
				
			}else if(e.getSource()==boton3) {
				
				//me permite elegir que botones pongo para que pulse el usuario
				JOptionPane.showConfirmDialog(LaminaCuadrosDialogo.this, "Elige opcion","V Confirmar",1);
				
				
			}else if(e.getSource()==boton4) {
				
				//permite colocar un icono, cambiar el texto de los botones
				//(contenedor, mensaje, titulo, int tipo de botones,int de tipo de mensaje icono, icono propio,
				//array de objetos indicando posibles opciones que el usuario puede elegir,valor inicial)
				
				JOptionPane.showOptionDialog(LaminaCuadrosDialogo.this, "Elige", "V de opciones" ,1, 1, null, null,null);
			}
			
		}
		
	}
	
}