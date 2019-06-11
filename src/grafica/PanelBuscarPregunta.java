package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBuscarPregunta extends SuperPanel
{
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelBuscarPregunta(SuperPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JLabel lblBuscadorDePreguntas = new JLabel("Buscador de preguntas");
		lblBuscadorDePreguntas.setForeground(Color.WHITE);
		lblBuscadorDePreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscadorDePreguntas.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblBuscadorDePreguntas);

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
				desplazarAotroPanel(contentPane,"panelMenuADMenunciados");
			}
		});
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

	}

}
