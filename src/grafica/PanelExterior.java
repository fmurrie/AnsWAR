package grafica;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import personas.JugadorInvitado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Panel grafico en el cual el usuario puede elegir entre iniciar sesion,
 * registrarse o jugar como invitado
 */
public class PanelExterior extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelExterior(SuperPanel contentPane)
	{
		setLayout(new GridLayout(4,1,0,0));
		setBackground(Color.BLACK);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelLogin");
			}
		});
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBackground(Color.BLACK);
		btnIniciarSesion.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnIniciarSesion);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelRegistro");
			}
		});
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBackground(Color.BLACK);
		btnRegistrarse.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnRegistrarse);

		JButton btnIngresarComoInvitado = new JButton("Ingresar como invitado");
		btnIngresarComoInvitado.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				contentPane.setCuentaActiva(new JugadorInvitado());
				desplazarAotroPanel(contentPane,"panelMenuJugador");
			}
		});
		btnIngresarComoInvitado.setForeground(Color.WHITE);
		btnIngresarComoInvitado.setBackground(Color.BLACK);
		btnIngresarComoInvitado.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnIngresarComoInvitado);

	}

}
