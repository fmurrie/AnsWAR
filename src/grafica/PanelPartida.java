package grafica;

import javax.swing.JPanel;

import tiempo.Temporizador;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import audio.Sonido;
import javazoom.jl.decoder.JavaLayerException;
import personas.Jugador;
import personas.JugadorInvitado;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

/**
 * Panel grafico donde el jugador puede iniciar partida.
 * 
 * @param <T>
 */
public class PanelPartida<T extends Jugador> extends SuperPanel
{
	private ContenidoPartida contenidoPartida = new ContenidoPartida();
	private JPanel panel = new JPanel();

	private ButtonGroup grupoBotonesMenuPartida = new ButtonGroup();
	JButton btnIniciarPartida = new JButton("Iniciar partida");
	JButton btnAbandonarPartida = new JButton("Abandonar partida");

	private final JLabel lblEstado = new JLabel("Estado:");
	private final JLabel label_1 = new JLabel("");

	private final JTextField textFieldTiempo = new JTextField();
	private final JTextField textFieldPuntaje = new JTextField();
	private final JTextField textFieldJugador = new JTextField();
	private final JTextField txtPreguntasAcertadas = new JTextField();

	private final JLabel label = new JLabel("");
	private final JLabel label_2 = new JLabel("");

	private PanelRuleta panelRuleta = new PanelRuleta(contenidoPartida);
	private PanelParaResponder panelParaResponder = new PanelParaResponder(contenidoPartida);

	private final JLabel label_3 = new JLabel("");
	private final JLabel label_4 = new JLabel("");
	private final JLabel label_5 = new JLabel("");
	private final JLabel label_6 = new JLabel("");

	private T jugador;

	private Temporizador reloj;
	private final JButton btnVolver = new JButton("Volver");
	private final JLabel label_7 = new JLabel("");
	private final JLabel label_8 = new JLabel("");
	private final JLabel label_9 = new JLabel("");

	/**
	 * Create the panel.
	 */
	public PanelPartida(SuperPanel contentPane)
	{
		jugador = (T) contentPane.getCuentaActiva();
		reloj = new Temporizador(textFieldTiempo,contentPane,contenidoPartida,jugador);
		setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 450, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 100, 100, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0,0,5,0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.setBackground(Color.BLACK);

		panel.setLayout(new GridLayout(0,2,0,0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel,gbc_panel);
		lblEstado.setBackground(Color.BLACK);
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Stencil",Font.PLAIN,18));
		panel.add(lblEstado);
		panel.add(label_1);

		textFieldTiempo.setText("Tiempo: " + reloj.devolverTiempoInicial());
		textFieldTiempo.setEditable(false);
		textFieldTiempo.setFont(new Font("Stencil",Font.PLAIN,16));
		textFieldTiempo.setColumns(10);
		panel.add(textFieldTiempo);

		actualizarEstadoPuntosDePartidaYPreguntasAcertadasDePartida();
		txtPreguntasAcertadas.setEditable(false);
		txtPreguntasAcertadas.setFont(new Font("Stencil",Font.PLAIN,16));
		txtPreguntasAcertadas.setColumns(10);
		panel.add(txtPreguntasAcertadas);

		actualizarEstadoJugadorDePartida();
		textFieldJugador.setEditable(false);
		textFieldJugador.setFont(new Font("Stencil",Font.PLAIN,16));
		textFieldJugador.setColumns(10);
		panel.add(textFieldJugador);

		textFieldPuntaje.setEditable(false);
		textFieldPuntaje.setFont(new Font("Stencil",Font.PLAIN,16));
		textFieldPuntaje.setColumns(10);

		panel.add(textFieldPuntaje);

		panel.add(label_3);

		panel.add(label_4);
		
		panel.add(label_8);

		panel.add(label_5);
		
		panel.add(label_9);

		panel.add(label_6);

		panel.add(label_7);

		panel.add(btnIniciarPartida);
		btnIniciarPartida.setForeground(Color.GREEN);
		btnIniciarPartida.setBackground(Color.BLACK);
		btnIniciarPartida.setFont(new Font("Stencil",Font.PLAIN,18));
		btnIniciarPartida.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnAbandonarPartida.setEnabled(true);
				btnVolver.setEnabled(false);
				actualizarEstadosPartida();
				btnIniciarPartida.setEnabled(false);
				contenidoPartida.getData().copiarPreguntasDelArchivoAlaColeccion("preguntas.dat");
				contenidoPartida.getData().copiarCuentasDelArchivoAlaColeccion("jugadores.dat");
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
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelMenuJugador");
			}
		});

		panel.add(btnVolver);

		panel.add(btnAbandonarPartida);
		btnAbandonarPartida.setBackground(Color.BLACK);
		btnAbandonarPartida.setFont(new Font("Stencil",Font.PLAIN,18));
		btnAbandonarPartida.setForeground(Color.RED);
		btnAbandonarPartida.setEnabled(false);
		btnAbandonarPartida.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int respuesta = JOptionPane.showConfirmDialog(null,"�Realmente desea abandonar la partida?",
						"Abandonar partida",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(respuesta == 0)
				{
					desplazarAotroPanel(contentPane,"panelMenuJugador");
				}
			}
		});

		panel.add(label);
		panel.add(label_2);

	}

	public void setJugador(T jugador)
	{
		this.jugador = jugador;
	}

	private void actualizarEstadosPartida()
	{
		actualizarEstadoTiempo();
	}

	private void actualizarEstadoTiempo()
	{
		reloj.start(100,1000);
	}

	private void actualizarEstadoPuntosDePartidaYPreguntasAcertadasDePartida()
	{
		ActualizadorPartida actualizador = new ActualizadorPartida(textFieldPuntaje,txtPreguntasAcertadas,
				contenidoPartida,textFieldTiempo);
		actualizador.start();
	}

	private void actualizarEstadoJugadorDePartida()
	{
		textFieldJugador.setText("Jugador: " + this.jugador.getNickname());
	}

}
