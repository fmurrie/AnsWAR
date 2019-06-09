package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import componentes.Ruleta;

import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class PanelRuleta extends SuperPanel
{
	private Ruleta ruletaDeSuerte = new Ruleta();
	private JTextField resultado = new JTextField();
	private ButtonGroup grupoTogleBotones = new ButtonGroup();
	private JToggleButton tglbtnGirar = new JToggleButton("Girar");
	private JToggleButton tglbtnDetener = new JToggleButton("Detener");

	/**
	 * Create the panel.
	 */
	public PanelRuleta(JPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,3,0,0));

		JLabel label_11 = new JLabel("");
		label_11.setBackground(Color.BLACK);
		add(label_11);

		JLabel label_10 = new JLabel("");
		label_10.setBackground(Color.BLACK);
		label_10.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
		add(label_10);

		JLabel label_9 = new JLabel("");
		label_9.setBackground(Color.BLACK);
		add(label_9);

		JLabel label_1 = new JLabel("");
		label_1.setBackground(Color.BLACK);
		add(label_1);

		JLabel lblRuleta = new JLabel("Ruleta");
		lblRuleta.setBackground(Color.BLACK);
		lblRuleta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuleta.setForeground(Color.WHITE);
		lblRuleta.setFont(new Font("Stencil",Font.PLAIN,30));
		add(lblRuleta);

		tglbtnGirar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ruletaDeSuerte.girarRuleta();
				tglbtnDetener.setEnabled(true);
			}
		});
		tglbtnGirar.setBackground(Color.BLACK);
		tglbtnGirar.setForeground(Color.GREEN);
		tglbtnGirar.setFont(new Font("Stencil",Font.PLAIN,18));

		tglbtnDetener.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				tglbtnGirar.setEnabled(false);
				resultado.setText(ruletaDeSuerte.getResultado());
				add(resultado);
			}
		});
		tglbtnDetener.setEnabled(false);
		tglbtnDetener.setBackground(Color.BLACK);
		tglbtnDetener.setFont(new Font("Stencil",Font.PLAIN,18));
		tglbtnDetener.setForeground(Color.RED);
		grupoTogleBotones.add(tglbtnGirar);
		grupoTogleBotones.add(tglbtnDetener);

		JLabel label = new JLabel("");
		label.setBackground(Color.BLACK);
		add(label);

		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.BLACK);
		add(label_2);
		add(tglbtnGirar);

		JLabel label_3 = new JLabel("");
		label_3.setBackground(Color.BLACK);
		add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setBackground(Color.BLACK);
		add(label_4);
		add(tglbtnDetener);

		JLabel label_5 = new JLabel("");
		label_5.setBackground(Color.BLACK);
		add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setBackground(Color.BLACK);
		add(label_6);

		JLabel label_7 = new JLabel("");
		add(label_7);

		JLabel label_8 = new JLabel("");
		add(label_8);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Stencil",Font.PLAIN,18));
		lblResultado.setForeground(Color.WHITE);
		add(lblResultado);

		resultado.setEditable(false);
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBackground(Color.GRAY);
		resultado.setForeground(Color.CYAN);
		resultado.setFont(new Font("Stencil",Font.PLAIN,18));
		resultado.setColumns(10);
		add(resultado);

		JLabel label_12 = new JLabel("");
		add(label_12);

		JLabel label_13 = new JLabel("");
		add(label_13);

		JButton btnPartida = new JButton("Ir a la pregunta");
		btnPartida.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				desplazarAotroPanel(contentPane,"panelParaResponder");
			}
		});
		btnPartida.setForeground(Color.ORANGE);
		btnPartida.setBackground(Color.BLACK);
		btnPartida.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnPartida);

	}
	

}
