package graficos;

import javax.swing.*;

public class C116DisposicionMuelle {

	//lamina con 3 botones en disposicion en muelle
	public static void main(String[] args) {
		MarcoMuelle mimarco= new MarcoMuelle();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoMuelle extends JFrame{
	public MarcoMuelle() {
		setBounds(300,400,1000,350);
		LaminaMuelle milamina= new LaminaMuelle();
		add(milamina);
		setVisible(true);
		
		
	}
}

class LaminaMuelle extends JPanel{
	
	
	public LaminaMuelle() {
		
		//botones
		JButton boton1= new JButton("boton1");
		JButton boton2= new JButton("boton2");
		JButton boton3= new JButton("boton3");
		
		
		//........................................................................
		//disposicion en muelle
		SpringLayout milayout = new SpringLayout();
		
		setLayout(milayout);
		
		
		//........................................................................
		//agrego botones a la lamina
		add(boton1);
		add(boton2);
		add(boton3);
		
		//........................................................................
		//creo un muelle
		//construir el muelle con la clase Spring para colocarlo entre los elementos
		//el constructor sin parametros no sirve xk construye un muelle fijo
		//minimo, preferido, maximo
				
		Spring mimuelle =Spring.constant(0, 10, 100);
		
		//colocar el muelle entre los elementos
		//metodo de la clase SpringLayout: put constraint(comienzo,componnente, muelle, destino, 2 componente )
		//tengo que usar la instancia de SprintLoyout para usarlo
		//tiene que ir de ... hasta... (derecha a izquierda)
		
		milayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
				
		milayout.putConstraint(SpringLayout.WEST, boton2, mimuelle, SpringLayout.EAST, boton1);
		
		milayout.putConstraint(SpringLayout.WEST, boton3, mimuelle, SpringLayout.EAST, boton2);
		
		milayout.putConstraint(SpringLayout.EAST, this, mimuelle, SpringLayout.EAST, boton3);
		
		
	}
	
}