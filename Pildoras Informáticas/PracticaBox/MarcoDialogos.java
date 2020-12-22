package practicas;

import java.awt.*;

import javax.swing.*;

class MarcoDialogos extends JFrame{
	
	public MarcoDialogos() {
		
		setTitle("Prueba de di�logos");
		setBounds(300, 300, 800, 600);
		setLayout(new BorderLayout());
		
		//L�MINA SUPERIOR QUE CONTENDR� LAS SEIS BOX CON SUS RADIOBUTTONS
		
		LaminaDialogos laminaSuperior = new LaminaDialogos();
		add(laminaSuperior, BorderLayout.CENTER);
		
		//L�MINA INFERIOR QUE CONTIENE EL BOT�N QUE GENERA LA VENTANA EMERGENTE
		
		LaminaBotonMostrar laminaBoton = new LaminaBotonMostrar();
		add(laminaBoton, BorderLayout.SOUTH);
		
		setVisible(true);
		
		
	}
	
}
