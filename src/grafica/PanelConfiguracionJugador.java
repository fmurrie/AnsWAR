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

import personas.Cuenta;
import personas.Jugador;
import personas.JugadorPermanente;

public class PanelConfiguracionJugador extends SuperPanel
{
	private JPasswordField passwordField = new JPasswordField();
	private JTextField correoField = new JTextField();
	private JTextField nicknameField = new JTextField();

	/**
	 * Create the panel.
	 */
	public PanelConfiguracionJugador(SuperPanel contentPane)
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

		
		nicknameField.setHorizontalAlignment(SwingConstants.CENTER);
		nicknameField.setFont(new Font("Tahoma",Font.PLAIN,16));
		nicknameField.setBackground(Color.LIGHT_GRAY);
		add(nicknameField);
		
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

		//actualizarTextoTextFields(contentPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//vaciarTextoTextFields();
				desplazarAotroPanel(contentPane,"panelMenuJugador");
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
				modificarCuenta(contentPane);
				actualizarTextoTextFields(contentPane);
			}
		});
		btnModificar.setForeground(Color.GREEN);
		btnModificar.setFont(new Font("Stencil",Font.PLAIN,18));
		btnModificar.setBackground(Color.BLACK);
		add(btnModificar);

	}
	
	//Metodos varios:
	
	private void modificarCuenta(SuperPanel contentPane)
	{
		JugadorPermanente aux = (JugadorPermanente) contentPane.getCuentaActiva();
		String auxId=aux.getId();
		String auxUsuario=aux.getUsuario();
		String auxDni=aux.getDni();
		String auxClave=aux.getClave();
		String auxCorreo=aux.getCorreo();
		String auxNickname= ((Jugador)aux).getNickname();
		String claveField = String.valueOf(passwordField.getPassword());
		
		JugadorPermanente aux2 = null;
		
		
		//aca modifica nickname-clave-correo
		if((!(nicknameField.getText().equals(""))&&(!(correoField.getText().equals(""))&&(!(claveField.equals(""))))))  
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,claveField,auxDni,correoField.getText(),nicknameField.getText());
		}
		
		//aca modifica nickname
		if((!(nicknameField.getText().equals(""))&&((correoField.getText().equals(""))&&((claveField.equals(""))))))  
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,auxClave,auxDni,auxCorreo,nicknameField.getText());
		}
		
		//aca modifica clave	
		if(((nicknameField.getText().equals(""))&&((correoField.getText().equals(""))&&(!(claveField.equals(""))))))  
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,claveField,auxDni,auxCorreo,auxNickname);
		}
		
		 //aca modifica correo
		if(((nicknameField.getText().equals(""))&&(!(correoField.getText().equals(""))&&((claveField.equals("")))))) 
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,auxClave,auxDni,correoField.getText(),auxNickname);
		}
		
		//aca modifica nickname-clave
		if((!(nicknameField.getText().equals(""))&&((correoField.getText().equals(""))&&(!(claveField.equals(""))))))  
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,claveField,auxDni,auxCorreo,nicknameField.getText());
		}
		
		//aca modifica nickname-correo
		if((!(nicknameField.getText().equals(""))&&(!(correoField.getText().equals(""))&&((claveField.equals(""))))))  	
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,auxClave,auxDni,correoField.getText(),nicknameField.getText());
		}
		
		 //aca modifica clave-correo
		if(((nicknameField.getText().equals(""))&&(!(correoField.getText().equals(""))&&(!(claveField.equals("")))))) 	
		{
			aux2 = new JugadorPermanente(auxId,auxUsuario,claveField,auxDni,correoField.getText(),auxNickname);
		}
		
		//Se reemplaza la cuenta modificada por la original
		if(aux2!=null)
		{
			contentPane.getData().modificarCuenta("jugadores.dat", aux, aux2);
			
			contentPane.setCuentaActivaYactualizarTextFields(new JugadorPermanente(aux2));
	
		}
		
		
			
	}
	
	
		public void actualizarTextoTextFields(SuperPanel contentPane)
		{
			Jugador aux = (Jugador) contentPane.getCuentaActiva();
			String auxClave=aux.getClave();
			String auxCorreo=aux.getCorreo();
			String auxNickname=aux.getNickname();
			
			this.nicknameField.setText(auxNickname);
			this.passwordField.setText(auxClave);
			this.correoField.setText(auxCorreo);
		}
		
		private void vaciarTextoTextFields()
		{
			this.nicknameField.setText("");
			this.passwordField.setText("");
			this.correoField.setText("");	
		}

}
