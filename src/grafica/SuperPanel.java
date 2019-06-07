package grafica;

import java.awt.Component;
import javax.swing.JPanel;

public abstract class SuperPanel extends JPanel
{

	protected void desplazarAotroPanel(JPanel contentPane, String panelAmostrar)
	{
		boolean busqueda = false;
		Component auxiliar = new JPanel();
		Component auxiliar2=contentPane.getComponent(0);
		int i = 0;
		while(busqueda == false)
		{
			auxiliar = contentPane.getComponent(i);
			if(panelAmostrar.equalsIgnoreCase(auxiliar.getName()))
			{
				contentPane.add(auxiliar,0);
				contentPane.add(auxiliar2,i);
				busqueda=true;
			}
				
			i++;
		}
	}
	

}
