package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Panel grafico donde el admnistrador puede ver y eliminar a los jugadores.
 */
public class PanelMenuADMjugadores extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelMenuADMjugadores(SuperPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JButton btnVerRank = new JButton("Inspeccionar jugadores");
		btnVerRank.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelInspeccionarJugadores");
			}
		});
		btnVerRank.setBackground(Color.BLACK);
		btnVerRank.setForeground(Color.GREEN);
		btnVerRank.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVerRank);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelMenuAdministracion");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

	}

}
