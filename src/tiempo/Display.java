package tiempo;

import javax.swing.JTextField;

/**
 * Clase que maneja el paso del tiempo.
 */
public class Display
{
	public void printTime(int hour, int minute, int second, JTextField componente)
	{
		StringBuilder fullHour = new StringBuilder();

		fullHour.append((hour > 9) ? ":" + hour : "0" + hour);
		fullHour.append((minute > 9) ? ":" + minute : ":0" + minute);
		fullHour.append((second > 9) ? ":" + second : ":0" + second);

		componente.setText("Tiempo: " + fullHour);
	}
}
