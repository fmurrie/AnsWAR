package grafica;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Color;


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
		
		
	}
	
	
}
