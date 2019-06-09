package grafica;

import java.awt.Component;
import javax.swing.JPanel;

public abstract class SuperPanel extends JPanel implements IRelacionFrameYPaneles
{

	public void desplazarAotroPanel(JPanel contentPane, String panelAmostrar)
	{
		boolean busqueda = false;
		Component auxiliar = new JPanel();
		Component auxiliar2 = contentPane.getComponent(0);
		int i = 0;
		while(busqueda == false)
		{
			auxiliar = contentPane.getComponent(i);
			if(panelAmostrar.equalsIgnoreCase(auxiliar.getName()))
			{
				contentPane.add(auxiliar,0);
				contentPane.add(auxiliar2,i);
				busqueda = true;
			}

			i++;
		}
		restaurarValoresPanelPartida(contentPane);
	}

	public void restaurarValoresRuleta(JPanel contentPane)
	{
		if(contentPane.getComponent(0).getName().equalsIgnoreCase("panelRuleta"))
		{
			PanelRuleta panelRuleta = new PanelRuleta(contentPane);
			panelRuleta.setName("panelRuleta");
			contentPane.remove(0);
			contentPane.add(panelRuleta,0);
		}
	}

	public void restaurarValoresPanelParaResponder(JPanel contentPane)
	{
		if(contentPane.getComponent(0).getName().equalsIgnoreCase("panelParaResponder"))
		{
			PanelParaResponder panelParaResponder = new PanelParaResponder(contentPane);
			panelParaResponder.setName("panelParaResponder");
			contentPane.remove(0);
			contentPane.add(panelParaResponder,0);
		}
	}

	public void restaurarValoresPanelPartida(JPanel contentPane)
	{
		if(contentPane.getComponent(0).getName().equalsIgnoreCase("panelPartida"))
		{
			PanelPartida panelPartida = new PanelPartida(contentPane);
			panelPartida.setName("panelPartida");
			contentPane.remove(0);
			contentPane.add(panelPartida,0);
		}
	}

	public int buscarPanelPorNombreYdevolverPos(JPanel contentPane, String nombrePanel)
	{
		boolean encontro = false;
		int i = 0;

		while(encontro = false)
		{
			if(contentPane.getComponent(i).getName().equals(nombrePanel))
			{
				encontro = true;
			}
			i++;
		}
		return i;
	}

}
