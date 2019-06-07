package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMenuADMenunciados extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelMenuADMenunciados(JPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JButton btnCargarPreguntas = new JButton("Cargar enunciado");
		btnCargarPreguntas.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelCargarPreguntas");
			}
		});
		btnCargarPreguntas.setBackground(Color.BLACK);
		btnCargarPreguntas.setForeground(Color.GREEN);
		btnCargarPreguntas.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnCargarPreguntas);

		JButton btnA = new JButton("Editar enunciado");
		btnA.setForeground(Color.ORANGE);
		btnA.setFont(new Font("Stencil",Font.PLAIN,18));
		btnA.setBackground(Color.BLACK);
		add(btnA);
		
		JButton btnElimicarEnunciado = new JButton("Eliminar enunciado");
		btnElimicarEnunciado.setForeground(Color.RED);
		btnElimicarEnunciado.setBackground(Color.BLACK);
		btnElimicarEnunciado.setFont(new Font("Stencil", Font.PLAIN, 18));
		add(btnElimicarEnunciado);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desplazarAotroPanel(contentPane,"panelMenuAdministracion");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil", Font.PLAIN, 18));
		add(btnVolver);

	}

}
