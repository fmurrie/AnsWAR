package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRegistro extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelRegistro(SuperPanel contentPane)
	{
		setLayout(new GridLayout(6,1,0,0));
		setBackground(Color.BLACK);

		JLabel lblUsuario = new JLabel("     Usuario: ");
		lblUsuario.setBackground(Color.BLACK);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Stencil",Font.PLAIN,18));
		lblUsuario.setOpaque(true);
		add(lblUsuario);

		JTextField textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField.setBackground(Color.LIGHT_GRAY);
		add(textField);
		textField.setColumns(10);

		JLabel lblContrasea = new JLabel("     Contrase\u00F1a:");
		lblContrasea.setBackground(Color.BLACK);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Stencil",Font.PLAIN,18));
		lblContrasea.setOpaque(true);
		add(lblContrasea);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma",Font.PLAIN,16));
		passwordField.setBackground(Color.LIGHT_GRAY);
		add(passwordField);

		JLabel lblDni = new JLabel("     DNI:");
		lblDni.setBackground(Color.BLACK);
		lblDni.setForeground(Color.WHITE);
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("Stencil",Font.PLAIN,18));
		lblDni.setOpaque(true);
		add(lblDni);

		JTextField textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField_2.setBackground(Color.LIGHT_GRAY);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblDireccionDeCorreo = new JLabel("     Direccion de correo:");
		lblDireccionDeCorreo.setBackground(Color.BLACK);
		lblDireccionDeCorreo.setForeground(Color.WHITE);
		lblDireccionDeCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccionDeCorreo.setFont(new Font("Stencil",Font.PLAIN,18));
		lblDireccionDeCorreo.setOpaque(true);
		add(lblDireccionDeCorreo);

		JTextField textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField_1.setBackground(Color.LIGHT_GRAY);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNickname = new JLabel("     Nickname:");
		lblNickname.setBackground(Color.BLACK);
		lblNickname.setForeground(Color.WHITE);
		lblNickname.setHorizontalAlignment(SwingConstants.LEFT);
		lblNickname.setFont(new Font("Stencil",Font.PLAIN,18));
		lblNickname.setOpaque(true);
		add(lblNickname);

		JTextField textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField_3.setBackground(Color.LIGHT_GRAY);
		add(textField_3);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelExterior");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(Color.GREEN);
		btnRegistrarse.setFont(new Font("Stencil",Font.PLAIN,18));
		btnRegistrarse.setBackground(Color.BLACK);
		add(btnRegistrarse);

	}

}
