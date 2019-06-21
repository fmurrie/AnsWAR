package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Panel grafico donde el administrador elige entre administrar enunciados o
 * administrar jugadores.
 */
public class PanelMenuAdministracion extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelMenuAdministracion(SuperPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JButton btnADMPreguntas = new JButton("Administrar enunciados");
		btnADMPreguntas.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelMenuADMenunciados");
			}
		});
		btnADMPreguntas.setBackground(Color.BLACK);
		btnADMPreguntas.setForeground(Color.WHITE);
		btnADMPreguntas.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnADMPreguntas);

		JButton btnADMJugadores = new JButton("Administrar jugadores");
		btnADMJugadores.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelMenuADMjugadores");
			}
		});
		btnADMJugadores.setForeground(Color.WHITE);
		btnADMJugadores.setFont(new Font("Stencil",Font.PLAIN,18));
		btnADMJugadores.setBackground(Color.BLACK);
		add(btnADMJugadores);

	}

}
