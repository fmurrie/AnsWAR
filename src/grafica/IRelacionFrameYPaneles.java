package grafica;

import java.awt.Component;

import javax.swing.JPanel;

public interface IRelacionFrameYPaneles
{
	public abstract void desplazarAotroPanel(SuperPanel contentPane, String panelAmostrar);

	public abstract void desplazarAotroPanelDentroDeUnaPartida(SuperPanel contentPane, String panelAmostrar);

	public abstract int buscarPanelPorNombreYdevolverPos(SuperPanel contentPane, String nombrePanel);

	public abstract Component obtenerPanelPorNombreYdevolverPos(SuperPanel contentPane, String nombrePanel);

	public abstract void eliminarUnPanel(SuperPanel contentPane, String nombrePanel);

}
