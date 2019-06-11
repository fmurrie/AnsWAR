package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelRuleta extends SuperPanel
{

	private Ruleta ruletaDeSuerte = new Ruleta();
	private JTextField resultado = new JTextField();
	private ButtonGroup grupoTogleBotones = new ButtonGroup();
	private JToggleButton tglbtnGirar = new JToggleButton("Empujar");
	private JToggleButton tglbtnDetener = new JToggleButton("Detener");
	private JButton btnPartida = new JButton("Ir a la pregunta");

	/**
	 * Create the panel.
	 */
	public PanelRuleta(SuperPanel contenidoPartida)
	{
		setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 150, 150, 150, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 42, 0, 42, 42, 42, 42, 42, 42, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel label_11 = new JLabel("");
		label_11.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.fill = GridBagConstraints.BOTH;
		gbc_label_11.insets = new Insets(0,0,5,5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 0;
		add(label_11,gbc_label_11);

		JLabel label_10 = new JLabel("");
		label_10.setBackground(Color.BLACK);
		label_10.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.fill = GridBagConstraints.BOTH;
		gbc_label_10.insets = new Insets(0,0,5,5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 0;
		add(label_10,gbc_label_10);

		JLabel label_9 = new JLabel("");
		label_9.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.fill = GridBagConstraints.BOTH;
		gbc_label_9.insets = new Insets(0,0,5,0);
		gbc_label_9.gridx = 2;
		gbc_label_9.gridy = 0;
		add(label_9,gbc_label_9);

		JLabel label_1 = new JLabel("");
		label_1.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0,0,5,5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		add(label_1,gbc_label_1);

		JLabel lblRuleta = new JLabel("Probar suerte");
		lblRuleta.setBackground(Color.BLACK);
		lblRuleta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuleta.setForeground(Color.WHITE);
		lblRuleta.setFont(new Font("Stencil",Font.PLAIN,30));
		GridBagConstraints gbc_lblRuleta = new GridBagConstraints();
		gbc_lblRuleta.fill = GridBagConstraints.BOTH;
		gbc_lblRuleta.insets = new Insets(0,0,5,5);
		gbc_lblRuleta.gridx = 1;
		gbc_lblRuleta.gridy = 2;
		add(lblRuleta,gbc_lblRuleta);

		JLabel label = new JLabel("");
		label.setBackground(Color.BLACK);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0,0,5,0);
		gbc_label.gridx = 2;
		gbc_label.gridy = 2;
		add(label,gbc_label);

		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0,0,5,5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		add(label_2,gbc_label_2);

		tglbtnGirar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ruletaDeSuerte.girarRuleta();
				tglbtnDetener.setEnabled(true);
				tglbtnGirar.setEnabled(false);
			}
		});
		tglbtnGirar.setBackground(Color.BLACK);
		tglbtnGirar.setForeground(Color.GREEN);
		tglbtnGirar.setFont(new Font("Stencil",Font.PLAIN,18));
		grupoTogleBotones.add(tglbtnGirar);
		GridBagConstraints gbc_tglbtnGirar = new GridBagConstraints();
		gbc_tglbtnGirar.fill = GridBagConstraints.BOTH;
		gbc_tglbtnGirar.insets = new Insets(0,0,5,5);
		gbc_tglbtnGirar.gridx = 1;
		gbc_tglbtnGirar.gridy = 3;
		add(tglbtnGirar,gbc_tglbtnGirar);

		JLabel label_3 = new JLabel("");
		label_3.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0,0,5,0);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 3;
		add(label_3,gbc_label_3);

		JLabel label_4 = new JLabel("");
		label_4.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0,0,5,5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		add(label_4,gbc_label_4);

		tglbtnDetener.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				tglbtnGirar.setEnabled(false);
				btnPartida.setEnabled(true);
				resultado.setText(ruletaDeSuerte.getResultado());
				add(resultado);
				tglbtnDetener.setEnabled(false);
			}
		});
		tglbtnDetener.setEnabled(false);
		tglbtnDetener.setBackground(Color.BLACK);
		tglbtnDetener.setFont(new Font("Stencil",Font.PLAIN,18));
		tglbtnDetener.setForeground(Color.RED);
		grupoTogleBotones.add(tglbtnDetener);
		GridBagConstraints gbc_tglbtnDetener = new GridBagConstraints();
		gbc_tglbtnDetener.fill = GridBagConstraints.BOTH;
		gbc_tglbtnDetener.insets = new Insets(0,0,5,5);
		gbc_tglbtnDetener.gridx = 1;
		gbc_tglbtnDetener.gridy = 4;
		add(tglbtnDetener,gbc_tglbtnDetener);

		JLabel label_5 = new JLabel("");
		label_5.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.insets = new Insets(0,0,5,0);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 4;
		add(label_5,gbc_label_5);

		JLabel label_6 = new JLabel("");
		label_6.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.BOTH;
		gbc_label_6.insets = new Insets(0,0,5,5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 5;
		add(label_6,gbc_label_6);

		JLabel label_7 = new JLabel("");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.fill = GridBagConstraints.BOTH;
		gbc_label_7.insets = new Insets(0,0,5,5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 5;
		add(label_7,gbc_label_7);

		JLabel label_8 = new JLabel("");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.fill = GridBagConstraints.BOTH;
		gbc_label_8.insets = new Insets(0,0,5,0);
		gbc_label_8.gridx = 2;
		gbc_label_8.gridy = 5;
		add(label_8,gbc_label_8);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Stencil",Font.PLAIN,18));
		lblResultado.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.fill = GridBagConstraints.BOTH;
		gbc_lblResultado.insets = new Insets(0,0,5,5);
		gbc_lblResultado.gridx = 0;
		gbc_lblResultado.gridy = 6;
		add(lblResultado,gbc_lblResultado);

		resultado.setEditable(false);
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBackground(Color.GRAY);
		resultado.setForeground(Color.CYAN);
		resultado.setFont(new Font("Stencil",Font.PLAIN,18));
		resultado.setColumns(10);
		GridBagConstraints gbc_resultado = new GridBagConstraints();
		gbc_resultado.fill = GridBagConstraints.BOTH;
		gbc_resultado.insets = new Insets(0,0,5,5);
		gbc_resultado.gridx = 1;
		gbc_resultado.gridy = 6;
		add(resultado,gbc_resultado);

		JLabel label_12 = new JLabel("");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.fill = GridBagConstraints.BOTH;
		gbc_label_12.insets = new Insets(0,0,5,0);
		gbc_label_12.gridx = 2;
		gbc_label_12.gridy = 6;
		add(label_12,gbc_label_12);

		JLabel label_13 = new JLabel("");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.fill = GridBagConstraints.BOTH;
		gbc_label_13.insets = new Insets(0,0,5,5);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 7;
		add(label_13,gbc_label_13);

		btnPartida.setEnabled(false);
		btnPartida.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				desplazarAotroPanel(contenidoPartida,"panelParaResponder");
				restaurarValoresPanelParaResponder(contenidoPartida);
				revalidate();
				repaint();
			}
		});
		btnPartida.setForeground(Color.ORANGE);
		btnPartida.setBackground(Color.BLACK);
		btnPartida.setFont(new Font("Stencil",Font.PLAIN,18));
		GridBagConstraints gbc_btnPartida = new GridBagConstraints();
		gbc_btnPartida.fill = GridBagConstraints.BOTH;
		gbc_btnPartida.insets = new Insets(0,0,5,5);
		gbc_btnPartida.gridx = 1;
		gbc_btnPartida.gridy = 7;
		add(btnPartida,gbc_btnPartida);

	}

}
