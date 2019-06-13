package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import tiempo.Temporizador;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelParaResponder extends SuperPanel implements IRelacionPanelesRuletaYResponder
{
	private JTextField pregunta = new JTextField();
	private ButtonGroup grupoRdionBotomns = new ButtonGroup();
	private JToggleButton opcionA = new JToggleButton("");
	private JToggleButton opcionB = new JToggleButton("");
	private JToggleButton opcionC = new JToggleButton("");
	private JToggleButton opcionD = new JToggleButton("");
	private JTextField textField5sec = new JTextField();
	private final JLabel lblA = new JLabel("A)");
	private final JLabel lblB = new JLabel("b)");
	private final JLabel lblC = new JLabel("C)");
	private final JLabel lblD = new JLabel("D)");

	/**
	 * Create the panel.
	 */
	public PanelParaResponder(SuperPanel contenidoPartida)
	{
		setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 0, 0, 450, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 42, 42, 42, 42, 42, 42, 42, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0,0,5,0);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		add(label,gbc_label);
		pregunta.setEditable(false);
		pregunta.setForeground(Color.GREEN);
		pregunta.setBackground(Color.GRAY);
		pregunta.setFont(new Font("Stencil",Font.PLAIN,18));
		pregunta.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pregunta = new GridBagConstraints();
		gbc_pregunta.fill = GridBagConstraints.BOTH;
		gbc_pregunta.insets = new Insets(0,0,5,0);
		gbc_pregunta.gridx = 2;
		gbc_pregunta.gridy = 1;
		add(pregunta,gbc_pregunta);
		pregunta.setColumns(10);
		textField5sec.setText("Seleccione una opcion:");
		textField5sec.setHorizontalAlignment(SwingConstants.CENTER);
		textField5sec.setForeground(Color.CYAN);
		textField5sec.setFont(new Font("Stencil",Font.PLAIN,18));
		textField5sec.setBackground(Color.BLACK);
		textField5sec.setEditable(false);
		textField5sec.setColumns(10);
		GridBagConstraints gbc_textField5sec = new GridBagConstraints();
		gbc_textField5sec.insets = new Insets(0,0,5,0);
		gbc_textField5sec.fill = GridBagConstraints.BOTH;
		gbc_textField5sec.gridx = 2;
		gbc_textField5sec.gridy = 2;
		add(textField5sec,gbc_textField5sec);

		grupoRdionBotomns = new ButtonGroup();

		opcionD.setForeground(Color.WHITE);
		opcionD.setFont(new Font("Stencil",Font.PLAIN,16));
		opcionD.setBackground(Color.BLACK);
		opcionD.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				opcionA.setEnabled(false);
				opcionB.setEnabled(false);
				opcionC.setEnabled(false);
				moverseEntreRuletaYResponder(contenidoPartida);
			}
		});

		opcionC.setForeground(Color.WHITE);
		opcionC.setFont(new Font("Stencil",Font.PLAIN,16));
		opcionC.setBackground(Color.BLACK);
		opcionC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{

				opcionA.setEnabled(false);
				opcionB.setEnabled(false);
				opcionD.setEnabled(false);
				moverseEntreRuletaYResponder(contenidoPartida);
			}
		});

		opcionB.setForeground(Color.WHITE);
		opcionB.setFont(new Font("Stencil",Font.PLAIN,16));
		opcionB.setBackground(Color.BLACK);
		opcionB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{

				opcionA.setEnabled(false);
				opcionC.setEnabled(false);
				opcionD.setEnabled(false);
				moverseEntreRuletaYResponder(contenidoPartida);

			}
		});

		opcionA.setForeground(Color.WHITE);
		opcionA.setFont(new Font("Stencil",Font.PLAIN,16));
		opcionA.setBackground(Color.BLACK);
		opcionA.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{

				opcionB.setEnabled(false);
				opcionC.setEnabled(false);
				opcionD.setEnabled(false);
				moverseEntreRuletaYResponder(contenidoPartida);

			}
		});

		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0,0,5,5);
		gbc_lblA.gridx = 1;
		gbc_lblA.gridy = 3;
		lblA.setBackground(Color.BLACK);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setForeground(Color.WHITE);
		lblA.setFont(new Font("Stencil",Font.PLAIN,16));
		add(lblA,gbc_lblA);

		grupoRdionBotomns.add(opcionA);
		GridBagConstraints gbc_opcionA = new GridBagConstraints();
		gbc_opcionA.fill = GridBagConstraints.BOTH;
		gbc_opcionA.insets = new Insets(0,0,5,0);
		gbc_opcionA.gridx = 2;
		gbc_opcionA.gridy = 3;
		add(opcionA,gbc_opcionA);

		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.insets = new Insets(0,0,5,5);
		gbc_lblB.gridx = 1;
		gbc_lblB.gridy = 4;
		lblB.setFont(new Font("Stencil",Font.PLAIN,16));
		lblB.setBackground(Color.BLACK);
		lblB.setForeground(Color.WHITE);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblB,gbc_lblB);
		grupoRdionBotomns.add(opcionB);
		GridBagConstraints gbc_opcionB = new GridBagConstraints();
		gbc_opcionB.fill = GridBagConstraints.BOTH;
		gbc_opcionB.insets = new Insets(0,0,5,0);
		gbc_opcionB.gridx = 2;
		gbc_opcionB.gridy = 4;
		add(opcionB,gbc_opcionB);

		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.insets = new Insets(0,0,5,5);
		gbc_lblC.gridx = 1;
		gbc_lblC.gridy = 5;
		lblC.setBackground(Color.BLACK);
		lblC.setForeground(Color.WHITE);
		lblC.setFont(new Font("Stencil",Font.PLAIN,16));
		add(lblC,gbc_lblC);
		grupoRdionBotomns.add(opcionC);
		GridBagConstraints gbc_opcionC = new GridBagConstraints();
		gbc_opcionC.fill = GridBagConstraints.BOTH;
		gbc_opcionC.insets = new Insets(0,0,5,0);
		gbc_opcionC.gridx = 2;
		gbc_opcionC.gridy = 5;
		add(opcionC,gbc_opcionC);

		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.insets = new Insets(0,0,0,5);
		gbc_lblD.gridx = 1;
		gbc_lblD.gridy = 6;
		lblD.setForeground(Color.WHITE);
		lblD.setFont(new Font("Stencil",Font.PLAIN,18));
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBackground(Color.BLACK);
		add(lblD,gbc_lblD);
		grupoRdionBotomns.add(opcionD);
		GridBagConstraints gbc_opcionD = new GridBagConstraints();
		gbc_opcionD.fill = GridBagConstraints.BOTH;
		gbc_opcionD.gridx = 2;
		gbc_opcionD.gridy = 6;
		add(opcionD,gbc_opcionD);

	}

	public void moverseEntreRuletaYResponder(SuperPanel contenidoPartida)
	{
		try
		{
			Thread.sleep(1000);
			desplazarAotroPanel(contenidoPartida,"panelRuleta");
			restaurarValoresRuleta(contenidoPartida);
			revalidate();
			repaint();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
