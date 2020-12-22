package practicas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


class  LaminaDialogos extends JPanel{
	public  LaminaDialogos() {
		
		
		setLayout(new GridLayout(2,3));
		
		/*CREO CADA UNA DE LAS CAJAS CON SUS RADIOBUTTONS, LOS PAR�METROS QUE PASO AL M�TODO QUE LOS CONSTRUYE SON:
		 *NUMERO CADA UNA DE LAS CAJAS DEL CERO AL 6, 
		 *T�TULO DE CADA CAJA
		 *ARRAY CON LOS NOMBRES DE LOS RADIOBUTTONS
		 *POSICI�N POR DEFECTO DEL RADIOBUTTON SELECCIONADO*/
		
		//-------BOX TIPO------------------------------------------------------------------------------------------------
		
		String nombre_RadioTipo[] = {"Mensaje", "Confirmar", "Opci�n", "Entrada"};
		crearCaja(0, "Tipo", nombre_RadioTipo, 0);
		
		
		//-------BOX TIPO MENSAJE----------------------------------------------------------------------------------------
		
		String nombre_RadioTipoMensaje[] = {"ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"};
		crearCaja(1, "Tipo de Mensaje", nombre_RadioTipoMensaje, 0);
		
		
		//-------BOX MENSAJE----------------------------------------------------------------------------------------------
		
		String nombre_RadioMensaje[] = {"Cadena", "Icono", "Componente", "Otros", "Object[]"};
		
		crearCaja(2, "Message", nombre_RadioMensaje, 0);
		
		//-------BOX CONFIRMAR----------------------------------------------------------------------------------------------
		
		String nombre_RadioConfirmar[] = {"DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"};
		
		crearCaja(3, "Confirmar", nombre_RadioConfirmar, 0);
		
		
		//-------BOX OPCI�N----------------------------------------------------------------------------------------------
		
		String nombre_RadioOpcion[] = {"String[]", "Icon[]", "Object[]"};
				
		crearCaja(4, "Opci�n", nombre_RadioOpcion, 0);
				
		//-------BOX OPCI�N----------------------------------------------------------------------------------------------
				
		String nombre_RadioEntrada[] = {"Campo de texto", "Combo"};
				
		crearCaja(5, "Entrada", nombre_RadioEntrada, 0);
		
		//-------------------------------------------
		

	}
	


	private void crearCaja(final int numeroGrupo, final String nombreCaja, String[] nombreRadio, int posDefault) {
		
		//CREO UNA CAJA CON ELEMENTOS EN VERTICAL Y LE A�ADO BORDE Y T�TULO CON EL PAR�METRO NombreCaja
		
		Box cajaRadios = Box.createVerticalBox();
		
		
		//cajaRadios.setBorder(new TitledBorder(nombreCaja));
		
		cajaRadios.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), nombreCaja));
		
		/*CREO UN RADIOGROUP PARA AGRUPAR TODOS LOS RADIOBUTTONS DE CADA CAJA, ESTE RADIOGROUP PERTENECE A UN ARRAY DE RADIOGROUPS
		Y CON EL PAR�METRO numeroGrupo, TRABAJO CON ELLOS INDIVIDUALMENTE*/
		
		gruposRadios[numeroGrupo] = new ButtonGroup();
		
		/*BUCLE EN EL QUE VOY A�ADIENDO RADIOBUTTONS AL RADIOGROUP, TAMBI�N PONGO A CADA RADIOBUTTON A LA ESCUCHA, HACIENDO
		*QUE EL RADIOGROUP CAMBIE SU ESTADO CADA VEZ QUE SE PINCHA UN RADIOGROUP DIFERENTE. EL ESTADO DEL RADIOGROUP ES
		*EL NOMBRE DEL PROPIO RADIOBUTTON*/
		
		
		//UNA VEZ TERMINADO DE A�ADIR TODOS LOS RADIOBUTTON AL RADIOGROUP, TAMBI�N LOS A�ADO A LA CAJA PARA QUE SEAN VISIBLES.
		
		
		int i=0;
		
		for (String elemArray : nombreRadio) {
			
			/*LA VARIABLE CONTADOR i SOLO EST� PARA AVERIGUAR CUAL ES LA POSICI�N POR DEFECTO DEL RADIOBUTTON SELECCIONADO, EN CASO DE QUE i SEA IGUAL
			 *a la variable posDefault ese radiobutton se crear� seleccionado.*/
			
			radio = new JRadioButton(elemArray, posDefault==i);
			radio.setActionCommand(elemArray);
			
			/*PONGO A LA ESCUCHA A LOS RADIOBUTTONS Y CADA VEZ QUE SE PULSE UNO MODIFICAR� EL ACTIONCOMMAND DEL RADIOBUTTON AL QUE PERTENECE ASIGN�NDOLE
			 * EL NOMBRE DEL RADIOBUTTON PULSADO. */
			
			radio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					gruposRadios[numeroGrupo].getSelection().setActionCommand(e.getActionCommand());
		
				}
			});
			
			gruposRadios[numeroGrupo].add(radio);
			
			i++;

			cajaRadios.add(radio);
			
			super.add(cajaRadios);

		}
			
		
	}
	
	
	// M�TODO GETTER QUE DEVUELVE EL ARRAY DE RADIOGROUPS DE LA L�MINA SUPERIOR, EL CUAL CONTIENE EL VALOR DEL RADIOBUTTON PULSADO EN EL ACTIONCOMAND
	
	public ButtonGroup[] getGruposRadios(){
		
		return gruposRadios;
	}
	
	private JRadioButton radio;
	private static ButtonGroup gruposRadios[] = new ButtonGroup[6];
	
}