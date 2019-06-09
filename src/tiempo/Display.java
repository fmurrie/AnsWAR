package tiempo;

import javax.swing.JTextField;

public class Display
{
	public void printTime(int hour, int minute, int second,JTextField componente)
	{
		String fullHour = "";

		fullHour += (hour > 9) ? ":" + hour : "0" + hour;
		fullHour += (minute > 9) ? ":" + minute : ":0" + minute;
		fullHour += (second > 9) ? ":" + second : ":0" + second;

		//System.out.println(fullHour);
		componente.setText(fullHour);
		componente.revalidate();
		componente.repaint();
	}
}
