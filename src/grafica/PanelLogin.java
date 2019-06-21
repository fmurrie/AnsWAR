package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import personas.Admin;
import personas.*;
import personas.JugadorPermanente;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Panel grafico donde se inicia sesion, ingresando usuario y constraseña.
 */
public class PanelLogin extends SuperPanel
{
	private JTextField usuarioField;
	private JPasswordField passwordField;
	private Cuenta cuentaLogger;

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

		usuarioField = new JTextField();
		usuarioField.setFont(new Font("Tahoma",Font.PLAIN,16));
		usuarioField.setBackground(Color.LIGHT_GRAY);
		usuarioField.setHorizontalAlignment(SwingConstants.CENTER);
		add(usuarioField);
		usuarioField.setColumns(10);

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
				String auxParaElusuario = usuarioField.getText();
				String auxParaLaClave = String.valueOf(passwordField.getPassword());
				if((!auxParaElusuario.equals("")) && (!auxParaLaClave.equals("")))
					iniciarSesionSegunElacceso(contentPane,auxParaElusuario,auxParaLaClave);
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

	private Cuenta accesoParaTodos(SuperPanel contentPane, String usuario, String clave)
	{
		Cuenta obj = null;

		if((usuario.equalsIgnoreCase("Administrador")) && (clave.equals("answar")))
		{
			obj = new Admin(usuario,clave);
		}else
		{
			obj = contentPane.getData().loggearCuenta("jugadores.dat",usuario,clave);
		}

		return obj;
	}

	private void iniciarSesionSegunElacceso(SuperPanel contentPane, String auxParaElusuario, String auxParaLaClave)
	{
		usuarioField.setText("");
		passwordField.setText("");
		Cuenta obj = null;

		obj = accesoParaTodos(contentPane,auxParaElusuario,auxParaLaClave);

		if(obj != null)
		{
			contentPane.setCuentaActivaYactualizarTextFields(obj);

			if(contentPane.getCuentaActiva() instanceof Admin)
				desplazarAotroPanel(contentPane,"panelMenuAdministracion");
			if(contentPane.getCuentaActiva() instanceof JugadorPermanente)
				desplazarAotroPanel(contentPane,"panelMenuJugador");
		}else
		{
			JOptionPane.showMessageDialog(null,"La combinacion de datos ingresados no existe.");
		}
	}

}
