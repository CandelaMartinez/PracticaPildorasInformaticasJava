package graficos;

import javax.swing.*;
//crear elementos de botones de radio y agruparlos 
public class C93SintaxisRadio {

	public static void main(String[] args) {
		MarcoRadioSintaxis mimarcos=new MarcoRadioSintaxis();
		mimarcos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoRadioSintaxis extends JFrame{
	public  MarcoRadioSintaxis() {
		setVisible(true);
		setBounds(550,300,500,300);
		LaminaRadioSintaxis milamina=new LaminaRadioSintaxis();
		add(milamina);
	}
}

class LaminaRadioSintaxis extends JPanel{
	public LaminaRadioSintaxis() {
		
		//creo una instancia de grupo de botones
		ButtonGroup migrupo1= new ButtonGroup();
		
		//creo botones de radio
		//parametros: texto que acompaña al boton, esta activado o no por defecto
		JRadioButton boton1=new JRadioButton("Azul",false);
		JRadioButton boton2=new JRadioButton("Rojo",true);
		JRadioButton boton3=new JRadioButton("Amarillo",false);
		
		//agrupar los 3 botones en el grupo creado
		//si no lo agrupo se pueden seleccionar todos 
		migrupo1.add(boton1);
		migrupo1.add(boton2);
		migrupo1.add(boton3);
		
		//agregar los botones a la lamina
		add(boton1);
		add(boton2);
		add(boton3);
		
		//otro grupo
		ButtonGroup migrupo2= new ButtonGroup();
		
		JRadioButton boton4=new JRadioButton("Masculino",false);
		JRadioButton boton5=new JRadioButton("Femenino",true);

		migrupo2.add(boton4);
		migrupo2.add(boton5);
		
		add(boton4);
		add(boton5);
		
		
		
	}
}