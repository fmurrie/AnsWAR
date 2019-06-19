package grafica;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import disciplinas.Pregunta;
import personas.JugadorPermanente;

public class PanelEditarPreguntas extends SuperPanel
{
	private Pregunta preguntaInterferida = new Pregunta();
	private JTextField enunciadoField = new JTextField();
	private JTextField opcionAField = new JTextField();
	private JTextField opcionBField = new JTextField();
	private JTextField opcionCField = new JTextField();
	private JTextField opcionDField = new JTextField();

	/**
	 * Create the panel.
	 */
	public PanelEditarPreguntas()
	{
		setLayout(new GridLayout(1,0,0,0));

	}

}
