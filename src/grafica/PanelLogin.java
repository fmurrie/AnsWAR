package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import personas.Admin;
import personas.JugadorPermanente;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLogin extends SuperPanel
{
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public PanelLogin(SuperPanel contentPane)
	{
		setLayout(new GridLayout(7,1,0,0));
		setBackground(Color.BLACK);

		JLabel label = new JLabel("");
		label.setBackground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
		label.setOpaque(true);
		add(label);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBackground(Color.BLACK);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Stencil",Font.PLAIN,18));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setOpaque(true);
		add(lblUsuario);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		add(textField);
		textField.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBackground(Color.BLACK);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Stencil",Font.PLAIN,18));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setOpaque(true);
		add(lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma",Font.PLAIN,16));
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		add(passwordField);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				contentPane.setCuentaActivaYactualizarTextFields(contentPane.getCuentaActiva()); //despues modificarlo y borrar este comentario
				
				if(contentPane.getCuentaActiva() instanceof Admin)
					desplazarAotroPanel(contentPane,"panelMenuAdministracion");
				if(contentPane.getCuentaActiva() instanceof JugadorPermanente)
					desplazarAotroPanel(contentPane,"panelMenuJugador");
			}
		});
		btnIngresar.setBackground(Color.BLACK);
		btnIngresar.setForeground(Color.GREEN);
		btnIngresar.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnIngresar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelExterior");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		btnVolver.setBackground(Color.BLACK);
		add(btnVolver);

	}

}
