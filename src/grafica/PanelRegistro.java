package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import personas.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRegistro extends SuperPanel
{
	private JTextField usuarioField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JTextField dniField = new JTextField();
	private JTextField correoField = new JTextField();
	private JTextField nicknameField = new JTextField();

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

		usuarioField.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioField.setFont(new Font("Tahoma",Font.PLAIN,16));
		usuarioField.setBackground(Color.LIGHT_GRAY);
		add(usuarioField);
		usuarioField.setColumns(10);

		JLabel lblContrasea = new JLabel("     Contrase\u00F1a:");
		lblContrasea.setBackground(Color.BLACK);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Stencil",Font.PLAIN,18));
		lblContrasea.setOpaque(true);
		add(lblContrasea);

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

		dniField.setHorizontalAlignment(SwingConstants.CENTER);
		dniField.setFont(new Font("Tahoma",Font.PLAIN,16));
		dniField.setBackground(Color.LIGHT_GRAY);
		add(dniField);
		dniField.setColumns(10);

		JLabel lblDireccionDeCorreo = new JLabel("     Direccion de correo:");
		lblDireccionDeCorreo.setBackground(Color.BLACK);
		lblDireccionDeCorreo.setForeground(Color.WHITE);
		lblDireccionDeCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccionDeCorreo.setFont(new Font("Stencil",Font.PLAIN,18));
		lblDireccionDeCorreo.setOpaque(true);
		add(lblDireccionDeCorreo);

		correoField.setHorizontalAlignment(SwingConstants.CENTER);
		correoField.setFont(new Font("Tahoma",Font.PLAIN,16));
		correoField.setBackground(Color.LIGHT_GRAY);
		add(correoField);
		correoField.setColumns(10);

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

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				vaciarTextoTextFields();
				desplazarAotroPanel(contentPane,"panelExterior");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				registrarCuenta(contentPane);
			}
		});
		btnRegistrarse.setForeground(Color.GREEN);
		btnRegistrarse.setFont(new Font("Stencil",Font.PLAIN,18));
		btnRegistrarse.setBackground(Color.BLACK);
		add(btnRegistrarse);

	}

	// Metodos varios:

	private void registrarCuenta(SuperPanel contentPane)
	{
		String auxUsuario = this.usuarioField.getText();
		String auxClave = String.valueOf(this.passwordField.getPassword());
		;
		String auxDni = this.dniField.getText();
		String auxCorreo = this.correoField.getText();
		String auxNickname = this.nicknameField.getText();
		boolean efectivo = false;

		if((!auxUsuario.equals("")) && (!auxClave.equals("")) && (!auxDni.equals("")) && (!auxCorreo.equals(""))
				&& (!auxNickname.equals("")))
		{
			JugadorPermanente aux = new JugadorPermanente(auxUsuario,auxClave,auxDni,auxCorreo,auxNickname);
			efectivo = contentPane.getData().registrarCuenta("jugadores.dat",aux);

			if(efectivo == false)
			{
				vaciarTextoTextFields();
				contentPane.setCuentaActivaYactualizarTextFields(aux);
				desplazarAotroPanel(contentPane,"panelMenuJugador");
			}else
			{
				JOptionPane.showMessageDialog(null,"Los datos ingresados ya estan en uso.");
				vaciarTextoTextFields();
			}
		}

	}

	private void vaciarTextoTextFields()
	{
		this.usuarioField.setText("");
		this.passwordField.setText("");
		this.dniField.setText("");
		this.correoField.setText("");
		this.nicknameField.setText("");
	}

}
