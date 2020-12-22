package practicas;

import java.awt.*;

import javax.swing.*;

class MarcoDialogos extends JFrame{
	
	public MarcoDialogos() {
		
		setTitle("Prueba de diálogos");
		setBounds(300, 300, 800, 600);
		setLayout(new BorderLayout());
		
		//LÁMINA SUPERIOR QUE CONTENDRÁ LAS SEIS BOX CON SUS RADIOBUTTONS
		
		LaminaDialogos laminaSuperior = new LaminaDialogos();
		add(laminaSuperior, BorderLayout.CENTER);
		
		//LÁMINA INFERIOR QUE CONTIENE EL BOTÓN QUE GENERA LA VENTANA EMERGENTE
		
		LaminaBotonMostrar laminaBoton = new LaminaBotonMostrar();
		add(laminaBoton, BorderLayout.SOUTH);
		
		setVisible(true);
		
		
	}
	
}
