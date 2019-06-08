package grafica;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenu;



public class MarcoVentana extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MarcoVentana frame = new MarcoVentana();
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MarcoVentana()
	{
		setBackground(Color.BLACK);
		setTitle("AnsWAR");
		Toolkit pantalla=Toolkit.getDefaultToolkit();
		Image miIcono=pantalla.getImage("src/imagenes/IconoAnswar.png");
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
		mnOpciones.setFont(new Font("Stencil", Font.PLAIN, 12));
		menuBar.add(mnOpciones);
		
		JButton btnInicio = new JButton("Inicio                 ");
		mnOpciones.add(btnInicio);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contentPane.getComponent(0).getName().equals("panelExterior")==false)
				{
					desplazarAotroPanel(contentPane,"panelExterior");
				}
				
			}
		});
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setBackground(Color.BLACK);
		btnInicio.setFont(new Font("Stencil", Font.PLAIN, 11));
		
		JButton btnCerrarSesion = new JButton("Cerrar sesion");
		mnOpciones.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contentPane.getComponent(0).getName().equals("panelExterior")==false)
				{
					desplazarAotroPanel(contentPane,"panelLogin");	
				}
			}
		});
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Stencil", Font.PLAIN, 11));
		
		JButton btnSalir = new JButton("Salir                 ");
		mnOpciones.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();	
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setFont(new Font("Stencil", Font.PLAIN, 11));
		
		JMenu mnOpciones_1 = new JMenu("Opciones");
		mnOpciones_1.setFont(new Font("Stencil", Font.PLAIN, 12));
		mnOpciones_1.setForeground(Color.GRAY);
		mnOpciones_1.setBackground(Color.DARK_GRAY);
		menuBar.add(mnOpciones_1);
		
		JButton btnMusica = new JButton("Musica");	
		mnOpciones_1.add(btnMusica);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0,0));

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
		
		PanelMenuADMenunciados panelMenuADMenunciados=new PanelMenuADMenunciados(contentPane);
		panelMenuADMenunciados.setName("panelMenuADMenunciados");
		contentPane.add(panelMenuADMenunciados);
		
		PanelMenuADMjugadores panelMenuADMjugadores=new PanelMenuADMjugadores(contentPane);
		panelMenuADMjugadores.setName("panelMenuADMjugadores");
		contentPane.add(panelMenuADMjugadores);
		
		PanelMenuJugador panelMenuJugador=new PanelMenuJugador(contentPane);
		panelMenuJugador.setName("panelMenuJugador");
		contentPane.add(panelMenuJugador);
		
		PanelCargarPreguntas panelCargarPreguntas=new PanelCargarPreguntas(contentPane);
		panelCargarPreguntas.setName("panelCargarPreguntas");
		contentPane.add(panelCargarPreguntas);
		
		PanelBuscarPregunta panelBuscarPregunta=new PanelBuscarPregunta(contentPane);
		panelBuscarPregunta.setName("panelBuscarPregunta");
		contentPane.add(panelBuscarPregunta);
		
		PanelVerPreguntas panelVerPreguntas=new PanelVerPreguntas(contentPane);
		panelVerPreguntas.setName("panelVerPreguntas");
		contentPane.add(panelVerPreguntas);
		
		PanelBuscarJugador panelBuscarJugador=new PanelBuscarJugador(contentPane);
		panelBuscarJugador.setName("panelBuscarJugador");
		contentPane.add(panelBuscarJugador);
		
		PanelClasificacion panelClasificacion=new PanelClasificacion(contentPane);
		panelClasificacion.setName("panelClasificacion");
		contentPane.add(panelClasificacion);
		
		PanelRuleta panelRuleta=new PanelRuleta(contentPane);
		panelRuleta.setName("panelRuleta");
		contentPane.add(panelRuleta);
		
	}
	
	private void desplazarAotroPanel(JPanel contentPane, String panelAmostrar)
	{
		boolean busqueda = false;
		Component auxiliar = new JPanel();
		Component auxiliar2=contentPane.getComponent(0);
		int i = 0;
		while(busqueda == false)
		{
			auxiliar = contentPane.getComponent(i);
			if(panelAmostrar.equalsIgnoreCase(auxiliar.getName()))
			{
				contentPane.add(auxiliar,0);
				contentPane.add(auxiliar2,i);
				busqueda=true;
			}
				
			i++;
		}
	}
	
	private void desactivarBotonCuentaEnPanelesSinSesion(JMenu mnCuenta)
	{
		if((contentPane.getComponent(0).getName().equals("panelExterior"))||(contentPane.getComponent(0).getName().equals("panelLogin"))||(contentPane.getComponent(0).getName().equals("panelRegistro")))
			mnCuenta.setEnabled(false);
		else
			mnCuenta.setEnabled(true);				
	}
	
}