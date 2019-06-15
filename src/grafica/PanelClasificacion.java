package grafica;

import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import personas.Admin;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelClasificacion extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelClasificacion(SuperPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,4,0,0));

		JLabel lblClasificarPor = new JLabel("Clasificar por:");
		lblClasificarPor.setForeground(Color.WHITE);
		lblClasificarPor.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblClasificarPor);
		ButtonGroup grupoRdionBotomns = new ButtonGroup();
		JRadioButtonMenuItem btnPuntaje = new JRadioButtonMenuItem("Puntaje");
		btnPuntaje.setSelected(true);
		JRadioButtonMenuItem btnPreguntasAcertadas = new JRadioButtonMenuItem("Preguntas acertadas");
		JRadioButtonMenuItem btnNumPartidasJugadas = new JRadioButtonMenuItem("Numero de partidas jugadas");
		grupoRdionBotomns.add(btnPuntaje);
		grupoRdionBotomns.add(btnPreguntasAcertadas);
		grupoRdionBotomns.add(btnNumPartidasJugadas);
		add(btnPuntaje);
		add(btnPreguntasAcertadas);
		add(btnNumPartidasJugadas);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(contentPane.getCuentaActiva() instanceof Admin)
					desplazarAotroPanel(contentPane,"PanelMenuADMjugadores");
				else
					desplazarAotroPanel(contentPane,"panelMenuJugador");
			}
		});
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

		JButton btnClasificar = new JButton("Clasificar");
		btnClasificar.setForeground(Color.GREEN);
		btnClasificar.setFont(new Font("Stencil",Font.PLAIN,18));
		btnClasificar.setBackground(Color.BLACK);
		add(btnClasificar);

		JLabel label_2 = new JLabel("");
		add(label_2);
	}

}
