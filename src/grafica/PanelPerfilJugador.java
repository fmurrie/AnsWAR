package grafica;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import personas.Jugador;
import personas.JugadorPermanente;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * Panel grafico donde el jugador puede ver los datos de su perfil.
 */
public class PanelPerfilJugador extends SuperPanel
{
	private JTextField txtFieldNickName;
	private JTextField txtFieldPuntaje;
	private JTextField txtFieldPreguntasAcertadas;
	private JTextField txtFieldPartidasJugadas;

	/**
	 * Create the panel.
	 */
	public PanelPerfilJugador(SuperPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);

		JLabel lblMiPerfil = new JLabel("Mi perfil");
		lblMiPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiPerfil.setBackground(Color.BLACK);
		lblMiPerfil.setForeground(Color.WHITE);
		lblMiPerfil.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblMiPerfil);

		txtFieldNickName = new JTextField();
		txtFieldNickName.setBackground(Color.GRAY);
		txtFieldNickName.setFont(new Font("Stencil",Font.PLAIN,16));
		txtFieldNickName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldNickName.setEditable(false);
		add(txtFieldNickName);
		txtFieldNickName.setColumns(10);

		txtFieldPuntaje = new JTextField();
		txtFieldPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldPuntaje.setFont(new Font("Stencil",Font.PLAIN,16));
		txtFieldPuntaje.setBackground(Color.GRAY);
		txtFieldPuntaje.setEditable(false);
		add(txtFieldPuntaje);
		txtFieldPuntaje.setColumns(10);

		txtFieldPreguntasAcertadas = new JTextField();
		txtFieldPreguntasAcertadas.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldPreguntasAcertadas.setFont(new Font("Stencil",Font.PLAIN,16));
		txtFieldPreguntasAcertadas.setBackground(Color.GRAY);
		txtFieldPreguntasAcertadas.setEditable(false);
		add(txtFieldPreguntasAcertadas);
		txtFieldPreguntasAcertadas.setColumns(10);

		txtFieldPartidasJugadas = new JTextField();
		txtFieldPartidasJugadas.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldPartidasJugadas.setBackground(Color.GRAY);
		txtFieldPartidasJugadas.setFont(new Font("Stencil",Font.PLAIN,16));
		txtFieldPartidasJugadas.setEditable(false);
		add(txtFieldPartidasJugadas);
		txtFieldPartidasJugadas.setColumns(10);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelMenuJugador");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

	}

	public void actualizarTextoTextFields(SuperPanel contentPane)
	{
		Jugador aux = (Jugador) contentPane.getCuentaActiva();
		String auxNickname = aux.getNickname();
		String auxPuntaje = Long.toString(aux.getPuntaje());
		String auxPreguntasAcertadas = Integer.toString(aux.getNumPreguntasAcertadas());
		String auxPartidasJugadas = Integer.toString(aux.getNumPartidasJugadas());

		this.txtFieldNickName.setText("Nickname: " + auxNickname);
		this.txtFieldPuntaje.setText("Puntaje: " + auxPuntaje);
		this.txtFieldPreguntasAcertadas.setText("Preguntas acertadas: " + auxPreguntasAcertadas);
		this.txtFieldPartidasJugadas.setText("Partidas jugadas: " + auxPartidasJugadas);
	}
}
