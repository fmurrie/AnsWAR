package grafica;

import javax.swing.JTextField;

/**
 * Proceso para actualizar los textFile del panel partida
 */
public class ActualizadorPartida extends Thread
{
	private JTextField textFieldPuntaje;
	private JTextField txtPreguntasAcertadas;
	private SuperPanel obj;
	private JTextField textFieldTiempo;

	public ActualizadorPartida(JTextField textFieldPuntaje,JTextField txtPreguntasAcertadas,SuperPanel obj,
			JTextField textFieldTiempo)
	{
		this.textFieldPuntaje = textFieldPuntaje;
		this.txtPreguntasAcertadas = txtPreguntasAcertadas;
		this.obj = obj;
		this.textFieldTiempo = textFieldTiempo;
	}

	public void run()
	{
		while(textFieldTiempo.getText().equalsIgnoreCase("00:00:00") == false)
		{
			textFieldPuntaje.setText("Puntaje: " + ((ContenidoPartida) obj).getPuntosDePartida());
			txtPreguntasAcertadas
					.setText("Preguntas acertadas: " + ((ContenidoPartida) obj).getPreguntasAcertadasDePartida());
		}

	}

}
