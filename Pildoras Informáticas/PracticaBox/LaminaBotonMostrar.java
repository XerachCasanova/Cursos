package practicas;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

//LAMINA INFERIOR, QUE CONTIENE EL BOTÓN MOSTRAR Y QUE GENERA UNA VENTANA EMERGENTE SEGÚN LOS PARÁMETROS SELECCIONADOS EN LA LÁMINA SUPERIOR

class LaminaBotonMostrar extends JPanel{
	
	LaminaBotonMostrar(){
		//CREO LOS DISTINTOS COMPONENTES QUE APARECERÁN EN LA VENTANA EMERGENTE CUANDO PINCHEMOS EN LA CAJA "MENSAJE"
		
		cadena="Mensajeeeeee";
		icono = new ImageIcon("bin/graficos/rojo.gif");
		componente = new JPanel();
		componente.setBackground(Color.YELLOW);
		fecha = new Date();
		objeto = new Object[]{ cadena,  icono, componente, fecha };
	

		//CREO EL BOTÓN MOSTRAR Y LO PONGO A LA ESCUCHA
		JButton bMostrar = new JButton("Mostrar");
		
		bMostrar.addActionListener(new ConfigVentana());
		add(bMostrar);
		
		
		
	}
	
	private class ConfigVentana implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			
			// GUARDO EN UN OBJETO ARRAY DE TIPO BUTTONGROUP EL OBJETO ARRAY DE TIPO BUTTONGROUP DE LA LÁKMINA SUPERIOR
			ButtonGroup radiosPulsados[] = oyenteLaminaDialogo.getGruposRadios();
			
		
			
			// EJECUTO EL MÉTODO CONSTRUYE VENTANA PARA CONSTRUIR LA VENTANA EMERGENTE.
			construyeVentana(radiosPulsados);
			
		}
		
		private void construyeVentana(ButtonGroup radiosPulsados[]) {
			
			//GUARDO EN UN STRING EL ACTION COMAND DEL BUTTONGROUP PRIMER BOX (VALOR 0 DEL ARRAY)
			
			String accion = radiosPulsados[0].getSelection().getActionCommand();
			
			boxTipoMensaje(radiosPulsados[1]);
			
			boxCadena(radiosPulsados[2]);
			
			
			if (accion.equals("Mensaje")) {
				
				JOptionPane.showMessageDialog(LaminaBotonMostrar.this, message, "Ventana de tipo Mensaje", tipoMensaje, null);
			
			}else if (accion.equals("Confirmar")) {
				
				boxConfirmar(radiosPulsados[3]);
				JOptionPane.showConfirmDialog(LaminaBotonMostrar.this, message, "Ventana de tipo Confirmar", confirmar, tipoMensaje, null);
				
				
			}else if (accion.equals("Opción")) {

				Object opc[] = boxOpcion(radiosPulsados[4]);
				JOptionPane.showOptionDialog(LaminaBotonMostrar.this, message, "Ventana de tipo Opciones", confirmar, tipoMensaje, null, opc, null);

			}
			 else if (accion.equals("Entrada")) {
				

				String accionEntrada = radiosPulsados[5].getSelection().getActionCommand();
				
				if (accionEntrada.equals("Campo de texto")) {
					
					JOptionPane.showInputDialog(LaminaBotonMostrar.this, message, "Ventana de tipo Entrada", tipoMensaje, null, null, null);
					
				} else {
					
					String combo[] = {"Amarillo", "Rojo", "Azul"};
					JOptionPane.showInputDialog(LaminaBotonMostrar.this, message, "Ventana de tipo Entrada", tipoMensaje, null, combo, null);
					
				}
				
				
			 }
			
		
		}

	
		private void boxConfirmar(ButtonGroup radioPulsado) {
			
			String accion = radioPulsado.getSelection().getActionCommand();
			
			if (accion.equals("DEFAULT_OPTION")) confirmar = -1;
			else if (accion.equals("YES_NO_OPTION")) confirmar = 0;
			else if (accion.equals("YES_NO_CANCEL_OPTION")) confirmar = 1;
			else if (accion.equals("OK_CANCEL_OPTION")) confirmar = 2;
			 
		}
		
		private void boxTipoMensaje(ButtonGroup radioPulsado) {
			
			String accion = radioPulsado.getSelection().getActionCommand();
			
			if (accion.equals("ERROR_MESSAGE")) tipoMensaje=0;
			else if (accion.equals("INFORMATION_MESSAGE")) tipoMensaje=1;
			else if (accion.equals("WARNING_MESSAGE")) tipoMensaje=2;
			else if (accion.equals("QUESTION_MESSAGE")) tipoMensaje=3;
			else if (accion.equals("PLAIN_MESSAGE")) tipoMensaje=-1;
			
			
		}
		
		private void boxCadena(ButtonGroup radioPulsado) {
			
			String accion = radioPulsado.getSelection().getActionCommand();
			
			
			if (accion.equals("Cadena")) message = cadena; 
			else if (accion.equals("Icono")) message = icono;
			else if (accion.equals("Componente"))message = componente;
			else if (accion.equals("Otros")) message = fecha;
			else message = objeto;
	
			
		}
		
		private Object[] boxOpcion(ButtonGroup radioPulsado) {
			
			String accion = radioPulsado.getSelection().getActionCommand();
			
			if (accion.equals("String[]")) {
				
				opcionObject = new Object[] {
						"Amarillo",
						"Azul",
						"Rojo"
				};
				
				
				return opcionObject;
				
			}else if  (accion.equals("Icon[]")) {
				
				opcionObject = new Object[] {
					new ImageIcon("bin/graficos/amarillo.gif"),
					new ImageIcon("bin/graficos/azul.gif"),
					icono //no hace falta crear el icono rojo porque ya está creado en un objeto encapsulado
				};

				return opcionObject;
				
			}else {
				
				return objeto;
				
			}
		}

	}	
	
	
	private LaminaDialogos oyenteLaminaDialogo = new LaminaDialogos(); //INSTANCIO LA LÁMINA SUPERIOR AQUÍ PARA QUE SOLO SE INSTANCIE UNA VEZ.
	
	/*la variable tipoMensaje almacena el número correspondiente al icono del tipo de mensaje de la ventana emergente , 
	la variable confirmar almacena el número correspondiente al conjunto de botones que salen en la ventana emergente.*/
	
	private int tipoMensaje, confirmar;
	
	/* message almacena el tipo de objeto al que se refiere el radiobutton pulsado en la caja "message", al poder ser distintos tipos
	 * de objetos se declara de tipo objeto */
	private Object message;
	

	private String cadena; //almacena una cadena que se ve en la ventana emergente si está seleccionado el RadioButton "cadena" en la caja "Message"
	private ImageIcon icono; //almacena un icono que se ve en la ventana emergente si está seleccionado el RadioButton "Icono" en la caja "Message"
	private JPanel componente; //almacena un layout que se ve en la ventana emergente si está seleccionado el RadioButton "Componente" en la caja "Message"
	private Date fecha; //almacena una fecha que se ve en la ventana emergente si está seleccionado el RadioButton "Otros" en la caja "Message"
	private Object[] objeto; //almacena un array de objetos que se ve en la ventana emergente si está seleccionado el RadioButton "Object[]" en la caja "Message"
	
	private Object[] opcionObject; //almacena un array de objetos que se ve en la ventana emergente si está seleccionado el RadioButton "Opción" de la caja "Tipo;
	
}