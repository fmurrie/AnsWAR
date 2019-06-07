package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenuJugador extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelMenuJugador(JPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBackground(Color.BLACK);
		btnJugar.setForeground(Color.GREEN);
		btnJugar.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnJugar);

		JButton btnClasificacion = new JButton("Ver clasificacion");
		btnClasificacion.setForeground(Color.GREEN);
		btnClasificacion.setFont(new Font("Stencil",Font.PLAIN,18));
		btnClasificacion.setBackground(Color.BLACK);
		add(btnClasificacion);
		
		JButton btnPerfil = new JButton("Mi perfil");
		btnPerfil.setForeground(Color.GREEN);
		btnPerfil.setBackground(Color.BLACK);
		btnPerfil.setFont(new Font("Stencil", Font.PLAIN, 18));
		add(btnPerfil);
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.setForeground(Color.GREEN);
		btnConfiguracion.setBackground(Color.BLACK);
		btnConfiguracion.setFont(new Font("Stencil", Font.PLAIN, 18));
		add(btnConfiguracion);

	}

}
