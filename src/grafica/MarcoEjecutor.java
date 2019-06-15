package grafica;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import audio.Sonido;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import personas.Admin;
import personas.Cuenta;
import personas.*;
import personas.JugadorPermanente;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class MarcoEjecutor extends JFrame implements IRelacionFrameYPaneles
{

	/**
	 * Create the frame.
	 */

	private SuperPanel contentPane;

	public MarcoEjecutor()
	{
		// reproducirSonido("src/audio/musicaAnswar.mp3");

		setBackground(Color.BLACK);
		setTitle("AnsWAR");
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image miIcono = pantalla.getImage("src/imagenes/IconoAnswar.png");
		setIconImage(miIcono);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1000,600);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);

		JMenu mnOpciones = new JMenu("Menu");
		mnOpciones.setForeground(Color.GRAY);
		mnOpciones.setBackground(Color.BLACK);
		mnOpciones.setFont(new Font("Stencil",Font.PLAIN,12));
		menuBar.add(mnOpciones);

		JButton btnInicio = new JButton("Inicio                 ");
		mnOpciones.add(btnInicio);
		btnInicio.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(contentPane.getComponent(0).getName().equals("panelExterior") == false)
				{
					contentPane.setCuentaActiva(new JugadorInvitado());
					contentPane.restaurarLosTextFieldCuentaActiva();
					desplazarAotroPanel(contentPane,"panelExterior");
				}

			}
		});
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setBackground(Color.BLACK);
		btnInicio.setFont(new Font("Stencil",Font.PLAIN,11));

		JButton btnCerrarSesion = new JButton("Cerrar sesion");
		mnOpciones.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(contentPane.getComponent(0).getName().equals("panelExterior") == false)
				{
					contentPane.setCuentaActiva(new JugadorInvitado());
					contentPane.restaurarLosTextFieldCuentaActiva();
					desplazarAotroPanel(contentPane,"panelLogin");
				}
			}
		});
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Stencil",Font.PLAIN,11));

		JButton btnSalir = new JButton("Salir                 ");
		mnOpciones.add(btnSalir);
		btnSalir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setFont(new Font("Stencil",Font.PLAIN,11));

		JMenu mnOpciones_1 = new JMenu("Opciones");
		mnOpciones_1.setFont(new Font("Stencil",Font.PLAIN,12));
		mnOpciones_1.setForeground(Color.GRAY);
		mnOpciones_1.setBackground(Color.DARK_GRAY);
		menuBar.add(mnOpciones_1);

		contentPane = new SuperPanel();
		contentPane.setCuentaActiva(new JugadorInvitado());
		contentPane.getData().copiarCuentasDelArchivoAlaColeccion("jugadores.dat");
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0,0));

		JMenu mnCuenta = new JMenu("Cuenta");
		mnCuenta.setForeground(Color.GRAY);
		mnCuenta.setBackground(Color.BLACK);
		mnCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		mnCuenta.setFont(new Font("Stencil",Font.PLAIN,12));
		menuBar.add(mnCuenta);

		mnCuenta.add(contentPane.getTxtId());
		mnCuenta.add(contentPane.getTxtUsuario());

		PanelExterior panelExterior = new PanelExterior(contentPane);
		panelExterior.setName("panelExterior");
		contentPane.add(panelExterior);

		PanelLogin panelLogin = new PanelLogin(contentPane);
		panelLogin.setName("panelLogin");
		contentPane.add(panelLogin);

		PanelRegistro panelRegistro = new PanelRegistro(contentPane);
		panelRegistro.setName("panelRegistro");
		contentPane.add(panelRegistro);

		PanelMenuAdministracion panelMenuAdministracion = new PanelMenuAdministracion(contentPane);
		panelMenuAdministracion.setName("panelMenuAdministracion");
		contentPane.add(panelMenuAdministracion);

		PanelMenuADMenunciados panelMenuADMenunciados = new PanelMenuADMenunciados(contentPane);
		panelMenuADMenunciados.setName("panelMenuADMenunciados");
		contentPane.add(panelMenuADMenunciados);

		PanelMenuADMjugadores panelMenuADMjugadores = new PanelMenuADMjugadores(contentPane);
		panelMenuADMjugadores.setName("panelMenuADMjugadores");
		contentPane.add(panelMenuADMjugadores);

		PanelMenuJugador panelMenuJugador = new PanelMenuJugador(contentPane);
		panelMenuJugador.setName("panelMenuJugador");
		contentPane.add(panelMenuJugador);

		PanelCargarPreguntas panelCargarPreguntas = new PanelCargarPreguntas(contentPane);
		panelCargarPreguntas.setName("panelCargarPreguntas");
		contentPane.add(panelCargarPreguntas);

		PanelBuscarPregunta panelBuscarPregunta = new PanelBuscarPregunta(contentPane);
		panelBuscarPregunta.setName("panelBuscarPregunta");
		contentPane.add(panelBuscarPregunta);

		PanelVerPreguntas panelVerPreguntas = new PanelVerPreguntas(contentPane);
		panelVerPreguntas.setName("panelVerPreguntas");
		contentPane.add(panelVerPreguntas);

		PanelBuscarJugador panelBuscarJugador = new PanelBuscarJugador(contentPane);
		panelBuscarJugador.setName("panelBuscarJugador");
		contentPane.add(panelBuscarJugador);

		PanelClasificacion panelClasificacion = new PanelClasificacion(contentPane);
		panelClasificacion.setName("panelClasificacion");
		contentPane.add(panelClasificacion);

		PanelPartida panelPartida = new PanelPartida(contentPane);
		panelPartida.setName("panelPartida");
		contentPane.add(panelPartida);

		PanelConfiguracionJugador panelConfiguracionJugador = new PanelConfiguracionJugador(contentPane);
		panelConfiguracionJugador.setName("panelConfiguracionJugador");
		contentPane.add(panelConfiguracionJugador);
		
		PanelInspeccionarJugadores panelInspeccionarJugadores=new PanelInspeccionarJugadores(contentPane);
		panelInspeccionarJugadores.setName("panelInspeccionarJugadores");
		contentPane.add(panelInspeccionarJugadores);
		
		PanelEditarJugadoresAdm panelEditarJugadoresAdm=new PanelEditarJugadoresAdm(contentPane);
		panelEditarJugadoresAdm.setName("panelEditarJugadoresAdm");
		contentPane.add(panelEditarJugadoresAdm);
		
		
		
	}

	public void desplazarAotroPanel(SuperPanel contentPane, String panelAmostrar)
	{
		boolean busqueda = false;
		Component auxiliar = new JPanel();
		Component auxiliar2 = contentPane.getComponent(0);
		int i = 0;
		while(busqueda == false)
		{
			auxiliar = contentPane.getComponent(i);
			if(panelAmostrar.equalsIgnoreCase(auxiliar.getName()))
			{
				contentPane.add(auxiliar,0);
				contentPane.add(auxiliar2,i);
				busqueda = true;
			}

			i++;
		}
		restaurarValoresPanelPartida(contentPane);
	}

	private void restaurarValoresPanelPartida(SuperPanel contentPane)
	{
		if(contentPane.getComponent(0).getName().equalsIgnoreCase("panelPartida"))
		{
			PanelPartida panelPartida = new PanelPartida(contentPane);
			panelPartida.setName("panelPartida");
			contentPane.remove(0);
			contentPane.add(panelPartida,0);
		}
	}

	public int buscarPanelPorNombreYdevolverPos(SuperPanel contentPane, String nombrePanel)
	{
		boolean encontro = false;
		int i = 0;

		while(encontro = false)
		{
			if(contentPane.getComponent(i).getName().equals(nombrePanel))
			{
				encontro = true;
			}
			i++;
		}
		return i;
	}

	public Component obtenerPanelPorNombreYdevolverPos(SuperPanel contentPane, String nombrePanel)
	{
		boolean encontro = false;
		Component aux = null;
		int i = 0;

		while(encontro == false)
		{
			if(contentPane.getComponent(i).getName().equals(nombrePanel))
			{
				aux = contentPane.getComponent(i);
				encontro = true;
			}
			i++;
		}
		return aux;
	}
	
	@Override
	public void eliminarUnPanel(SuperPanel contentPane, String nombrePanel)
	{
		boolean encontro = false;
		int i = 0;

		while(encontro == false)
		{
			if(contentPane.getComponent(i).getName().equals(nombrePanel))
			{
				contentPane.remove(i);
				encontro = true;
			}
			i++;
		}
	}

	public void reproducirSonido(String rutaCancion)
	{
		try
		{
			Sonido sound = new Sonido(rutaCancion);
			sound.start();
		}catch(FileNotFoundException | JavaLayerException e1)
		{
			e1.printStackTrace();
		}

	}

}