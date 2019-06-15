package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import personas.Jugador;
import personas.JugadorPermanente;

public class PanelEditarJugadoresAdm extends SuperPanel
{
	private JTextField nicknameField = new JTextField();
	private JTextField puntajeField = new JTextField();
	private JTextField partidasJugadasField = new JTextField();
	private JTextField preguntasAcertadasField = new JTextField();

	/**
	 * Create the panel.
	 */
	public PanelEditarJugadoresAdm(SuperPanel contentPane,JugadorPermanente jugadorAeditar)
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

		nicknameField.setText(jugadorAeditar.getNickname());
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

		puntajeField.setText(Long.toString(jugadorAeditar.getPuntaje()));
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

		partidasJugadasField.setText(Integer.toString(jugadorAeditar.getNumPartidasJugadas()));
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

		preguntasAcertadasField.setText(Integer.toString(jugadorAeditar.getNumPreguntasAcertadas()));
		preguntasAcertadasField.setHorizontalAlignment(SwingConstants.CENTER);
		preguntasAcertadasField.setFont(new Font("Tahoma",Font.PLAIN,16));
		preguntasAcertadasField.setBackground(Color.LIGHT_GRAY);
		add(preguntasAcertadasField);



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

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				modificarCuenta(contentPane,jugadorAeditar);
			}
		});
		btnModificar.setForeground(Color.GREEN);
		btnModificar.setFont(new Font("Stencil",Font.PLAIN,18));
		btnModificar.setBackground(Color.BLACK);
		add(btnModificar);

	}

	// Metodos varios:

	private void modificarCuenta(SuperPanel contentPane,JugadorPermanente jugadorAeditar)
	{
		JugadorPermanente aux = jugadorAeditar;
		String auxId = aux.getId();
		String auxUsuario = aux.getUsuario();
		String auxDni = aux.getDni();
		String auxClave = aux.getClave();
		String auxCorreo = aux.getCorreo();
		String auxNickname = aux.getNickname();
		long auxPuntaje=aux.getPuntaje();
		int auxNumPartidasjugadas=aux.getNumPartidasJugadas();
		int auxNumPreguntasAcertadas=aux.getNumPreguntasAcertadas();
		JugadorPermanente aux2 = null;

		if((!(nicknameField.getText().equals("")) && (!(puntajeField.getText().equals("")) && (!(partidasJugadasField.getText().equals("")))&& (!(preguntasAcertadasField.getText().equals(""))))))
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,auxClave,auxDni,auxCorreo,nicknameField.getText(),Long.parseLong(puntajeField.getText()),Integer.parseInt(partidasJugadasField.getText()),Integer.parseInt(preguntasAcertadasField.getText()));
		}
		
		// Se reemplaza la cuenta modificada por la original
		if(aux2 != null)
		{
			contentPane.getData().modificarCuenta("jugadores.dat",aux,aux2);

		}

	}

}
