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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelBuscarJugador extends SuperPanel
{
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelBuscarJugador(JPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JLabel lblBuscadorDeJugadores = new JLabel("Buscador de jugadores");
		lblBuscadorDeJugadores.setForeground(Color.WHITE);
		lblBuscadorDeJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscadorDeJugadores.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblBuscadorDeJugadores);

		JLabel lblIngreseElId = new JLabel("Ingrese el ID");
		lblIngreseElId.setForeground(Color.WHITE);
		lblIngreseElId.setFont(new Font("Stencil",Font.PLAIN,18));
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblIngreseElId);

		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(textField);
		textField.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setForeground(Color.GREEN);
		btnBuscar.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnBuscar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				desplazarAotroPanel(contentPane,"panelMenuADMjugadores");
			}
		});
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

	}

}
