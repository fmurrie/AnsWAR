package grafica;

import javax.swing.JPanel;

import tiempo.Temporizador;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PanelPartida extends SuperPanel
{
	private JPanel contenidoPartida = new JPanel();
	private Temporizador reloj = new Temporizador();
	private PanelParaResponder panelParaResponder = new PanelParaResponder(contenidoPartida);
	private PanelRuleta panelRuleta = new PanelRuleta(contenidoPartida);

	/**
	 * Create the panel.
	 */
	public PanelPartida(JPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
		add(label);

		JButton btnIniciarPartida = new JButton("Iniciar partida");
		btnIniciarPartida.setForeground(Color.GREEN);
		btnIniciarPartida.setBackground(Color.BLACK);
		btnIniciarPartida.setFont(new Font("Stencil",Font.PLAIN,18));
		btnIniciarPartida.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				removeAll();
				panelRuleta.setName("panelRuleta");
				panelParaResponder.setName("panelParaResponder");
				contenidoPartida.add(panelRuleta);
				contenidoPartida.add(panelParaResponder);
				contenidoPartida.setBackground(Color.BLACK);
				add(contenidoPartida);
				revalidate();
				repaint();

			}
		});
		add(btnIniciarPartida);

		JButton btnAbandonarPartida = new JButton("Abandonar partida");
		btnAbandonarPartida.setBackground(Color.BLACK);
		btnAbandonarPartida.setFont(new Font("Stencil",Font.PLAIN,18));
		btnAbandonarPartida.setForeground(Color.RED);
		btnAbandonarPartida.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelMenuJugador");
			}
		});
		add(btnAbandonarPartida);

	}

}
