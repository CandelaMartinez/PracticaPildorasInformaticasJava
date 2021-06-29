package graficos;

import javax.swing.*;

public class C109MarcoEmergente {
	//al hacer click con el boton derecho sobre la lamina salga un menu emergente

	public static void main(String[] args) {
		MarcoEmergenteM mimarco= new MarcoEmergenteM();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoEmergenteM extends JFrame{
	public MarcoEmergenteM () {
		setBounds (100,100,300,250);
		setVisible(true);
		LaminaEmergenteM milamina= new LaminaEmergenteM();
		add(milamina);
		
	}
}

class LaminaEmergenteM extends JPanel{
	public LaminaEmergenteM() {
		
		
		
		//instancio la clase del menu emergente
		JPopupMenu emergente= new JPopupMenu();
		
		//creo los items que tendra el menu emergente y los agrego al emergente
		JMenuItem opcion1= new JMenuItem("Opcion 1");
		emergente.add(opcion1);
		
		JMenuItem opcion2= new JMenuItem("Opcion 2");
		emergente.add(opcion2);
		
		JMenuItem opcion3= new JMenuItem("Opcion 3");
		emergente.add(opcion3);
		
		//especifica sobre que elemento tengo que hacer click para que salga
		//estoy en la lamina 
		setComponentPopupMenu(emergente);
		
		//si quiero que se aplique a otro elemento:
		//nombreDeInstancia de elemento.setComponentPopupMenu(Component)
	}
}