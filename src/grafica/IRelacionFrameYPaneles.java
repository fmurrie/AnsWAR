package grafica;

import javax.swing.JPanel;

public interface IRelacionFrameYPaneles
{
	public abstract void desplazarAotroPanel(SuperPanel contentPane, String panelAmostrar);

	public abstract int buscarPanelPorNombreYdevolverPos(SuperPanel contentPane, String nombrePanel);
	

}
