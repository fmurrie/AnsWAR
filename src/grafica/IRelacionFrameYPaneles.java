package grafica;

import javax.swing.JPanel;

public interface IRelacionFrameYPaneles
{
	public abstract void desplazarAotroPanel(JPanel contentPane, String panelAmostrar);
	public abstract void restaurarValoresRuleta(JPanel contentPane);
	public abstract int buscarPanelPorNombreYdevolverPos(JPanel contentPane,String nombrePanel);

}
