package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import personas.Jugador;
import personas.JugadorPermanente;

/**
 * Panel grafico en el cual el administrador puede modificar datos de los
 * jugadores
 */
public class PanelEditarJugadoresAdm extends SuperPanel
{
	private JugadorPermanente jugadorInterferido = new JugadorPermanente();
	private JTextField nicknameField = new JTextField();
	private JTextField puntajeField = new JTextField();
	private JTextField partidasJugadasField = new JTextField();
	private JTextField preguntasAcertadasField = new JTextField();

	/**
	 * Create the panel.
	 */
	public PanelEditarJugadoresAdm(SuperPanel contentPane)
	{
		setLayout(new GridLayout(6,1,0,0));
		setBackground(Color.BLACK);

		JLabel lblNickname = new JLabel("     Nickname:");
		lblNickname.setBackground(Color.BLACK);
		lblNickname.setForeground(Color.WHITE);
		lblNickname.setHorizontalAlignment(SwingConstants.LEFT);
		lblNickname.setFont(new Font("Stencil",Font.PLAIN,18));
		lblNickname.setOpaque(true);
		add(lblNickname);

		nicknameField.setHorizontalAlignment(SwingConstants.CENTER);
		nicknameField.setFont(new Font("Tahoma",Font.PLAIN,16));
		nicknameField.setBackground(Color.LIGHT_GRAY);
		add(nicknameField);

		JLabel lblPuntaje = new JLabel("     Puntaje:");
		lblPuntaje.setBackground(Color.BLACK);
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntaje.setFont(new Font("Stencil",Font.PLAIN,18));
		lblPuntaje.setOpaque(true);
		add(lblPuntaje);

		puntajeField.setHorizontalAlignment(SwingConstants.CENTER);
		puntajeField.setFont(new Font("Tahoma",Font.PLAIN,16));
		puntajeField.setBackground(Color.LIGHT_GRAY);
		add(puntajeField);
		puntajeField.setColumns(10);

		JLabel lblPartJugadas = new JLabel("     Partidas jugadas:");
		lblPartJugadas.setBackground(Color.BLACK);
		lblPartJugadas.setForeground(Color.WHITE);
		lblPartJugadas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPartJugadas.setFont(new Font("Stencil",Font.PLAIN,18));
		lblPartJugadas.setOpaque(true);
		add(lblPartJugadas);

		partidasJugadasField.setHorizontalAlignment(SwingConstants.CENTER);
		partidasJugadasField.setFont(new Font("Tahoma",Font.PLAIN,16));
		partidasJugadasField.setBackground(Color.LIGHT_GRAY);
		add(partidasJugadasField);
		partidasJugadasField.setColumns(10);

		JLabel lblPregAcertadas = new JLabel("     Respuestas correctas:");
		lblPregAcertadas.setBackground(Color.BLACK);
		lblPregAcertadas.setForeground(Color.WHITE);
		lblPregAcertadas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPregAcertadas.setFont(new Font("Stencil",Font.PLAIN,18));
		lblPregAcertadas.setOpaque(true);
		add(lblPregAcertadas);

		preguntasAcertadasField.setHorizontalAlignment(SwingConstants.CENTER);
		preguntasAcertadasField.setFont(new Font("Tahoma",Font.PLAIN,16));
		preguntasAcertadasField.setBackground(Color.LIGHT_GRAY);
		add(preguntasAcertadasField);

		actualizarTextFieldConJugadorInterferido();
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int respuesta = JOptionPane.showConfirmDialog(null,
						"�Realmente desea modificar los datos del jugador?","Modificar jugador",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(respuesta == 0)
				{
					modificarCuenta(contentPane);
					desplazarAotroPanel(contentPane,"panelInspeccionarJugadores");
				}
			}
		});

		JLabel label = new JLabel("");
		add(label);
		btnModificar.setForeground(Color.GREEN);
		btnModificar.setFont(new Font("Stencil",Font.PLAIN,18));
		btnModificar.setBackground(Color.BLACK);
		add(btnModificar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelInspeccionarJugadores");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int respuesta = JOptionPane.showConfirmDialog(null,"�Realmente desea eliminar al jugador?",
						"Eliminar jugador",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(respuesta == 0)
				{
					contentPane.getData().eliminarJugadorDeLaLista("jugadores.dat",jugadorInterferido);
					desplazarAotroPanel(contentPane,"panelInspeccionarJugadores");
				}
			}
		});
		btnEliminar.setForeground(Color.RED);
		btnEliminar.setFont(new Font("Stencil",Font.PLAIN,18));
		btnEliminar.setBackground(Color.BLACK);
		add(btnEliminar);

	}

	// Metodos varios:

	public void setJugadorInterferidoYactualizarTextFields(JugadorPermanente jugadorInterferido)
	{
		this.jugadorInterferido = jugadorInterferido;
		actualizarTextFieldConJugadorInterferido();
	}

	public JugadorPermanente getJugadorInterferido()
	{
		return jugadorInterferido;
	}

	private void modificarCuenta(SuperPanel contentPane)
	{
		JugadorPermanente aux = this.jugadorInterferido;
		String auxId = aux.getId();
		String auxUsuario = aux.getUsuario();
		String auxDni = aux.getDni();
		String auxClave = aux.getClave();
		String auxCorreo = aux.getCorreo();
		String auxNickname = aux.getNickname();
		long auxPuntaje = aux.getPuntaje();
		int auxNumPartidasjugadas = aux.getNumPartidasJugadas();
		int auxNumPreguntasAcertadas = aux.getNumPreguntasAcertadas();
		JugadorPermanente aux2 = null;

		if((!(nicknameField.getText().equals(""))
				&& (!(puntajeField.getText().equals("")) && (!(partidasJugadasField.getText().equals("")))
						&& (!(preguntasAcertadasField.getText().equals(""))))))
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,auxClave,auxDni,auxCorreo,nicknameField.getText(),
					Long.parseLong(puntajeField.getText()),Integer.parseInt(partidasJugadasField.getText()),
					Integer.parseInt(preguntasAcertadasField.getText()));
		}

		// Se reemplaza la cuenta modificada por la original
		if(aux2 != null)
		{
			aux2.setPuntaje(Long.parseLong(puntajeField.getText()));
			contentPane.getData().modificarCuenta("jugadores.dat",aux,aux2);
		}

	}

	public void actualizarTextFieldConJugadorInterferido()
	{
		nicknameField.setText(jugadorInterferido.getNickname());
		puntajeField.setText(Long.toString(jugadorInterferido.getPuntaje()));
		partidasJugadasField.setText(Integer.toString(jugadorInterferido.getNumPartidasJugadas()));
		preguntasAcertadasField.setText(Integer.toString(jugadorInterferido.getNumPreguntasAcertadas()));
	}

}
